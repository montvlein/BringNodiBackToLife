package test

import (
	"log"
	"bytes"
	"encoding/json"
	"net/http/httptest"
	"testing"
)

type Update struct {
	UpdateId int     `json:"update_id"`
	Message  Message `json:"message"`
}

type Message struct {
	Text     string   `json:"text"`
	Chat     Chat     `json:"chat"`
}

type Chat struct {
	Id int `json:"id"`
}

func parseTelegramRequest(r *http.Request) (*Update, error) {
	var update Update
	if err := json.NewDecoder(r.Body).Decode(&update); err != nil {
		log.Printf("could not decode incoming update %s", err.Error())
		return nil, err
	}
	return &update, nil
}

func TestParseUpdateMessageWithText(t *testing.T) {
	var msg = Message{
		Text: "hello world",
		Chat: chat,
	}

	var update = Update{
		UpdateId: 1,
		Message:  msg,
	}

	requestBody, err := json.Marshal(update)
	if err != nil {
		t.Errorf("Failed to marshal update in json, got %s", err.Error())
	}
	req := httptest.NewRequest("POST", "http://myTelegramWebHookHandler.com/secretToken", bytes.NewBuffer(requestBody))

	var updateToTest, errParse = parseTelegramRequest(req)
	if errParse != nil {
		t.Errorf("Expected a <nil> error, got %s", errParse.Error())
	}
	if *updateToTest != update {
		t.Errorf("Expected update %s, got %s", update, updateToTest)
	}

}
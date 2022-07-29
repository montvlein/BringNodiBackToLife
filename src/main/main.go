package main

import (
	"encoding/json"
	"log"
	"os"
	"net/http"
	"net/url"
	"io/ioutil"
	"strconv"
)

func main()  {
	http.HandleFunc("/", textHandle)

	log.Printf("Starting server at port 8080\n")
	if err := http.ListenAndServe(":8080", nil); err != nil {
		log.Fatal(err)
	}
}

func parseTelegramRequest(r *http.Request) (*Update, error) {
	var update Update
	if err := json.NewDecoder(r.Body).Decode(&update); err != nil {
		log.Printf("could not decode incoming update %s", err.Error())
		return nil, err
	}
	return &update, nil
}

func sendTextToTelegramChat(chatId int, text string) (string, error) {

	log.Printf("Sending %s to chat_id: %d", text, chatId)
	var telegramApi string = telegramApiBaseUrl + os.Getenv("TELEGRAM_BOT_TOKEN") + "/sendMessage"
	response, err := http.PostForm(
		telegramApi,
		url.Values{
			"chat_id": {strconv.Itoa(chatId)},
			"text":    {text},
		})

	if err != nil {
		log.Printf("error when posting text to the chat: %s", err.Error())
		return "", err
	}
	defer response.Body.Close()

	var bodyBytes, errRead = ioutil.ReadAll(response.Body)
	if errRead != nil {
		log.Printf("error in parsing telegram answer %s", errRead.Error())
		return "", err
	}
	bodyString := string(bodyBytes)
	log.Printf("Body of Telegram Response: %s", bodyString)

	return bodyString, nil
}

func textHandle(w http.ResponseWriter, r *http.Request) {
	log.Printf("%v",r)
	// Parse incoming request
	var update, err = parseTelegramRequest(r)
	if err != nil {
		log.Printf("error parsing update, %s", err.Error())
		return
	}

	var respuesta string
	switch update.Message.Text {
		case "hola":
			respuesta = "hola a ti tambien"
		case "chau":
			respuesta = "bye"
		default:
			respuesta = "no entiendo el mensaje"
	}

	// Send res to Telegram
	var telegramResponseBody, errTelegram = sendTextToTelegramChat(update.Message.Chat.Id, respuesta)
	if errTelegram != nil {
		log.Printf("got error %s from telegram, response body is %s", errTelegram.Error(), telegramResponseBody)
	}
}
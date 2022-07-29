package models

type Update struct {
	UpdateId int     `json:"update_id"`
	Message  Message `json:"message"`
}

type Message struct {
	Text     string    `json:"text"`
	Chat     string    `json:"chat_id"`
}
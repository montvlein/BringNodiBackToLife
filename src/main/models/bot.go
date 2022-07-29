package models

import (
	"bytes"
	"encoding/json"
	"log"
	"net/http"

	"github.com/montvlein/telegramBot/models"
)

type TelegramBot struct {
	Uri, Token string
}

func (bot TelegramBot) enviarMensaje(msg models.Message) {
	uriForSend := bot.Uri+bot.Token+"/sendMessage"
	json_data, err := json.Marshal( msg )
	if err != nil {
		log.Fatalf("error when parsing text to json: %s", err.Error())
	}
	response, err := http.Post(uriForSend,"application/json",bytes.NewBuffer(json_data))
	if err != nil {
		log.Fatalf("error when posting text to the chat: %s", err.Error())
	}
	defer response.Body.Close()
	if response.StatusCode == 200 {
		log.Printf("%v... mensaje enviado\n",response.Status)
	} else {
		log.Fatalf("error al intentar enviar mensaje: %v\n",response.Status)
	}

}
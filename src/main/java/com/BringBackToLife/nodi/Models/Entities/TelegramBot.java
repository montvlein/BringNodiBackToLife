package com.BringBackToLife.nodi.Models.Entities;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TelegramBot {

    private final String botUri ="https://api.telegram.org/bot";

    @Value("${telegram.token}")
    private String token;

    @Value("${telegram.chatId}")
    private String chat_id;

    RestTemplate restTemplate;
    HttpHeaders headers;

    public String getMe(){
        restTemplate = new RestTemplate();
        return restTemplate.getForObject(botUri+token + "/getMe", String.class);
    }

    public String sendMessage(String msg) {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject json = new JSONObject();
        json.put("chat_id", chat_id);
        json.put("text",msg);
        HttpEntity<String> request = new HttpEntity<>(json.toString() ,headers);
        return restTemplate.postForObject(botUri+token+"/sendMesssage", request, String.class);
    }
}

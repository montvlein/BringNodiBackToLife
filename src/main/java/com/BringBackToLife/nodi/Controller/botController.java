package com.BringBackToLife.nodi.Controller;

import com.BringBackToLife.nodi.Models.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bot")
public class botController {

    @Autowired
    private TelegramBot bot;

    @GetMapping("getMe")
    public ResponseEntity getMe() {
        return ResponseEntity.ok(bot.getMe());
    }

    @GetMapping("send")
    public ResponseEntity send(@RequestParam String msg) {
        return ResponseEntity.ok(bot.sendMessage(msg));
    }
}

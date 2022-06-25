package com.BringBackToLife.nodi.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }

    // a esta vista tiene que entrar con autorización
    @GetMapping("/user")
    public String user() {
        return "user";
    }
}

package edu.cibertec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RefugioController {
    @GetMapping("/refugio")
    public String refugioView() {
        return "RefugioView";
    }
}

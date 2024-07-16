package edu.cibertec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SesionController {
    @GetMapping("/form")
    public String showForm() {
        return "Sesion";
    }

    @PostMapping("/form")
    public String submitForm(@RequestParam("role") String role, Model model) {
        if ("admin".equalsIgnoreCase(role)) {
            return "redirect:/admin";
        } else if ("refugio".equalsIgnoreCase(role)) {
            return "redirect:/refugio";
        }
        return "redirect:/";
    }
}

package edu.cibertec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class SesionController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        Model model,
                        Principal principal,
                        RedirectAttributes flash) {
        if (principal != null) {
            flash.addFlashAttribute("info", "Ya estás logueado");
            return "redirect:/";
        }
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrecta, por favor vuelva a intentar");
        }
        return "Sesion";
    }

    @GetMapping("/SobreNosotros")
    public String sobreNosotros() {
        return "SobreNosotros";
    }
}

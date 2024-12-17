package edu.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.cibertec.models.Mascotas;
import edu.cibertec.models.Refugios;
import edu.cibertec.services.MascotasService;
import edu.cibertec.services.RefugiosService;

@Controller
public class AdminController {
    @Autowired
    private MascotasService mascotaService;

    @Autowired
    private RefugiosService refugioService;

    @GetMapping("/admin")
    public String adminView() {
        return "AdminView";
    }

    @GetMapping("/admin/reporteMascotas")
    public String reporteMascotas(Model model) {
        List<Mascotas> mascotas = mascotaService.listAll(null);
        model.addAttribute("listaMascotas", mascotas);
        return "ReporteMascotas";
    }

    @GetMapping("/admin/reporteRefugios")
    public String reporteRefugios(Model model) {
        List<Refugios> refugios = refugioService.listAll(null);
        model.addAttribute("refugios", refugios);
        return "ReporteRefugios";
    }
}

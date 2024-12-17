package edu.cibertec.controllers;

import edu.cibertec.models.Mascotas;
import edu.cibertec.models.Refugios;
import edu.cibertec.services.MascotasService;
import edu.cibertec.services.RefugiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/refugio")
public class RefugiosController {

    @Autowired
    private MascotasService mascotasService;

    @Autowired
    private RefugiosService refugiosService;

    @GetMapping
    public List<Refugios> getAllRefugios() {
        return refugiosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refugios> getRefugioById(@PathVariable Long id) {
        Optional<Refugios> refugio = refugiosService.findById(id);
        if (refugio.isPresent()) {
            return ResponseEntity.ok(refugio.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Refugios createRefugio(@RequestBody Refugios refugio) {
        return refugiosService.save(refugio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refugios> updateRefugio(@PathVariable Long id, @RequestBody Refugios refugioDetails) {
        Optional<Refugios> refugio = refugiosService.findById(id);
        if (refugio.isPresent()) {
            refugioDetails.setRefugio_id(id);
            return ResponseEntity.ok(refugiosService.save(refugioDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRefugio(@PathVariable Long id) {
        if (refugiosService.existsById(id)) {
            refugiosService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(Refugios.class, new RefugioEditor(refugiosService));
    }

    @GetMapping("/refugio")
    public String verPaginaDeInicioRefugio(Model model, String palabraClave) {
        List<Mascotas> listaMascotas = mascotasService.listAll(palabraClave);
        model.addAttribute("listaMascotas", listaMascotas);
        model.addAttribute("palabraClave", palabraClave);
        return "RefugioView";
    }

    @GetMapping("/reporteMascotas")
    public String reporteMascotas(Model model) {
        List<Mascotas> mascotas = mascotasService.listAll(null);
        model.addAttribute("listaMascotas", mascotas);
        return "ReporteMascotas";
    }
}
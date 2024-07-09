package edu.cibertec.controllers;

import edu.cibertec.models.Adopciones;
import edu.cibertec.services.AdopcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adopciones")
public class AdopcionesController {

    @Autowired
    private AdopcionesService adopcionesService;

    @GetMapping
    public List<Adopciones> getAllAdopciones() {
        return adopcionesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adopciones> getAdopcionById(@PathVariable Long id) {
        Optional<Adopciones> adopcion = adopcionesService.findById(id);
        if (adopcion.isPresent()) {
            return ResponseEntity.ok(adopcion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Adopciones createAdopcion(@RequestBody Adopciones adopcion) {
        return adopcionesService.save(adopcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adopciones> updateAdopcion(@PathVariable Long id, @RequestBody Adopciones adopcionDetails) {
        Optional<Adopciones> adopcion = adopcionesService.findById(id);
        if (adopcion.isPresent()) {
            adopcionDetails.setAdopcion_id(id);
            return ResponseEntity.ok(adopcionesService.save(adopcionDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdopcion(@PathVariable Long id) {
        if (adopcionesService.existsById(id)) {
            adopcionesService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

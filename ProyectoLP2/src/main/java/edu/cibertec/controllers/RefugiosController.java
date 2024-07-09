package edu.cibertec.controllers;

import edu.cibertec.models.Refugios;
import edu.cibertec.services.RefugiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/refugios")
public class RefugiosController {

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
}

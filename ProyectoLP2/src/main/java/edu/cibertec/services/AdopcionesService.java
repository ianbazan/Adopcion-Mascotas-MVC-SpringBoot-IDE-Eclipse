package edu.cibertec.services;

import edu.cibertec.models.Adopciones;
import edu.cibertec.repositories.AdopcionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdopcionesService {

    @Autowired
    private AdopcionesRepository adopcionesRepository;

    public List<Adopciones> findAll() {
        return adopcionesRepository.findAll();
    }

    public Optional<Adopciones> findById(Long id) {
        return adopcionesRepository.findById(id);
    }

    public Adopciones save(Adopciones adopcion) {
        return adopcionesRepository.save(adopcion);
    }

    public void deleteById(Long id) {
        adopcionesRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return adopcionesRepository.existsById(id);
    }
}

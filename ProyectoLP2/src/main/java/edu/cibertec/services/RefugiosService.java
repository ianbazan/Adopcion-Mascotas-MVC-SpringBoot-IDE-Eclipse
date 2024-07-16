package edu.cibertec.services;

import edu.cibertec.models.Refugios;
import edu.cibertec.repositories.RefugiosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefugiosService {

    @Autowired
    private RefugiosRepository refugiosRepository;

    public Optional<Refugios> findById(Long id) {
        return refugiosRepository.findById(id);
    }
    
    public List<Refugios> findAll() {
        return refugiosRepository.findAll();
    }

    public Refugios save(Refugios refugio) {
        return refugiosRepository.save(refugio);
    }

    public void deleteById(Long id) {
        refugiosRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return refugiosRepository.existsById(id);
    }

    public List<Refugios> listAll(String palabraCla) {
        if (palabraCla != null) {
            return refugiosRepository.findAll(palabraCla);
        }
        return refugiosRepository.findAll();
    }
}

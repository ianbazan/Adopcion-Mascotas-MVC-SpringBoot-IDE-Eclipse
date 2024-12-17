package edu.cibertec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.models.Mascotas;
import edu.cibertec.repositories.MascotasRepositorio;

@Service
public class MascotasService {

    @Autowired
    private MascotasRepositorio mascotasRepositorio;

    public List<Mascotas> listAll(String palabraclave) {
        if (palabraclave != null) {
            return mascotasRepositorio.findAll(palabraclave);
        }
        return mascotasRepositorio.findAll();
    }

    public Mascotas save(Mascotas mascota) {
        return mascotasRepositorio.save(mascota);
    }

    public Mascotas get(Long id) {
        return mascotasRepositorio.findById(id).orElse(null);
    }

    public void delete(Long id) {
        mascotasRepositorio.deleteById(id);
    }
}

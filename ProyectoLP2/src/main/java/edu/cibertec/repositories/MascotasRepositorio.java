package edu.cibertec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.cibertec.models.Mascotas;

public interface MascotasRepositorio extends JpaRepository<Mascotas, Long> {

	@Query("SELECT p FROM Mascotas p WHERE p.nombre LIKE %?1%"
			+ " OR p.especie LIKE %?1%"
			+ " OR p.raza LIKE %?1%")
	public List<Mascotas> findAll(String palabraClave);
}

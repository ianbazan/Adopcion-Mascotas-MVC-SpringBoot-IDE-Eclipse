package edu.cibertec.repositories;

import edu.cibertec.models.Refugios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RefugiosRepository extends JpaRepository<Refugios, Long> {

	@Query("SELECT r FROM Refugios r WHERE r.nombre LIKE %?1%")
	public List<Refugios> findAll(String palabraCla);
}

package edu.cibertec.repositories;

import edu.cibertec.models.Adopciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopcionesRepository extends JpaRepository<Adopciones, Long> {
}

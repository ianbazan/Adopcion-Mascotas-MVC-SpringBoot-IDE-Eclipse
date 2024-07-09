package edu.cibertec.repositories;

import edu.cibertec.models.Refugios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefugiosRepository extends JpaRepository<Refugios, Long> {
}

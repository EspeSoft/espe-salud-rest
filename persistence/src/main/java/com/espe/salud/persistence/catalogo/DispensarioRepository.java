package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.Dispensario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DispensarioRepository extends JpaRepository<Dispensario,Long> {

    Optional<Dispensario> findByCodigo(Long codigo);
}
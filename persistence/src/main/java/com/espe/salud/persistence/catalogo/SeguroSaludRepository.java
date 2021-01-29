package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.SeguroSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeguroSaludRepository extends JpaRepository<SeguroSalud, Long> {
    Optional<SeguroSalud> findByCodigo(Long codigo);
}

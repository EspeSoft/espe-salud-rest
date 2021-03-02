package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.ExamenSexual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamenSexualRepository extends JpaRepository<ExamenSexual, Long> {
    Optional<ExamenSexual> findByCodigo(Long codigo);
}

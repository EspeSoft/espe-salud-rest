package com.espe.salud.persistence.ocupacional;

import com.espe.salud.domain.entities.ocupacional.ActividadExtralaboral;
import com.espe.salud.domain.entities.ocupacional.AntecedenteLaboral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AntecedenteLaboralRepository extends JpaRepository<AntecedenteLaboral, Long> {
    Optional<AntecedenteLaboral> findByCodigo(Long codigo);
    AntecedenteLaboral findByPacienteCodigo(Long idPaciente);
}

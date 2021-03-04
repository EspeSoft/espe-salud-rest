package com.espe.salud.persistence.antecedente;


import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AntecedentePatologicoPersonalRepository extends JpaRepository<AntecedentePatologicoPersonal, Long> {
    Optional<AntecedentePatologicoPersonal> findByCodigo(Long codigo);

    List<AntecedentePatologicoPersonal> findByAntecedentePersonalPacienteCodigo(Long idPaciente);
}

package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AntecedentePatologicoFamiliarRepository extends JpaRepository<AntecedentePatologicoFamiliar,Long> {
    Optional<AntecedentePatologicoFamiliar> findByCodigo(Long codigo);

    List<AntecedentePatologicoFamiliar> findByIdAntecedentePersonal(Long idAntecedentePersonal);
}
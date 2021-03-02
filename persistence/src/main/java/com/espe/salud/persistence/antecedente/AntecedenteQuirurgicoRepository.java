package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedenteQuirurgico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AntecedenteQuirurgicoRepository extends JpaRepository<AntecedenteQuirurgico,Long> {
    Optional<AntecedenteQuirurgico> findByCodigo(Long codigo);

    List<AntecedenteQuirurgico> findByIdAntecedentePersonal(Long idAntecedentePersonal);
}
package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.Discapacidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiscapacidadRepository extends JpaRepository<Discapacidad, Long> {
    Optional<Discapacidad> findByCodigo(Long codigo);

    List<Discapacidad> findByIdAntecedentePersonal(Long idAntecedentePersonal);
}
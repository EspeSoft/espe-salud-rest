package com.espe.salud.persistence.odontologia;

import com.espe.salud.domain.entities.odontologia.ExamenSistemaEstomatognatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamenSistemaEstomatognaticoRepository extends JpaRepository<ExamenSistemaEstomatognatico, Long> {

    Optional<ExamenSistemaEstomatognatico> findByCodigo(Long codigo);

    List<ExamenSistemaEstomatognatico> findByHistoriaCodigo(Long idHistoria);

}

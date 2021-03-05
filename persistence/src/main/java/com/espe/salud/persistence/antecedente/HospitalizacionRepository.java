package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.Hospitalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalizacionRepository extends JpaRepository<Hospitalizacion, Long> {
    Optional<Hospitalizacion> findByCodigo(Long codigo);
    List<Hospitalizacion> findByPacienteCodigo(Long idPaciente);
}

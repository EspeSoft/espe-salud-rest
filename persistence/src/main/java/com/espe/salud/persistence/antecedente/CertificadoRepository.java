package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {
    Optional<Certificado> findByCodigo(Long codigo);
    List<Certificado> findAllByCodigo(Long codigo);
}

package com.espe.salud.persistence.catalogo;


import com.espe.salud.domain.entities.catalogo.RepertorioMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepertorioMedicamentoRepository extends JpaRepository<RepertorioMedicamento, Long> {
    List<RepertorioMedicamento> findAllByOrderByNombreAsc();
    Optional<RepertorioMedicamento> findByCodigo(Long codigo);
}

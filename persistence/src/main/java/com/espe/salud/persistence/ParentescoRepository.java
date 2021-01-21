package com.espe.salud.persistence;

import com.espe.salud.domain.Parentesco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParentescoRepository extends JpaRepository<Parentesco, Long> {
    List<Parentesco> findAllByOrderByNombreAsc();
    Optional<Parentesco> findByCodigo(Long codigo);
}

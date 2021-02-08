package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SedeRepository extends JpaRepository<Sede,Long> {
    Optional<Sede> findByCodigo(Long codigo);


}
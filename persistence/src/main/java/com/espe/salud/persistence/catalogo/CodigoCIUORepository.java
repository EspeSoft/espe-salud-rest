package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.CodigoCIUO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodigoCIUORepository extends JpaRepository<CodigoCIUO, String> {
    List<CodigoCIUO> findByCodigoStartingWithOrDescripcionStartingWith(String codigo, String descripcion);

    Optional<CodigoCIUO> findByCodigo(String codigo);
}

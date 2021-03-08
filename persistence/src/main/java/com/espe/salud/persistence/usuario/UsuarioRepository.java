package com.espe.salud.persistence.usuario;

import com.espe.salud.domain.entities.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByPidm(Long pidm);

    List<Usuario> findAllByOrderByNombresAsc();
}

package com.espe.salud.service.usuario;

import com.espe.salud.domain.entities.usuario.Usuario;
import com.espe.salud.dto.usuario.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<UsuarioDTO> findById(Long pidm);
    UsuarioDTO save(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> findAll();
    boolean delete(Long pidm);

    UsuarioDTO toDTO(Usuario usuario);
    Usuario toEntity(UsuarioDTO dto);
}

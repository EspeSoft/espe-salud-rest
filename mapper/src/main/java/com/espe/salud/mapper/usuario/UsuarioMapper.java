package com.espe.salud.mapper.usuario;

import com.espe.salud.domain.entities.usuario.Usuario;
import com.espe.salud.dto.usuario.UsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AreaSaludMapper.class})
public interface UsuarioMapper {

    UsuarioDTO toUsuarioDTO(Usuario usuario);

    List<UsuarioDTO> toUsuariosDTO(List<Usuario> usuarios);

    Usuario toUsuario(UsuarioDTO dto);
}

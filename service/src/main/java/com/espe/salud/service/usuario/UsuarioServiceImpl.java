package com.espe.salud.service.usuario;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.usuario.Usuario;
import com.espe.salud.dto.usuario.UsuarioDTO;
import com.espe.salud.mapper.usuario.UsuarioMapper;
import com.espe.salud.persistence.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository,
                              UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findById(Long pidm) {
        return repository.findByPidm(pidm).map(this::toDTO);
    }

    @Override
    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Optional<Usuario> optional = repository.findByPidm(usuarioDTO.getPidm());
        if (optional.isEmpty()) {
            Usuario domainObject = toEntity(usuarioDTO);
            return toDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un usuario registrado para ese código[%s]", usuarioDTO.getPidm()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return mapper.toUsuariosDTO(repository.findAllByOrderByNombresAsc());
    }

    @Override
    @Transactional
    public boolean delete(Long pidm) {
        return repository.findById(pidm).map(notaEnfermeria -> {
            repository.deleteById(pidm);
            return true;
        }).orElse(false);
    }

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        return mapper.toUsuarioDTO(usuario);
    }

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        return mapper.toUsuario(dto);
    }
}

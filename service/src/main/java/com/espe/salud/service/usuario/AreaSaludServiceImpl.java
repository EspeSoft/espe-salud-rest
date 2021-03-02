package com.espe.salud.service.usuario;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.usuario.AreaSalud;
import com.espe.salud.dto.usuario.AreaSaludDTO;
import com.espe.salud.mapper.usuario.AreaSaludMapper;
import com.espe.salud.persistence.usuario.AreaSaludRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AreaSaludServiceImpl implements AreaSaludService{
    private final AreaSaludRepository repository;
    private final AreaSaludMapper mapper;

    @Autowired
    public AreaSaludServiceImpl(AreaSaludRepository repository, AreaSaludMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<AreaSaludDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Override
    @Transactional
    public AreaSaludDTO save(AreaSaludDTO areaSaludDTO) {
        Optional<AreaSalud> optional = repository.findByCodigo(areaSaludDTO.getId());
        if (optional.isEmpty()) {
            AreaSalud domainObject = toEntity(areaSaludDTO);
            return toDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un area de salud registrado para ese código[%s]", areaSaludDTO.getId()));
        }
    }

    @Override
    public List<AreaSaludDTO> findAll() {
        return mapper.toAreasSaludDTO(repository.findAllByOrderByNombreAsc());
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return repository.findById(id).map(areaSalud -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public AreaSaludDTO toDTO(AreaSalud areaSalud) {
        return mapper.toAreaSaludDTO(areaSalud);
    }

    @Override
    public AreaSalud toEntity(AreaSaludDTO dto) {
        return mapper.toAreaSalud(dto);
    }
}

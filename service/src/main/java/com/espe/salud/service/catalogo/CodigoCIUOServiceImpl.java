package com.espe.salud.service.catalogo;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.CodigoCIUO;
import com.espe.salud.dto.catalogo.CodigoCIUODTO;
import com.espe.salud.mapper.catalogo.CodigoCIUOMapper;
import com.espe.salud.persistence.catalogo.CodigoCIUORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CodigoCIUOServiceImpl implements CodigoCIUOService {

    private final CodigoCIUORepository repository;
    private final CodigoCIUOMapper mapper;

    @Autowired
    public CodigoCIUOServiceImpl(CodigoCIUORepository repository,
                                 CodigoCIUOMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CodigoCIUODTO> findAll() {
        return mapper.toCodigosCIUODTO((List<CodigoCIUO>) repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CodigoCIUODTO> findByCodigoOrDescription(String query) {
        return mapper.toCodigosCIUODTO(repository.findByCodigoStartingWithOrDescripcionStartingWith(query, query));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CodigoCIUODTO> findById(String id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Override
    public CodigoCIUODTO save(CodigoCIUODTO codigoCIUO) {
        Optional<CodigoCIUO> optional = repository.findByCodigo(codigoCIUO.getCodigo());
        if (optional.isEmpty()) {
            CodigoCIUO domainObject = toEntity(codigoCIUO);
            return toDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un registro para ese código[%s]", codigoCIUO.getCodigo()));
        }
    }

    @Override
    public CodigoCIUODTO toDTO(CodigoCIUO codigoCIUO) {
        return mapper.toCodigoCIUODTO(codigoCIUO);
    }

    @Override
    public CodigoCIUO toEntity(CodigoCIUODTO dto) {
        return mapper.toCodigoCIUO(dto);
    }
}

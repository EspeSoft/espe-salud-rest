package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.mapper.evolucion.EvolucionMapper;
import com.espe.salud.persistence.evolucion.EvolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EvolucionServiceImpl implements EvolucionService {

    private final EvolucionRepository evolucionRepository;
    private final EvolucionMapper mapper;

    @Autowired
    public EvolucionServiceImpl(EvolucionRepository evolucionRepository,
                                EvolucionMapper mapper) {
        this.evolucionRepository = evolucionRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public EvolucionDTO save(EvolucionDTO evolucion) {
        Optional<Evolucion> optional = findExisting(evolucion);
        if (!optional.isPresent()) {
            Evolucion domainObject = toEntity(evolucion);
            return toDTO(evolucionRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una evolucion registrada para ese código[%s]", evolucion.getId()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Evolucion> findExisting(EvolucionDTO evolucionDTO) {
        return evolucionRepository.findByCodigo(evolucionDTO.getId());
    }

    @Override
    public EvolucionDTO toDTO(Evolucion evolucion) {
        return mapper.toEvolucionDTO(evolucion);
    }

    @Override
    public Evolucion toEntity(EvolucionDTO dto) {
        return mapper.toEvolucion(dto);
    }
}

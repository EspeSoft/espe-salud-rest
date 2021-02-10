package com.espe.salud.service.catalogo;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.ConsumoNocivo;
import com.espe.salud.dto.catalogo.ConsumoNocivoDTO;
import com.espe.salud.mapper.catalogo.ConsumoNocivoMapper;
import com.espe.salud.persistence.catalogo.ConsumoNocivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumoNocivoServiceImpl implements ConsumoNocivoService {

    private final ConsumoNocivoRepository domainRepository;

    private final ConsumoNocivoMapper mapper;

    @Autowired
    public ConsumoNocivoServiceImpl(ConsumoNocivoRepository domainRepository,
                                             ConsumoNocivoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConsumoNocivoDTO> findById(Long id) {
        return domainRepository.findById(id).map(this::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ConsumoNocivoDTO> findAllOrderByNombreASC() {
        return mapper.toConsumosNocivosDTO(domainRepository.findAllByOrderByNombreAsc());
    }

    @Override
    @Transactional
    public ConsumoNocivoDTO save(ConsumoNocivoDTO consumoNocivoDTO) {
        Optional<ConsumoNocivo> optional = domainRepository.findByCodigo(consumoNocivoDTO.getId());
        if (optional.isEmpty()) {
            ConsumoNocivo domainObject = toEntity(consumoNocivoDTO);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un consumo nocivo para ese código[%s]", consumoNocivoDTO.getId()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ConsumoNocivoDTO> findByNombreStartingWith(String nombre) {
        return mapper.toConsumosNocivosDTO(domainRepository.findByNombreStartingWith(nombre));
    }

    @Override
    public ConsumoNocivoDTO toDTO(ConsumoNocivo consumoNocivo) {
        return mapper.toConsumoNocivoDTO(consumoNocivo);
    }

    @Override
    public ConsumoNocivo toEntity(ConsumoNocivoDTO dto) {
        return mapper.toConsumoNocivo(dto);
    }
}

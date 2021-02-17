package com.espe.salud.service.catalogo;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.TipoConsumoNocivo;
import com.espe.salud.dto.catalogo.TipoConsumoNocivoDTO;
import com.espe.salud.mapper.catalogo.TipoConsumoNocivoMapper;
import com.espe.salud.persistence.catalogo.TipoConsumoNocivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoConsumoNocivoServiceImpl implements TipoConsumoNocivoService {

    private final TipoConsumoNocivoRepository domainRepository;

    private final TipoConsumoNocivoMapper mapper;

    @Autowired
    public TipoConsumoNocivoServiceImpl(TipoConsumoNocivoRepository domainRepository,
                                        TipoConsumoNocivoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoConsumoNocivoDTO> findById(Long id) {
        return domainRepository.findById(id).map(this::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoConsumoNocivoDTO> findAllOrderByNombreASC() {
        return mapper.toConsumosNocivosDTO(domainRepository.findAllByOrderByNombreAsc());
    }

    @Override
    @Transactional
    public TipoConsumoNocivoDTO save(TipoConsumoNocivoDTO tipoConsumoNocivoDTO) {
        Optional<TipoConsumoNocivo> optional = domainRepository.findByCodigo(tipoConsumoNocivoDTO.getId());
        if (optional.isEmpty()) {
            TipoConsumoNocivo domainObject = toEntity(tipoConsumoNocivoDTO);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un consumo nocivo para ese código[%s]", tipoConsumoNocivoDTO.getId()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoConsumoNocivoDTO> findByNombreStartingWith(String nombre) {
        return mapper.toConsumosNocivosDTO(domainRepository.findByNombreStartingWith(nombre));
    }

    @Override
    public TipoConsumoNocivoDTO toDTO(TipoConsumoNocivo tipoConsumoNocivo) {
        return mapper.toConsumoNocivoDTO(tipoConsumoNocivo);
    }

    @Override
    public TipoConsumoNocivo toEntity(TipoConsumoNocivoDTO dto) {
        return mapper.toConsumoNocivo(dto);
    }
}

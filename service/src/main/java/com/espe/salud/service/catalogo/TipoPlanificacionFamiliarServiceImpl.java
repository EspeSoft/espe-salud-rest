package com.espe.salud.service.catalogo;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.TipoPlanificacionFamiliar;
import com.espe.salud.domain.enums.SexoTipoPlanificacionFamiliar;
import com.espe.salud.dto.catalogo.TipoPlanificacionFamiliarDTO;
import com.espe.salud.mapper.catalogo.TipoPlanificacionFamiliarMapper;
import com.espe.salud.persistence.catalogo.TipoPlanificacionFamiliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPlanificacionFamiliarServiceImpl implements TipoPlanificacionFamiliarService {

    private final TipoPlanificacionFamiliarRepository repository;
    private final TipoPlanificacionFamiliarMapper mapper;

    @Autowired
    public TipoPlanificacionFamiliarServiceImpl(TipoPlanificacionFamiliarRepository repository,
                                                TipoPlanificacionFamiliarMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public TipoPlanificacionFamiliarDTO save(TipoPlanificacionFamiliarDTO dto) {
        Optional<TipoPlanificacionFamiliar> optional = repository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            TipoPlanificacionFamiliar domainObject = toEntity(dto);
            return toDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un tipo de planificación para ese código[%s]", dto.getId()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoPlanificacionFamiliarDTO> findAll() {
        return mapper.toTiposPlanificacionFamiliarDTO(repository.findAllByOrderByNombreAsc());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoPlanificacionFamiliarDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoPlanificacionFamiliarDTO> findAllMujeres() {
        return mapper.toTiposPlanificacionFamiliarDTO(
                repository.findBySexoOrSexoOrderByNombreAsc(SexoTipoPlanificacionFamiliar.AMBOS, SexoTipoPlanificacionFamiliar.MUJER));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoPlanificacionFamiliarDTO> findAllHombres() {
        return mapper.toTiposPlanificacionFamiliarDTO(
                repository.findBySexoOrSexoOrderByNombreAsc(SexoTipoPlanificacionFamiliar.AMBOS, SexoTipoPlanificacionFamiliar.HOMBRE));
    }

    @Override
    public TipoPlanificacionFamiliarDTO toDTO(TipoPlanificacionFamiliar planificacionFamiliar) {
        return mapper.toTipoPlanificacionFamiliarDTO(planificacionFamiliar);
    }

    @Override
    public TipoPlanificacionFamiliar toEntity(TipoPlanificacionFamiliarDTO dto) {
        return mapper.toTipoPlanificacionFamiliar(dto);
    }
}

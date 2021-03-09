package com.espe.salud.service.catalogo;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.TipoExamenSexual;
import com.espe.salud.domain.enums.SexoTipoPlanificacionFamiliar;
import com.espe.salud.dto.catalogo.TipoExamenSexualDTO;
import com.espe.salud.mapper.catalogo.TipoExamenSexualMapper;
import com.espe.salud.persistence.catalogo.TipoExamenSexualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoExamenSexualServiceImpl implements TipoExamenSexualService {

    private final TipoExamenSexualRepository repository;
    private final TipoExamenSexualMapper mapper;

    @Autowired
    public TipoExamenSexualServiceImpl(TipoExamenSexualRepository repository, TipoExamenSexualMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public TipoExamenSexualDTO save(TipoExamenSexualDTO dto) {
        Optional<TipoExamenSexual> optional = repository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            TipoExamenSexual domainObject = mapper.toTipoExamenSexual(dto);
            return mapper.toTipoExamenSexualDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un examen sexual para ese código[%s]", dto.getId()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoExamenSexualDTO> findAll() {
        return mapper.toTiposExamenesDTO(repository.findAllByOrderByNombreAsc());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoExamenSexualDTO> findById(Long id) {
        return repository.findByCodigo(id).map(mapper::toTipoExamenSexualDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoExamenSexualDTO> findAllMujeres() {
        return mapper.toTiposExamenesDTO(
                repository.findBySexoOrSexoOrderByNombreAsc(SexoTipoPlanificacionFamiliar.AMBOS, SexoTipoPlanificacionFamiliar.MUJER));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoExamenSexualDTO> findAllHombres() {
        return mapper.toTiposExamenesDTO(
                repository.findBySexoOrSexoOrderByNombreAsc(SexoTipoPlanificacionFamiliar.AMBOS, SexoTipoPlanificacionFamiliar.HOMBRE));
    }
}

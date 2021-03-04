package com.espe.salud.service.catalogo;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.GrupoEnfermedad;
import com.espe.salud.dto.catalogo.GrupoEnfermedadDTO;
import com.espe.salud.mapper.catalogo.GrupoEnfermedadMapper;
import com.espe.salud.persistence.catalogo.GrupoEnfermedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoEnfermedadServiceImpl implements GrupoEnfermedadService {
    private final GrupoEnfermedadRepository grupoEnfermedadRepository;
    private final GrupoEnfermedadMapper mapper;

    @Autowired
    public GrupoEnfermedadServiceImpl(GrupoEnfermedadRepository grupoEnfermedadRepository, GrupoEnfermedadMapper mapper) {
        this.grupoEnfermedadRepository = grupoEnfermedadRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GrupoEnfermedadDTO> findById(String id) {
        return grupoEnfermedadRepository.findById(id).map(mapper::toGrupoEnfermedadDTO);
    }

    @Override
    @Transactional
    public GrupoEnfermedadDTO save(GrupoEnfermedadDTO grupoEnfermedadDTO) {
        Optional<GrupoEnfermedad> optional = grupoEnfermedadRepository.findByCodigo(grupoEnfermedadDTO.getCodigo());
        if (optional.isEmpty()) {
            GrupoEnfermedad domainObject = mapper.toGrupoEnfermedad(grupoEnfermedadDTO);
            return mapper.toGrupoEnfermedadDTO(grupoEnfermedadRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un grupo de enfermedad para ese código[%s]", grupoEnfermedadDTO.getCodigo()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<GrupoEnfermedadDTO> findAll() {
        return mapper.toGrupoEnfermedadesDTO(grupoEnfermedadRepository.findAllByOrderByNombreAsc());
    }
}

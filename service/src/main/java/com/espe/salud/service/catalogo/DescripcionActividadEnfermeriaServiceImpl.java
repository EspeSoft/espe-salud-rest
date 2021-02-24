package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.DescripcionActividadEnfermeria;
import com.espe.salud.dto.catalogo.DescripcionActividadEnfermeriaDTO;
import com.espe.salud.mapper.catalogo.DescripcionActividadEnfermeriaMapper;
import com.espe.salud.persistence.catalogo.DescripcionActividadEnfermeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescripcionActividadEnfermeriaServiceImpl implements DescripcionActividadEnfermeriaService {

    private final DescripcionActividadEnfermeriaMapper mapper;
    private final DescripcionActividadEnfermeriaRepository repository;

    @Autowired
    public DescripcionActividadEnfermeriaServiceImpl(DescripcionActividadEnfermeriaMapper mapper, DescripcionActividadEnfermeriaRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Optional<DescripcionActividadEnfermeriaDTO> findById(Long id) {
        return repository.findByCodigo(id).map(this::toDTO);
    }

    @Override
    public List<DescripcionActividadEnfermeriaDTO> findAllOrderByNombreASC() {
        return mapper.toDescripcionesActividadEnfermeriaDTO(repository.findAllByOrderByNombreAsc());
    }

    @Override
    public DescripcionActividadEnfermeriaDTO toDTO(DescripcionActividadEnfermeria descripcionActividadEnfermeria) {
        return mapper.toDescripcionActividadEnfermeriaDTO(descripcionActividadEnfermeria);
    }

    @Override
    public DescripcionActividadEnfermeria toEntity(DescripcionActividadEnfermeriaDTO dto) {
        return mapper.toDescripcionActividadEnfermeria(dto);
    }

}

package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoActividadEnfermeria;
import com.espe.salud.dto.catalogo.TipoActividadEnfermeriaDTO;
import com.espe.salud.mapper.catalogo.TipoActividadEnfermeriaMapper;
import com.espe.salud.persistence.catalogo.TipoActividadEnfermeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoActividadEnfermeriaServiceImpl implements TipoActividadEnfermeriaService{
    private final TipoActividadEnfermeriaMapper mapper;
    private final TipoActividadEnfermeriaRepository repository;

    @Autowired
    public TipoActividadEnfermeriaServiceImpl(TipoActividadEnfermeriaMapper mapper, TipoActividadEnfermeriaRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Optional<TipoActividadEnfermeriaDTO> findById(Long id) {
        return repository.findByCodigo(id).map(this::toDTO);
    }

    @Override
    public List<TipoActividadEnfermeriaDTO> findAllOrderByNombreASC() {
        return mapper.toTipoActividadesEnfermeriasDTO(repository.findAllByOrderByNombreAsc());
    }

    @Override
    public TipoActividadEnfermeriaDTO toDTO(TipoActividadEnfermeria tipoActividadEnfermeria) {
        return mapper.toTipoActividadEnfermeriaDTO(tipoActividadEnfermeria);
    }

    @Override
    public TipoActividadEnfermeria toEntity(TipoActividadEnfermeriaDTO dto) {
        return mapper.toTipoActividadEnfermeria(dto);
    }
}

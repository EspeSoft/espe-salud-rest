package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.dto.catalogo.DispensarioDTO;
import com.espe.salud.mapper.catalogo.DispensarioMapper;
import com.espe.salud.persistence.catalogo.DispensarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispensarioServiceImpl implements DispensarioService {

    private final DispensarioRepository domainRepository;
    private final DispensarioMapper mapper;

    @Autowired
    public DispensarioServiceImpl(DispensarioRepository domainRepository, DispensarioMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DispensarioDTO> findById(Long codigo) {
        return domainRepository.findByCodigo(codigo).map(dispensario -> toDTO(dispensario));
    }

    @Override
    public Optional<DispensarioDTO> findByNombre(String nombre) {
        return domainRepository.findByNombreImagen(nombre).map(dispensario -> toDTO(dispensario));
    }

    @Override
    public List<DispensarioDTO> findAll() {
        return mapper.toDispensarioDTO(domainRepository.findAll());
    }

    @Override
    public DispensarioDTO toDTO(Dispensario dispensario) {
        return mapper.toDispensarioDTO(dispensario);
    }

    @Override
    public Dispensario toEntity(DispensarioDTO dto) {
        return mapper.toDispensario(dto);
    }
}
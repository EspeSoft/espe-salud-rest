package com.espe.salud.service.catalogo;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.NacionalidadPueblo;
import com.espe.salud.dto.catalogo.NacionalidadPuebloDTO;
import com.espe.salud.mapper.catalogo.NacionalidadPuebloMapper;
import com.espe.salud.persistence.catalogo.NacionalidadPuebloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NacionalidadPuebloServiceImpl implements NacionalidadPuebloService {

    private final NacionalidadPuebloRepository repository;
    private final NacionalidadPuebloMapper mapper;

    @Autowired
    public NacionalidadPuebloServiceImpl(NacionalidadPuebloRepository repository,
                                         NacionalidadPuebloMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public NacionalidadPuebloDTO save(NacionalidadPuebloDTO nacionalidadPuebloDTO) {
        Optional<NacionalidadPueblo> optional = repository.findByCodigo(nacionalidadPuebloDTO.getId());
        if (optional.isEmpty()) {
            NacionalidadPueblo domainObject = toEntity(nacionalidadPuebloDTO);
            return toDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una nacionalidad o pueblo registrada para ese código[%s]", nacionalidadPuebloDTO.getId()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<NacionalidadPuebloDTO> findAllOrderByNombreASC() {
        return mapper.toNacionalidadesPueblosDTO(repository.findAllByOrderByNombreAsc());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NacionalidadPuebloDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NacionalidadPuebloDTO> findByGrupoCulturalId(Long idGrupoCultural) {
        return null; // TODO FInalizar la implemntacion
    }

    @Override
    public NacionalidadPuebloDTO toDTO(NacionalidadPueblo nacionalidadPueblo) {
        return mapper.toNacionalidadPuebloDTO(nacionalidadPueblo);
    }

    @Override
    public NacionalidadPueblo toEntity(NacionalidadPuebloDTO dto) {
        return mapper.toNacionalidadPueblo(dto);
    }
}

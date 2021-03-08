package com.espe.salud.service.ocupacional;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.ocupacional.ActividadExtralaboral;
import com.espe.salud.domain.entities.ocupacional.ActividadExtralaboral;
import com.espe.salud.dto.ocupacional.ActividadExtralaboralDTO;
import com.espe.salud.mapper.ocupacional.ActividadExtralaboralMapper;
import com.espe.salud.persistence.ocupacional.ActividadExtralaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("actividadExtraLaboralServiceImpl")
public class ActividadExtralaboralServiceImpl implements ActividadExtralaboralService {

    private final ActividadExtralaboralRepository repository;
    private final ActividadExtralaboralMapper mapper;

    @Autowired
    public ActividadExtralaboralServiceImpl(ActividadExtralaboralRepository repository, ActividadExtralaboralMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ActividadExtralaboralDTO save(ActividadExtralaboralDTO actividad) {
        Optional<ActividadExtralaboral> optional = repository.findByCodigo(actividad.getId());
        if (!optional.isPresent()) {
            ActividadExtralaboral domainObject = toEntity(actividad);
            return toDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una actividad extralaboral para ese código[%s]", actividad.getId()));
        }
    }

    @Override
    public ActividadExtralaboralDTO update(ActividadExtralaboralDTO actividad) {
        ActividadExtralaboral domainObject = toEntity(actividad);
        return toDTO(repository.save(domainObject));
    }

    @Override
    public Boolean delete(Long id) {
        return repository.findById(id).map(object -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<ActividadExtralaboralDTO> findByCodigo(Long codigo) {
        return repository.findByCodigo(codigo).map(antecedente -> mapper.toActividadExtralaboralDto(antecedente));
    }

    @Override
    public List<ActividadExtralaboralDTO> findByAntecedenteLaboral(Long idAntecedenteLaboral) {
        return mapper.toActividadesExtralaboralesDto(repository.findByAntecedenteLaboralCodigo(idAntecedenteLaboral));
    }

    @Override
    public ActividadExtralaboralDTO toDTO(ActividadExtralaboral actividad) {
        return mapper.toActividadExtralaboralDto(actividad);
    }

    @Override
    public ActividadExtralaboral toEntity(ActividadExtralaboralDTO dto) {
        return mapper.toActividadExtralaboral(dto);
    }

}

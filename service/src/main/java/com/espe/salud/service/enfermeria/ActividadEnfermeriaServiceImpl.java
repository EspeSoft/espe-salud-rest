package com.espe.salud.service.enfermeria;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.enfermeria.ActividadEnfermeria;
import com.espe.salud.dto.enfermeria.ActividadEnfermeriaDTO;
import com.espe.salud.mapper.enfermeria.ActividadEnfermeriaMapper;
import com.espe.salud.persistence.enfermeria.ActividadEnfermeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActividadEnfermeriaServiceImpl implements ActividadEnfermeriaService{

    private final ActividadEnfermeriaRepository actividadEnfermeriaRepository;
    private final ActividadEnfermeriaMapper actividadEnfermeriaMapper;

    @Autowired
    public ActividadEnfermeriaServiceImpl(ActividadEnfermeriaRepository actividadEnfermeriaRepository, ActividadEnfermeriaMapper actividadEnfermeriaMapper) {
        this.actividadEnfermeriaRepository = actividadEnfermeriaRepository;
        this.actividadEnfermeriaMapper = actividadEnfermeriaMapper;
    }

    @Override
    public ActividadEnfermeriaDTO save(ActividadEnfermeriaDTO actividadEnfermeria) {
        Optional<ActividadEnfermeria> optional = actividadEnfermeriaRepository.findByCodigo(actividadEnfermeria.getId());
        if (optional.isEmpty()) {
            ActividadEnfermeria domain = toEntity(actividadEnfermeria);
            return toDTO(actividadEnfermeriaRepository.save(domain));
        } else {
            throw new ConflictException(String.format("Ya existe una actividad de enfermería registrada para ese código[%s]", actividadEnfermeria.getId()));
        }
    }

    @Override
    public Optional<ActividadEnfermeriaDTO> findById(Long codigo) {
        return actividadEnfermeriaRepository.findById(codigo).map(this::toDTO);
    }

//    @Override
//    public List<ActividadEnfermeriaDTO> findByUsuario(Long pidm) {
//        return actividadEnfermeriaMapper.toActividadesEnfermeriasDTO(actividadEnfermeriaRepository.findByUsuarioPidmOrderByFechaInicio(pidm));
//    }

    @Override
    public ActividadEnfermeriaDTO toDTO(ActividadEnfermeria notaEnfermeria) {
        return actividadEnfermeriaMapper.toActividadEnfermeriaDTO(notaEnfermeria);
    }

    @Override
    public ActividadEnfermeria toEntity(ActividadEnfermeriaDTO dto) {
        return actividadEnfermeriaMapper.toActividadEnfermeria(dto);
    }

    @Override
    public ActividadEnfermeriaDTO update(ActividadEnfermeriaDTO actividadEnfermeriaDTO) {
        ActividadEnfermeria domainObject = toEntity(actividadEnfermeriaDTO);
        return toDTO(actividadEnfermeriaRepository.save(domainObject));
    }

    @Override
    public List<ActividadEnfermeriaDTO> findAll() {
        List<ActividadEnfermeria> actividadFisicas = new ArrayList<>(actividadEnfermeriaRepository.findAll());
        return actividadEnfermeriaMapper.toActividadesEnfermeriasDTO(actividadFisicas);
    }


    @Override
    @Transactional
    public Boolean delete(Long id) {
        return actividadEnfermeriaRepository.findById(id).map(actividadEnfermeria -> {
            actividadEnfermeriaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

}

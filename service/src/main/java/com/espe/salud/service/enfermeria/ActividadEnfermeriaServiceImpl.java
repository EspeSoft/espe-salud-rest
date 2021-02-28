package com.espe.salud.service.enfermeria;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.enfermeria.ActividadEnfermeria;
import com.espe.salud.dto.enfermeria.ActividadEnfermeriaDTO;
import com.espe.salud.mapper.enfermeria.ActividadEnfermeriaMapper;
import com.espe.salud.persistence.enfermeria.ActividadEnfermeriaRepository;
import com.espe.salud.service.catalogo.DescripcionActividadEnfermeriaService;
import com.espe.salud.service.catalogo.TipoActividadEnfermeriaService;
import com.espe.salud.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ActividadEnfermeriaServiceImpl implements ActividadEnfermeriaService{

    private final ActividadEnfermeriaRepository repository;
    private final ActividadEnfermeriaMapper mapper;
    private final UsuarioService service;
    private final TipoActividadEnfermeriaService serviceTip;

    @Autowired
    public ActividadEnfermeriaServiceImpl(ActividadEnfermeriaRepository repository, ActividadEnfermeriaMapper mapper, UsuarioService service, TipoActividadEnfermeriaService serviceTip) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
        this.serviceTip = serviceTip;
    }

    @Override
    public ActividadEnfermeriaDTO save(ActividadEnfermeriaDTO actividadEnfermeria) {
        Optional<ActividadEnfermeria> optional = repository.findByCodigo(actividadEnfermeria.getId());
        if (optional.isEmpty()) {
            ActividadEnfermeria domain = toEntity(actividadEnfermeria);
            ActividadEnfermeriaDTO enfermeria = mapper.toActividadEnfermeriaDTO(repository.save(domain));
            enfermeria.setUsuario(service.findById(enfermeria.getIdUsuario()).get());
            enfermeria.setTipoActividadEnfermeria(serviceTip.findById(enfermeria.getIdTipoActividadEnfermeria()).get());
            return enfermeria;
        } else {
            throw new ConflictException(String.format("Ya existe una actividad de enfermería registrada para ese código[%s]", actividadEnfermeria.getId()));
        }
    }

    @Override
    public Optional<ActividadEnfermeriaDTO> findById(Long codigo) {
        return repository.findById(codigo).map(this::toDTO);
    }

    @Override
    public List<ActividadEnfermeriaDTO> findByUsuario(Long pidm) {
        return mapper.toActividadesEnfermeriasDTO(repository.findByUsuarioPidm(pidm));
    }

    @Override
    public ActividadEnfermeriaDTO toDTO(ActividadEnfermeria notaEnfermeria) {
        return mapper.toActividadEnfermeriaDTO(notaEnfermeria);
    }

    @Override
    public ActividadEnfermeria toEntity(ActividadEnfermeriaDTO dto) {
        return mapper.toActividadEnfermeria(dto);
    }

    @Override
    @Transactional
    public boolean delete(Long actividadEnfemeriaId) {
        return repository.findById(actividadEnfemeriaId).map(actividadEnfermeria -> {
            repository.deleteById(actividadEnfemeriaId);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional
    public ActividadEnfermeriaDTO update(ActividadEnfermeriaDTO dto) {
        ActividadEnfermeria domain = toEntity(dto);
        ActividadEnfermeriaDTO enfermeria = mapper.toActividadEnfermeriaDTO(repository.save(domain));
        enfermeria.setUsuario(service.findById(enfermeria.getIdUsuario()).get());
        enfermeria.setTipoActividadEnfermeria(serviceTip.findById(enfermeria.getIdTipoActividadEnfermeria()).get());
        return enfermeria;
    }
}

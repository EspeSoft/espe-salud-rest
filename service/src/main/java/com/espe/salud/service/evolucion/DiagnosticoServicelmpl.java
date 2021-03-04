package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.evolucion.Diagnostico;
import com.espe.salud.dto.evolucion.DiagnosticoDTO;
import com.espe.salud.mapper.evolucion.DiagnosticoMapper;
import com.espe.salud.persistence.evolucion.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoServicelmpl implements DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;
    private final DiagnosticoMapper mapper;

    @Autowired
    public DiagnosticoServicelmpl(DiagnosticoRepository diagnosticoRepository, DiagnosticoMapper mapper) {
        this.diagnosticoRepository = diagnosticoRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DiagnosticoDTO save(DiagnosticoDTO diagnosticoDTO) {
        Optional <Diagnostico> optional = findExisting(diagnosticoDTO);
        if (optional.isEmpty()) {
            Diagnostico domainObject = toEntity(diagnosticoDTO);
            DiagnosticoDTO nuevo= toDTO(diagnosticoRepository.save(domainObject));
            return nuevo;
        }else{
            throw new ConflictException(String.format("Ya existe un diagnóstico registrado para ese código[%s]", diagnosticoDTO.getId()));
        }
    }

    @Override
    public DiagnosticoDTO update(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico domainObject = toEntity(diagnosticoDTO);
        DiagnosticoDTO nuevo= toDTO(diagnosticoRepository.save(domainObject));
        return nuevo;
    }

    @Override
    public Optional<Diagnostico> findExisting(DiagnosticoDTO diagnosticoDTO) {
        return diagnosticoRepository.findByCodigo(diagnosticoDTO.getId());
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        return diagnosticoRepository.findById(id).map(object -> {
            diagnosticoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<DiagnosticoDTO> findById(Long codigo) {
        return diagnosticoRepository.findByCodigo(codigo).map(mapper::toDiagnosticoDTO);
    }


    @Override
    public DiagnosticoDTO toDTO(Diagnostico diagnostico) {
        return mapper.toDiagnosticoDTO(diagnostico);
    }

    @Override
    public Diagnostico toEntity(DiagnosticoDTO dto) {
        return mapper.toDiagnostico(dto);
    }

    @Override
    public List<DiagnosticoDTO> findAll() {
        List<Diagnostico> diagnosticos = new ArrayList<>(diagnosticoRepository.findAll());
        return mapper.toDiagnosticosDTO(diagnosticos);
    }

    @Override
    public List<DiagnosticoDTO> findByEvolucion(String id) {
        return mapper.toDiagnosticosDTO(diagnosticoRepository.findByEvolucionCodigo(id));
    }
}

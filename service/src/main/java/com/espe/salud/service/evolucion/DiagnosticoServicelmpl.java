package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.evolucion.Diagnostico;
import com.espe.salud.dto.evolucion.DiagnosticoDTO;
import com.espe.salud.mapper.evolucion.DiagnosticoMapper;
import com.espe.salud.persistence.evolucion.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DiagnosticoDTO save(DiagnosticoDTO diagnostico) {
        Optional<Diagnostico> optional = findExisting(diagnostico);
        if (!optional.isPresent()) {
            Diagnostico domainObject = toEntity(diagnostico);
            return toDTO(diagnosticoRepository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un procedimiento registrada para ese código[%s]", diagnostico.getId()));
        }
    }

    @Override
    public DiagnosticoDTO update(DiagnosticoDTO diagnostico) {
        Diagnostico domainObject = toEntity(diagnostico);
        return toDTO(diagnosticoRepository.save(domainObject));
    }

    @Override
    public Optional<Diagnostico> findExisting(DiagnosticoDTO diagnosticoDTO) {
        return diagnosticoRepository.findByCodigo(diagnosticoDTO.getId());
    }

    @Override
    public Boolean delete(Long id) {
        return diagnosticoRepository.findById(id).map(object -> {
            diagnosticoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<DiagnosticoDTO> findByCodigo(Long codigo) {
        return diagnosticoRepository.findByCodigo(codigo).map(diagnostico -> mapper.toDiagnosticoDTO(diagnostico));
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
        List<Diagnostico> diagnosticos = new ArrayList<>();
        diagnosticoRepository.findAll().forEach(diagnosticos::add);
        return mapper.toDiagnosticosDTO(diagnosticos);
    }
}

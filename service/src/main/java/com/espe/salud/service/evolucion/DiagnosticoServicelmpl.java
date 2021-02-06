package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.evolucion.Diagnostico;
import com.espe.salud.dto.evolucion.DiagnosticoDTO;
import com.espe.salud.mapper.evolucion.DiagnosticoMapper;
import com.espe.salud.persistence.evolucion.DiagnosticoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiagnosticoServicelmpl implements DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;
    private final DiagnosticoMapper mapper;

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
    public Optional<Diagnostico> findExisting(DiagnosticoDTO diagnosticoDTO) {
        return diagnosticoRepository.findByCodigo(diagnosticoDTO.getId());
    }

    @Override
    public Optional<DiagnosticoDTO> findById(Long codigo) {
        return Optional.empty();
    }

    @Override
    public DiagnosticoDTO toDTO(Diagnostico diagnostico) {
        return mapper.toDiagnosticoDTO(diagnostico);
    }

    @Override
    public Diagnostico toEntity(DiagnosticoDTO dto) {
        return mapper.toDiagnostico(dto);
    }
}

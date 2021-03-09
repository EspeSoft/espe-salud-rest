package com.espe.salud.service.odontologia;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.odontologia.ExamenSistemaEstomatognatico;
import com.espe.salud.domain.entities.odontologia.HistoriaClinicaOdontologica;
import com.espe.salud.dto.odontologia.ExamenSistemaEstomatognaticoDTO;
import com.espe.salud.mapper.odontologia.ExamenSistemaEstomatognaticoMapper;
import com.espe.salud.persistence.odontologia.ExamenSistemaEstomatognaticoRepository;
import com.espe.salud.persistence.odontologia.HistoriaClinicaOdontologicaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ExamenSistemaEstomatognaticoServiceImpl implements ExamenSistemaEstomatognaticoService {

    private final HistoriaClinicaOdontologicaRepository historiaClinicaOdontologicaRepository;
    private final ExamenSistemaEstomatognaticoRepository domainRepository;
    private final ExamenSistemaEstomatognaticoMapper mapper;

    public ExamenSistemaEstomatognaticoServiceImpl(HistoriaClinicaOdontologicaRepository historiaClinicaOdontologicaRepository, ExamenSistemaEstomatognaticoRepository domainRepository, ExamenSistemaEstomatognaticoMapper mapper) {
        this.historiaClinicaOdontologicaRepository = historiaClinicaOdontologicaRepository;
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public ExamenSistemaEstomatognaticoDTO save(ExamenSistemaEstomatognaticoDTO examenSistemaEstomatognatico, Long idPaciente) {
        Optional<HistoriaClinicaOdontologica> optional = historiaClinicaOdontologicaRepository.findByCodigo(idPaciente);
        if (optional.isPresent()) {
            examenSistemaEstomatognatico.setIdHistoria(optional.get().getCodigo());
            ExamenSistemaEstomatognatico domainObject = toEntity(examenSistemaEstomatognatico);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new EntityNotFoundException(String.format("No existe una historia clinica registrada para este paciente [%s]", idPaciente));
        }
    }

    @Override
    public boolean delete(Long id) {
        return domainRepository.findById(id).map(examenSistemaEstomatognatico -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public ExamenSistemaEstomatognaticoDTO update(ExamenSistemaEstomatognaticoDTO examenSistemaEstomatognaticoDTO) {
        ExamenSistemaEstomatognatico domainObject = toEntity(examenSistemaEstomatognaticoDTO);
        return toDTO(domainRepository.save(domainObject));
    }

    @Override
    public Optional<ExamenSistemaEstomatognaticoDTO> findById(Long id) {
        return domainRepository.findById(id).map(this::toDTO);
    }

    @Override
    public List<ExamenSistemaEstomatognaticoDTO> findByHistoriaClinica(Long idHistoria) {
        return mapper.toExamenesSistemaEstomatognaticoDTO(domainRepository.findByHistoriaCodigo(idHistoria));
    }

    @Override
    public ExamenSistemaEstomatognaticoDTO toDTO(ExamenSistemaEstomatognatico examenSistemaEstomatognatico) {
        return mapper.toExamenSistemaEstomatognaticoDTO(examenSistemaEstomatognatico);
    }

    @Override
    public ExamenSistemaEstomatognatico toEntity(ExamenSistemaEstomatognaticoDTO dto) {
        return mapper.toExamenSistemaEstomatognatico(dto);
    }
}

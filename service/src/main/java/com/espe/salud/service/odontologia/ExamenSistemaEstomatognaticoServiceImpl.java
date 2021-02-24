package com.espe.salud.service.odontologia;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.odontologia.ExamenSistemaEstomatognatico;
import com.espe.salud.dto.odontologia.ExamenSistemaEstomatognaticoDTO;
import com.espe.salud.mapper.odontologia.ExamenSistemaEstomatognaticoMapper;
import com.espe.salud.persistence.odontologia.ExamenSistemaEstomatognaticoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenSistemaEstomatognaticoServiceImpl implements ExamenSistemaEstomatognaticoService {

    private final ExamenSistemaEstomatognaticoRepository domainRepository;
    private final ExamenSistemaEstomatognaticoMapper mapper;

    public ExamenSistemaEstomatognaticoServiceImpl(ExamenSistemaEstomatognaticoRepository domainRepository, ExamenSistemaEstomatognaticoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public ExamenSistemaEstomatognaticoDTO save(ExamenSistemaEstomatognaticoDTO examenSistemaEstomatognaticoDTO) {
        Optional<ExamenSistemaEstomatognatico> optional = domainRepository.findByCodigo(examenSistemaEstomatognaticoDTO.getId());
        if (optional.isEmpty()) {
            ExamenSistemaEstomatognatico domainObject = toEntity(examenSistemaEstomatognaticoDTO);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un exámen de sistema estomatognático registrado para ese código[%s]", examenSistemaEstomatognaticoDTO.getId()));
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

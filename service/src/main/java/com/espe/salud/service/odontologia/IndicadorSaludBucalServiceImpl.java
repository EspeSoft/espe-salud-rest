package com.espe.salud.service.odontologia;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.odontologia.IndicadorSaludBucal;
import com.espe.salud.dto.odontologia.IndicadorSaludBucalDTO;
import com.espe.salud.mapper.odontologia.IndicadorSaludBucalMapper;
import com.espe.salud.persistence.odontologia.IndicadorSaludBucalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndicadorSaludBucalServiceImpl implements IndicadorSaludBucalService {

    private final IndicadorSaludBucalRepository domainRepository;
    private final IndicadorSaludBucalMapper mapper;

    public IndicadorSaludBucalServiceImpl(IndicadorSaludBucalRepository domainRepository, IndicadorSaludBucalMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public IndicadorSaludBucalDTO save(IndicadorSaludBucalDTO indicadorSaludBucalDTO) {
        Optional<IndicadorSaludBucal> optional = domainRepository.findByCodigo(indicadorSaludBucalDTO.getId());
        if (optional.isEmpty()) {
            IndicadorSaludBucal domainObject = toEntity(indicadorSaludBucalDTO);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un indicador de salud bucal registrado para ese código[%s]", indicadorSaludBucalDTO.getId()));
        }
    }

    @Override
    public boolean delete(Long id) {
        return domainRepository.findById(id).map(indicadorSaludBucal -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public IndicadorSaludBucalDTO update(IndicadorSaludBucalDTO indicadorSaludBucalDTO) {
        IndicadorSaludBucal domainObject = toEntity(indicadorSaludBucalDTO);
        return toDTO(domainRepository.save(domainObject));
    }

    @Override
    public Optional<IndicadorSaludBucalDTO> findById(Long id) {
        return domainRepository.findById(id).map(this::toDTO);
    }

    @Override
    public List<IndicadorSaludBucalDTO> findByHistoriaClinica(Long idHistoria) {
        return mapper.toIndicadoresSaludBucalDTO(domainRepository.findByHistoriaCodigo(idHistoria));
    }

    @Override
    public IndicadorSaludBucalDTO toDTO(IndicadorSaludBucal indicadorSaludBucal) {
        return mapper.toIndicadorSaludBucalDTO(indicadorSaludBucal);
    }

    @Override
    public IndicadorSaludBucal toEntity(IndicadorSaludBucalDTO dto) {
        return mapper.toIndicadorSaludBucal(dto);
    }
}

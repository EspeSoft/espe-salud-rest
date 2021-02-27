package com.espe.salud.service.odontologia;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.odontologia.EnfermedadProblemaActual;
import com.espe.salud.dto.odontologia.EnfermedadProblemaActualDTO;
import com.espe.salud.mapper.odontologia.EnfermedadProblemaActualMapper;
import com.espe.salud.persistence.odontologia.EnfermedadProblemaActualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnfermedadProblemaActualServiceImpl implements EnfermedadProblemaActualService {

    private final EnfermedadProblemaActualRepository domainRepository;
    private final EnfermedadProblemaActualMapper mapper;

    @Autowired
    public EnfermedadProblemaActualServiceImpl(EnfermedadProblemaActualRepository domainRepository,
                                               EnfermedadProblemaActualMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public EnfermedadProblemaActualDTO save(EnfermedadProblemaActualDTO enfermedadProblemaActual) {
        Optional<EnfermedadProblemaActual> optional = domainRepository.findByCodigo(enfermedadProblemaActual.getId());
        if (optional.isEmpty()) {
            EnfermedadProblemaActual domainObject = toEntity(enfermedadProblemaActual);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una enfermedad o problema actual registrado para ese código[%s]", enfermedadProblemaActual.getId()));
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return domainRepository.findById(id).map(enfermedadProblemaActual -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public EnfermedadProblemaActualDTO update(EnfermedadProblemaActualDTO enfermedadProblemaActualDTO) {
        EnfermedadProblemaActual domainObject = toEntity(enfermedadProblemaActualDTO);
        return toDTO(domainRepository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EnfermedadProblemaActualDTO> findById(Long id) {
        return domainRepository.findById(id).map(this::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnfermedadProblemaActualDTO> findByHistoriaClinica(Long idHistoria) {
        return mapper.toEnfermedadesProblemasActualesDTO(domainRepository.findByHistoriaCodigo(idHistoria));
    }

    @Override
    public EnfermedadProblemaActualDTO toDTO(EnfermedadProblemaActual enfermedadProblemaActual) {
        return mapper.toEnfermedadProblemaActualDTO(enfermedadProblemaActual);
    }

    @Override
    public EnfermedadProblemaActual toEntity(EnfermedadProblemaActualDTO dto) {
        return mapper.toEnfermedadProblemaActual(dto);
    }
}

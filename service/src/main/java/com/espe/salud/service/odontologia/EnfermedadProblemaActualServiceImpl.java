package com.espe.salud.service.odontologia;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.odontologia.EnfermedadProblemaActual;
import com.espe.salud.domain.entities.odontologia.HistoriaClinicaOdontologica;
import com.espe.salud.dto.odontologia.EnfermedadProblemaActualDTO;
import com.espe.salud.mapper.odontologia.EnfermedadProblemaActualMapper;
import com.espe.salud.persistence.odontologia.EnfermedadProblemaActualRepository;
import com.espe.salud.persistence.odontologia.HistoriaClinicaOdontologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EnfermedadProblemaActualServiceImpl implements EnfermedadProblemaActualService {

    private final HistoriaClinicaOdontologicaRepository historiaClinicaOdontologicaRepository;
    private final EnfermedadProblemaActualRepository domainRepository;
    private final EnfermedadProblemaActualMapper mapper;

    @Autowired
    public EnfermedadProblemaActualServiceImpl(HistoriaClinicaOdontologicaRepository historiaClinicaOdontologicaRepository, EnfermedadProblemaActualRepository domainRepository,
                                               EnfermedadProblemaActualMapper mapper) {
        this.historiaClinicaOdontologicaRepository = historiaClinicaOdontologicaRepository;
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public EnfermedadProblemaActualDTO save(EnfermedadProblemaActualDTO enfermedadProblemaActual, Long idPaciente) {
        Optional<HistoriaClinicaOdontologica> optional = historiaClinicaOdontologicaRepository.findByCodigo(idPaciente);
        if (optional.isPresent()) {
            enfermedadProblemaActual.setIdHistoria(optional.get().getCodigo());
            EnfermedadProblemaActual domainObject = toEntity(enfermedadProblemaActual);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new EntityNotFoundException(String.format("No existe una historia clinica registrada para este paciente [%s]", idPaciente));
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

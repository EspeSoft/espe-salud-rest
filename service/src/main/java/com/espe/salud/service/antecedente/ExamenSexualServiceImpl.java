package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.ExamenSexual;
import com.espe.salud.dto.antecedente.ExamenSexualDTO;
import com.espe.salud.mapper.antecedente.ExamenSexualMapper;
import com.espe.salud.persistence.antecedente.ExamenSexualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenSexualServiceImpl implements ExamenSexualService {

    private final ExamenSexualRepository domainRepository;
    private final ExamenSexualMapper mapper;

    @Autowired
    public ExamenSexualServiceImpl(
            ExamenSexualRepository domainRepository,
            ExamenSexualMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ExamenSexualDTO save(ExamenSexualDTO examenSexualDTO) {
        Optional<ExamenSexual> optional = domainRepository.findByCodigo(examenSexualDTO.getId());
        if (optional.isEmpty()) {
            ExamenSexual domainObject = mapper.toExamenSexual(examenSexualDTO);
            return mapper.toExamenSexualDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un examen sexual para el codigo [%s]", examenSexualDTO.getId()));
        }
    }

    @Override
    @Transactional
    public ExamenSexualDTO update(ExamenSexualDTO examenSexualDTO) {
        ExamenSexual domainObject = mapper.toExamenSexual(examenSexualDTO);
        return mapper.toExamenSexualDTO(domainRepository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ExamenSexualDTO> findById(Long codigo) {
        return domainRepository.findByCodigo(codigo).map(mapper::toExamenSexualDTO);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return domainRepository.findById(id).map(examenSexual -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExamenSexualDTO> findByPaciente(Long idPaciente) {
        return mapper.toExamenesSexualesDTO(domainRepository.findByAntecedentePersonalPacienteCodigo(idPaciente));
    }

}


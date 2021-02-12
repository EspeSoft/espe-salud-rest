package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.ExamenSexual;
import com.espe.salud.dto.antecedente.ExamenSexualDTO;
import com.espe.salud.mapper.antecedente.ExamenSexualMapper;
import com.espe.salud.persistence.antecedente.ExamenSexualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenSexualServiceImpl implements ExamenSexualService{

    private final ExamenSexualRepository domainRepository;
    private final ExamenSexualMapper mapper;

    @Autowired
    public ExamenSexualServiceImpl(ExamenSexualRepository domainRepository, ExamenSexualMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public ExamenSexualDTO save(ExamenSexualDTO examenSexualDTO) {
        Optional<ExamenSexual> optional=domainRepository.findById(examenSexualDTO.getId());
        if (!optional.isPresent()){
            ExamenSexual domainObject=toEntity(examenSexualDTO);
            return toDTO(domainRepository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un examen sexual para el codigo [%s]",examenSexualDTO.getId()));
        }
    }

    @Override
    public ExamenSexualDTO update(ExamenSexualDTO examenSexualDTO) {
        ExamenSexual domainObject=toEntity(examenSexualDTO);
        return toDTO(domainRepository.save(domainObject));
    }

    @Override
    public Optional<ExamenSexualDTO> findById(Long codigo) {
        return domainRepository.findById(codigo).map(examenSexual -> toDTO(examenSexual));
    }

    @Override
    public List<ExamenSexualDTO> findAll() {
        return mapper.toExamenSexualDTO(domainRepository.findAll());
    }

    @Override
    public boolean deleteById(Long id) {
        return domainRepository.findById(id).map(examenSexual -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public ExamenSexualDTO toDTO(ExamenSexual examenSexual) {
        return mapper.toExamenSexualDTO(examenSexual);
    }

    @Override
    public ExamenSexual toEntity(ExamenSexualDTO dto) {
        return mapper.toExamenSexual(dto);
    }
}


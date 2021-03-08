package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedentePersonal;
import com.espe.salud.dto.antecedente.AntecedentePersonalDTO;
import com.espe.salud.mapper.antecedente.AntecedentePersonalMapper;
import com.espe.salud.persistence.antecedente.AntecedentePersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AntecedentePersonalServicelmpl implements AntecedentePersonalService {
    private final AntecedentePersonalRepository repository;
    private final AntecedentePersonalMapper mapper;

    @Autowired
    public AntecedentePersonalServicelmpl(AntecedentePersonalRepository antecedentePersonalRepository, AntecedentePersonalMapper mapper) {
        this.repository = antecedentePersonalRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public AntecedentePersonalDTO save(AntecedentePersonalDTO antecedentePersonal) {
        Optional<AntecedentePersonal> optional = repository.findByPacienteCodigo(antecedentePersonal.getIdPaciente());
        if (optional.isEmpty()) {
            AntecedentePersonal domainObject = mapper.toAntecedentePersonal(antecedentePersonal);
            return mapper.toAntecedentePersonalDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un antecedente registrado para ese paciente[%s]", antecedentePersonal.getIdPaciente()));
        }
    }

    @Override
    @Transactional
    public AntecedentePersonalDTO update(AntecedentePersonalDTO antecedentePersonal) {
        AntecedentePersonal domainObject = mapper.toAntecedentePersonal(antecedentePersonal);
        return mapper.toAntecedentePersonalDTO(repository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AntecedentePersonalDTO> findById(Long id) {
        return repository.findByCodigo(id).map(mapper::toAntecedentePersonalDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AntecedentePersonalDTO> findByPaciente(Long idPaciente) {
        return repository.findByPacienteCodigo(idPaciente).map(mapper::toAntecedentePersonalDTO);
    }
}

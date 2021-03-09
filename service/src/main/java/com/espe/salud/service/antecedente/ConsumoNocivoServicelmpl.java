package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.ConsumoNocivo;
import com.espe.salud.dto.antecedente.ConsumoNocivoDTO;
import com.espe.salud.mapper.antecedente.ConsumoNocivoMapper;
import com.espe.salud.persistence.antecedente.ConsumoNocivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumoNocivoServicelmpl implements ConsumoNocivoService {

    private final ConsumoNocivoRepository repository;
    private final ConsumoNocivoMapper mapper;

    @Autowired
    public ConsumoNocivoServicelmpl(ConsumoNocivoRepository consumoNocivoRepository, ConsumoNocivoMapper mapper) {
        this.repository = consumoNocivoRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ConsumoNocivoDTO save(ConsumoNocivoDTO dto) {
        Optional<ConsumoNocivo> optional = repository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            ConsumoNocivo domainObject = mapper.toConsumoNocivo(dto);
            return mapper.toConsumoNocivoDTO(repository.save(domainObject));
        } else {
            throw new ConflictException("Ya existe un consumo nocivo para ese ID");
        }
    }

    @Override
    @Transactional
    public ConsumoNocivoDTO update(ConsumoNocivoDTO dto) {
        ConsumoNocivo domainObject = mapper.toConsumoNocivo(dto);
        return mapper.toConsumoNocivoDTO(repository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConsumoNocivoDTO> findById(Long codigo) {
        return repository.findByCodigo(codigo).map(mapper::toConsumoNocivoDTO);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return repository.findById(id).map(object -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ConsumoNocivoDTO> findByPaciente(Long idPaciente) {
        return mapper.toConsumosNocivosDTO(repository.findByAntecedentePersonalPacienteCodigo(idPaciente));
    }
}

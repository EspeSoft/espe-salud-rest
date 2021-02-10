package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.ConsumoNocivo;
import com.espe.salud.dto.antecedente.ConsumoNocivoDTO;
import com.espe.salud.mapper.antecedente.ConsumoNocivoMapper;
import com.espe.salud.persistence.antecedente.ConsumoNocivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumoNocivoServicelmpl  implements ConsumoNocivoService{

    private final ConsumoNocivoRepository consumoNocivoRepository;
    private final ConsumoNocivoMapper mapper;

    @Autowired
    public ConsumoNocivoServicelmpl(ConsumoNocivoRepository consumoNocivoRepository, ConsumoNocivoMapper mapper) {
        this.consumoNocivoRepository = consumoNocivoRepository;
        this.mapper = mapper;
    }

    @Override
    public ConsumoNocivoDTO save(ConsumoNocivoDTO consumoNocivo) {
        Optional<ConsumoNocivo> optional = findExisting(consumoNocivo);
        if (!optional.isPresent()) {
            ConsumoNocivo domainObject = toEntity(consumoNocivo);
            return toDTO(consumoNocivoRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un paciente registrada para ese código[%s]", consumoNocivo.getId()));
        }
    }

    @Override
    public ConsumoNocivoDTO update(ConsumoNocivoDTO consumoNocivo) {
        ConsumoNocivo domainObject = toEntity(consumoNocivo);
        return toDTO(consumoNocivoRepository.save(domainObject));
    }

    @Override
    public Optional<ConsumoNocivo> findExisting(ConsumoNocivoDTO pacienteDTO) {
        return consumoNocivoRepository.findByCodigo(pacienteDTO.getId());
    }

    @Override
    public Boolean delete(Long id) {
        return consumoNocivoRepository.findById(id).map(object -> {
            consumoNocivoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<ConsumoNocivoDTO> findByCodigo(Long codigo) {
        return consumoNocivoRepository.findByCodigo(codigo).map(consumoNocivo -> mapper.toConsumoNocivoDTO(consumoNocivo));
    }

    @Override
    public ConsumoNocivoDTO toDTO(ConsumoNocivo consumoNocivo) {
        return mapper.toConsumoNocivoDTO(consumoNocivo);
    }

    @Override
    public ConsumoNocivo toEntity(ConsumoNocivoDTO dto) {
        return mapper.toConsumoNocivo(dto);
    }

    @Override
    public List<ConsumoNocivoDTO> findAll() {
        List<ConsumoNocivo> consumoNocivos = new ArrayList<>();
        consumoNocivoRepository.findAll().forEach(consumoNocivos::add);
        return mapper.toConsumosNocivosDTO(consumoNocivos);
    }
}

package com.espe.salud.service.ocupacional;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.ocupacional.AntecedenteLaboral;
import com.espe.salud.domain.entities.ocupacional.AntecedenteLaboral;
import com.espe.salud.dto.ocupacional.AntecedenteLaboralDTO;
import com.espe.salud.mapper.ocupacional.AntecedenteLaboralMapper;
import com.espe.salud.persistence.ocupacional.AntecedenteLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("antecedenteLaboralServiceImpl")
public class AntecedenteLaboralServiceImpl implements AntecedenteLaboralService {

    private final AntecedenteLaboralRepository repository;
    private final AntecedenteLaboralMapper mapper;

    @Autowired
    public AntecedenteLaboralServiceImpl(AntecedenteLaboralRepository repository, AntecedenteLaboralMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AntecedenteLaboralDTO save(AntecedenteLaboralDTO antecedente) {
        Optional<AntecedenteLaboral> optional = repository.findByCodigo(antecedente.getId());
        if (!optional.isPresent()) {
            AntecedenteLaboral domainObject = toEntity(antecedente);
            return toDTO(repository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un antecedente laboral registrado para ese código[%s]", antecedente.getId()));
        }
    }

    @Override
    public AntecedenteLaboralDTO update(AntecedenteLaboralDTO antecedente) {
        AntecedenteLaboral domainObject = toEntity(antecedente);
        return toDTO(repository.save(domainObject));
    }

    @Override
    public Boolean delete(Long id) {
        return repository.findById(id).map(object -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<AntecedenteLaboralDTO> findByCodigo(Long codigo) {
        return repository.findByCodigo(codigo).map(antecedente -> mapper.toAntecedenteLaboralDto(antecedente));
    }

    @Override
    public Optional<AntecedenteLaboralDTO> findByPaciente(Long idPaciente) {
        return Optional.of(this.toDTO(repository.findByPacienteCodigo(idPaciente)));
    }

    @Override
    public AntecedenteLaboralDTO toDTO(AntecedenteLaboral antecedente) {
        return mapper.toAntecedenteLaboralDto(antecedente);
    }

    @Override
    public AntecedenteLaboral toEntity(AntecedenteLaboralDTO dto) {
        return mapper.toAntecedenteLaboral(dto);
    }

}

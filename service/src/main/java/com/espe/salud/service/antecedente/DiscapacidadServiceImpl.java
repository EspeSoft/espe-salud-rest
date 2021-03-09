package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.Discapacidad;
import com.espe.salud.dto.antecedente.DiscapacidadDTO;
import com.espe.salud.mapper.antecedente.DiscapacidadMapper;
import com.espe.salud.persistence.antecedente.DiscapacidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DiscapacidadServiceImpl implements DiscapacidadService {

    private final DiscapacidadRepository discapacidadRepository;
    private final DiscapacidadMapper mapper;

    @Autowired
    public DiscapacidadServiceImpl(
            DiscapacidadRepository discapacidadRepository,
            DiscapacidadMapper mapper) {
        this.discapacidadRepository = discapacidadRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DiscapacidadDTO save(DiscapacidadDTO dto) {
        Optional<Discapacidad> optional = discapacidadRepository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            Discapacidad domainObject = mapper.toDiscapacidad(dto);
            return mapper.toDiscapacidadDTO(discapacidadRepository.save(domainObject));
        } else {
            throw new ConflictException("Ya existe una discapacidad para ese ID");
        }
    }

    @Override
    @Transactional
    public DiscapacidadDTO update(DiscapacidadDTO dto) {
        Discapacidad domainObject = mapper.toDiscapacidad(dto);
        return mapper.toDiscapacidadDTO(discapacidadRepository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DiscapacidadDTO> findById(Long codigo) {
        return discapacidadRepository.findByCodigo(codigo).map(mapper::toDiscapacidadDTO);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return discapacidadRepository.findById(id).map(discapacidad -> {
            discapacidadRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiscapacidadDTO> findByPaciente(Long idPaciente) {
        return mapper.toDiscapacidadesDTO(discapacidadRepository.findByAntecedentePersonalPacienteCodigo(idPaciente));
    }
}

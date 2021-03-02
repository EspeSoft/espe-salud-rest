package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.Discapacidad;
import com.espe.salud.dto.antecedente.DiscapacidadDTO;
import com.espe.salud.mapper.antecedente.DiscapacidadMapper;
import com.espe.salud.persistence.antecedente.DiscapacidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscapacidadServiceImpl implements DiscapacidadService {

    private final DiscapacidadRepository discapacidadRepository;
    private final DiscapacidadMapper mapper;

    @Autowired
    public DiscapacidadServiceImpl(DiscapacidadRepository discapacidadRepository, DiscapacidadMapper mapper) {
        this.discapacidadRepository = discapacidadRepository;
        this.mapper = mapper;
    }

    @Override
    public DiscapacidadDTO save(DiscapacidadDTO discapacidadDTO) {
        Discapacidad domainObject = toEntity(discapacidadDTO);
        return toDTO(discapacidadRepository.save(domainObject));
    }

    @Override
    public DiscapacidadDTO update(DiscapacidadDTO discapacidadDTO) {
        Discapacidad domainObject = toEntity(discapacidadDTO);
        return toDTO(discapacidadRepository.save(domainObject));
    }

    @Override
    public Optional<DiscapacidadDTO> findById(Long codigo) {
        return discapacidadRepository.findById(codigo).map(discapacidad -> toDTO(discapacidad));
    }

    @Override
    public List<DiscapacidadDTO> findAll() {
        return mapper.toDiscapacidadDTO(discapacidadRepository.findAll());
    }

    @Override
    public List<DiscapacidadDTO> findByIdAntecedentePersonal(Long idAntecedentePersonal) {
        return mapper.toDiscapacidadDTO(discapacidadRepository.findByIdAntecedentePersonal(idAntecedentePersonal));
    }

    @Override
    public boolean deleteById(Long id) {
        return discapacidadRepository.findById(id).map(discapacidad -> {
            discapacidadRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public DiscapacidadDTO toDTO(Discapacidad discapacidad) {
        return mapper.toDiscapacidadDTO(discapacidad);
    }

    @Override
    public Discapacidad toEntity(DiscapacidadDTO dto) {
        return mapper.toDiscapacidad(dto);
    }
}

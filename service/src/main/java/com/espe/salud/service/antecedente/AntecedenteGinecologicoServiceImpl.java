package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedenteGinecologico;
import com.espe.salud.dto.antecedente.AntecedenteGinecologicoDTO;
import com.espe.salud.mapper.antecedente.AntecedenteGinecologicoMapper;
import com.espe.salud.persistence.antecedente.AntecedenteGinecologicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AntecedenteGinecologicoServiceImpl implements AntecedenteGinecologicoService {

    private final AntecedenteGinecologicoRepository domainRepository;
    private final AntecedenteGinecologicoMapper mapper;

    @Autowired
    public AntecedenteGinecologicoServiceImpl(AntecedenteGinecologicoRepository domainRepository, AntecedenteGinecologicoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public AntecedenteGinecologicoDTO save(AntecedenteGinecologicoDTO dto) {
        Optional<AntecedenteGinecologico> optional = domainRepository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            AntecedenteGinecologico domainObject = mapper.toAntecedenteGinecologico(dto);
            return mapper.toAntecedenteGinecologicoDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un antecedente ginecológico para el codigo [%s]", dto.getId()));
        }
    }

    @Override
    @Transactional
    public AntecedenteGinecologicoDTO update(AntecedenteGinecologicoDTO dto) {
        AntecedenteGinecologico domainObject = mapper.toAntecedenteGinecologico(dto);
        return mapper.toAntecedenteGinecologicoDTO(domainRepository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AntecedenteGinecologicoDTO> findById(Long codigo) {
        return domainRepository.findByCodigo(codigo).map(mapper::toAntecedenteGinecologicoDTO);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return domainRepository.findById(id).map(antecedenteGinecologico -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AntecedenteGinecologicoDTO> findByPaciente(Long idPaciente) {
        return mapper.toAntecedentesGinecologicosDTO(domainRepository.findByAntecedentePersonalPacienteCodigo(idPaciente));
    }
}

package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import com.espe.salud.dto.antecedente.EstudioComplementarioDTO;
import com.espe.salud.mapper.antecedente.EstudioComplementarioMapper;
import com.espe.salud.persistence.antecedente.EstudioComplementarioRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstudioComplementarioServiceImpl implements EstudioComplementarioService {

    private final EstudioComplementarioRepository domainRepository;

    private final EstudioComplementarioMapper mapper;

    @Autowired
    public EstudioComplementarioServiceImpl(EstudioComplementarioRepository domainRepository,
                                            EstudioComplementarioMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public EstudioComplementarioDTO save(EstudioComplementarioDTO estudioComplementarioDTO) {
        Optional<EstudioComplementario> optional = domainRepository.findByCodigo(estudioComplementarioDTO.getId());
        if (optional.isEmpty()) {
            EstudioComplementario domainObject = mapper.toEstudioComplementario(estudioComplementarioDTO);
            return mapper.toEstudioComplementarioDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una estudio complementario para ese código[%s]", estudioComplementarioDTO.getId()));
        }
    }

    @Override
    @Transactional
    public EstudioComplementarioDTO update(EstudioComplementarioDTO estudioComplementarioDTO) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EstudioComplementarioDTO> findById(Long codigo) {
        return domainRepository.findById(codigo).map(mapper::toEstudioComplementarioDTO);
    }

    @Override
    @Transactional
    public boolean delete(Long codigo) {
        return domainRepository.findById(codigo).map(domainObject -> {
            domainRepository.deleteById(codigo);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional
    public boolean deleteAll(List<EstudioComplementarioDTO> estudios) {
        domainRepository.deleteAll(mapper.toEstudiosComplementarios(estudios));
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstudioComplementarioDTO> findByPaciente(Long idPaciente) {
        return mapper.toEstudiosComplementarioDTO(domainRepository.findByPacienteCodigo(idPaciente));
    }
}

package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import com.espe.salud.domain.entities.catalogo.TipoEstudioComplementario;
import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import com.espe.salud.dto.antecedente.EstudioComplementarioDTO;
import com.espe.salud.dto.catalogo.TipoEstudioComplementarioDTO;
import com.espe.salud.mapper.antecedente.EstudioComplementarioMapper;
import com.espe.salud.persistence.antecedente.EstudioComplementarioRepository;
import com.espe.salud.persistence.catalogo.TipoEstudioComplementarioRepository;
import com.espe.salud.service.GenericCRUDService;
import com.espe.salud.service.GenericCRUDServiceImpl;
import com.espe.salud.service.catalogo.TipoEstudioComplementarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstudioComplementarioServiceImpl implements EstudioComplementarioService {

    private final EstudioComplementarioRepository domainRepository;
    private final TipoEstudioComplementarioRepository tipoEstudioRepository;
    private final EstudioComplementarioMapper mapper;

    @Autowired
    public EstudioComplementarioServiceImpl(EstudioComplementarioRepository domainRepository,
                                            TipoEstudioComplementarioRepository tipoEstudioRepository,
                                            EstudioComplementarioMapper mapper) {
        this.domainRepository = domainRepository;
        this.tipoEstudioRepository = tipoEstudioRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public EstudioComplementarioDTO save(EstudioComplementarioDTO estudioComplementarioDTO) {
        Optional<EstudioComplementario> optional = domainRepository.findByCodigo(estudioComplementarioDTO.getId());
        if (optional.isEmpty()) {
            EstudioComplementario domainObject = mapper.toEstudioComplementario(estudioComplementarioDTO);
            if (domainObject.getNombreEstudio().getCodigo() == null) {
                tipoEstudioRepository.save(domainObject.getNombreEstudio());
            }
            return mapper.toEstudioComplementarioDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una estudio complementario para ese código[%s]", estudioComplementarioDTO.getId()));
        }
    }

    @Override
    @Transactional
    public EstudioComplementarioDTO update(EstudioComplementarioDTO estudioComplementarioDTO) {
        return mapper.toEstudioComplementarioDTO(domainRepository.save(mapper.toEstudioComplementario(estudioComplementarioDTO)));
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
    @Transactional(readOnly = true)
    public List<EstudioComplementarioDTO> findByPaciente(Long idPaciente) {
        return mapper.toEstudiosComplementarioDTO(domainRepository.findByPacienteCodigoOrderByFechaEstudioDesc(idPaciente));
    }
}

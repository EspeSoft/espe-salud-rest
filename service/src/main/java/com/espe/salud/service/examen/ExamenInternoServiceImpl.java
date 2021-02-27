package com.espe.salud.service.examen;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.OrganoSistema;
import com.espe.salud.domain.entities.examen.ExamenInterno;
import com.espe.salud.dto.catalogo.OrganoSistemaDTO;
import com.espe.salud.dto.examen.ExamenInternoDTO;
import com.espe.salud.mapper.examen.ExamenInternoMapper;
import com.espe.salud.persistence.examen.ExamenInternoRepository;
import com.espe.salud.service.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenInternoServiceImpl implements ExamenInternoService{

    private final ExamenInternoRepository repository;
    private final ExamenInternoMapper mapper;
    private final GenericCRUDService<OrganoSistema, OrganoSistemaDTO> organoSistemaService;

    @Autowired
    public ExamenInternoServiceImpl(
            ExamenInternoRepository repository,
            ExamenInternoMapper mapper,
            @Qualifier("organoSistemaServiceImpl") GenericCRUDService<OrganoSistema, OrganoSistemaDTO> organoSistemaService) {
        this.repository = repository;
        this.mapper = mapper;
        this.organoSistemaService = organoSistemaService;
    }

    @Override
    @Transactional
    public ExamenInternoDTO save(ExamenInternoDTO dto) {
        Optional<ExamenInterno> optional = repository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            ExamenInterno domainObject = mapper.toExamenInterno(dto);
            ExamenInternoDTO examenInternoDTO = mapper.toExamenInternoDTO(repository.save(domainObject));
            examenInternoDTO.setOrganoSistema(organoSistemaService.findById(examenInternoDTO.getIdOrganoSistema()));
            return examenInternoDTO;
        }else{
            throw new ConflictException("Ya existe un examen registrado para ese id");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ExamenInternoDTO> findById(Long id) {
        return repository.findByCodigo(id).map(mapper::toExamenInternoDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExamenInternoDTO> findByPaciente(Long idPaciente) {
        return mapper.toExamenesInternosDTO(repository.findByPacienteCodigo(idPaciente));
    }

    @Override
    @Transactional
    public ExamenInternoDTO update(ExamenInternoDTO dto) {
        ExamenInterno domainObject = mapper.toExamenInterno(dto);
        ExamenInternoDTO examenInternoDTO = mapper.toExamenInternoDTO(repository.save(domainObject));
        examenInternoDTO.setOrganoSistema(organoSistemaService.findById(examenInternoDTO.getIdOrganoSistema()));
        return examenInternoDTO;
    }

    @Override
    @Transactional
    public boolean delete(Long codigo) {
        return repository.findById(codigo).map(object -> {
            repository.deleteById(codigo);
            return true;
        }).orElse(false);
    }
}

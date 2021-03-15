package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.evolucion.Prescripcion;
import com.espe.salud.dto.evolucion.PrescripcionDTO;
import com.espe.salud.mapper.evolucion.PrescripcionMapper;
import com.espe.salud.persistence.catalogo.RepertorioMedicamentoRepository;
import com.espe.salud.persistence.evolucion.PrescripcionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrescripcionServiceImpl implements PrescripcionService{
    private final PrescripcionRepository repository;
    private final PrescripcionMapper mapper;
    private final RepertorioMedicamentoRepository repositoryMed;

    public PrescripcionServiceImpl(PrescripcionRepository repository, PrescripcionMapper mapper, RepertorioMedicamentoRepository repositoryMed) {
        this.repository = repository;
        this.mapper = mapper;
        this.repositoryMed = repositoryMed;
    }

    @Override
    @Transactional
    public PrescripcionDTO save(PrescripcionDTO dto) {
        Optional<Prescripcion> optional = repository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            Prescripcion domainObject = mapper.toPrescripcion(dto);
            if(domainObject.getMedicamento().getCodigo() == null){
                repositoryMed.save(domainObject.getMedicamento());
            }
            return mapper.toPrescripcionDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una preescripcion registrada para ese código[%s]", dto.getId()));
        }
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        return repository.findById(id).map(prescripcion -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional
    public PrescripcionDTO update(PrescripcionDTO dto) {
        return mapper.toPrescripcionDTO(repository.save(mapper.toPrescripcion(dto)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PrescripcionDTO> findById(Long id) {
        return repository.findById(id).map(mapper::toPrescripcionDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrescripcionDTO> findByEvolucion(String id) {
        return mapper.toPrescripcionesDTO(repository.findByEvolucionCodigo(id));
    }
}

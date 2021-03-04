package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.RepertorioMedicamento;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.domain.entities.evolucion.Prescripcion;
import com.espe.salud.dto.catalogo.RepertorioMedicamentoDTO;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.dto.evolucion.PrescripcionDTO;
import com.espe.salud.mapper.evolucion.PrescripcionMapper;
import com.espe.salud.persistence.evolucion.PrescripcionRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrescripcionServiceImpl implements PrescripcionService{
    private final PrescripcionRepository repository;
    private final PrescripcionMapper mapper;
    private final EvolucionService serviceEvo;
    private final GenericCRUDServiceImpl <RepertorioMedicamento, RepertorioMedicamentoDTO> serviceMed;

    public PrescripcionServiceImpl(PrescripcionRepository repository, PrescripcionMapper mapper, EvolucionService serviceEvo, @Qualifier("repertorioMedicacionImpl") GenericCRUDServiceImpl<RepertorioMedicamento, RepertorioMedicamentoDTO> serviceMed) {
        this.repository = repository;
        this.mapper = mapper;
        this.serviceEvo = serviceEvo;
        this.serviceMed = serviceMed;
    }

    @Override
    @Transactional
    public PrescripcionDTO save(PrescripcionDTO dto) {
        Optional<Prescripcion> optional = findExisting(dto);
        if (optional.isEmpty()) {
            Prescripcion domainObject = toEntity(dto);
            PrescripcionDTO prescripcionNuevo= toDTO(repository.save(domainObject));
            prescripcionNuevo.setMedicamento(serviceMed.findById(prescripcionNuevo.getId()));
            return prescripcionNuevo;
        } else {
            throw new ConflictException(String.format("Ya existe una preescripcion registrada para ese código[%s]", dto.getId()));
        }    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Prescripcion> findExisting(PrescripcionDTO dto) {
        return repository.findByCodigo(dto.getId());
     }

    @Override
    public PrescripcionDTO toDTO(Prescripcion prescripcion) {
        return mapper.toPrescripcionDTO(prescripcion);
    }

    @Override
    public Prescripcion toEntity(PrescripcionDTO dto) {
        return mapper.toPrescripcion(dto);
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
    public PrescripcionDTO update(PrescripcionDTO dto) {
        Prescripcion domainObject = toEntity(dto);
        PrescripcionDTO prescripcionNuevo= toDTO(repository.save(domainObject));
        prescripcionNuevo.setMedicamento(serviceMed.findById(prescripcionNuevo.getId()));
        return prescripcionNuevo;
    }

    @Override
    public Optional<PrescripcionDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Override
    public List<PrescripcionDTO> findByEvolucion(String id) {
        return mapper.toPrescripcionesDTO(repository.findByEvolucionCodigo(id));
    }
}

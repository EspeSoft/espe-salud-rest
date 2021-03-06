package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.FrecuenciaMedicacionHabitual;
import com.espe.salud.dto.catalogo.FrecuenciaMedicacionHabitualDTO;
import com.espe.salud.mapper.catalogo.FrecuenciaMedicacionHabitualMapper;
import com.espe.salud.persistence.catalogo.FrecuenciaMedicacionHabitualRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("frecuenciaMedicacionHabitualServiceImpl")
public class FrecuenciaMedicacionHabitualServiceImpl extends GenericCRUDServiceImpl<FrecuenciaMedicacionHabitual, FrecuenciaMedicacionHabitualDTO> {

    private final FrecuenciaMedicacionHabitualRepository repository;
    private final FrecuenciaMedicacionHabitualMapper mapper;

    @Autowired
    public FrecuenciaMedicacionHabitualServiceImpl(FrecuenciaMedicacionHabitualRepository repository, FrecuenciaMedicacionHabitualMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FrecuenciaMedicacionHabitual mapTo(FrecuenciaMedicacionHabitualDTO dtoObject) {
        return mapper.toFrecuenciaMedicacionHabitual(dtoObject);
    }

    @Override
    public FrecuenciaMedicacionHabitualDTO build(FrecuenciaMedicacionHabitual domainObject) {
        return mapper.toFrecuenciaMedicacionHabitualDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FrecuenciaMedicacionHabitual> findExisting(FrecuenciaMedicacionHabitualDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FrecuenciaMedicacionHabitualDTO> findAllOrderByNameASC() {
        return mapper.toFrecuencias(repository.findAllByOrderByNombreAsc());
    }
}

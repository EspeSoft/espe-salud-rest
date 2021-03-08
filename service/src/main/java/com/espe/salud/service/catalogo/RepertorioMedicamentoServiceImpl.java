package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.RepertorioMedicamento;
import com.espe.salud.dto.catalogo.RepertorioMedicamentoDTO;
import com.espe.salud.mapper.catalogo.RepertorioMedicamentoMapper;
import com.espe.salud.persistence.catalogo.RepertorioMecicamentoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("repertorioMedicacionImpl")
public class RepertorioMedicamentoServiceImpl extends GenericCRUDServiceImpl<RepertorioMedicamento, RepertorioMedicamentoDTO> {
    private final RepertorioMedicamentoMapper mapper;
    private final RepertorioMecicamentoRepository repository;

    @Autowired
    public RepertorioMedicamentoServiceImpl(RepertorioMedicamentoMapper mapper, RepertorioMecicamentoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public RepertorioMedicamento mapTo(RepertorioMedicamentoDTO dtoObject) {
        return mapper.toRepertorioMedicamento(dtoObject);
    }

    @Override
    public RepertorioMedicamentoDTO build(RepertorioMedicamento domainObject) {
        return mapper.toRepertorioMedicamentoDTO(domainObject);
    }

    @Override
    public Optional<RepertorioMedicamento> findExisting(RepertorioMedicamentoDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<RepertorioMedicamentoDTO> findAllOrderByNameASC() {
        return mapper.toRepertoriosMedicamentosDTO(repository.findAllByOrderByNombreAsc());
    }
}

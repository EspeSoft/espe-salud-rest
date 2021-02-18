package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.UnidadDepartamento;
import com.espe.salud.dto.catalogo.UnidadDepartamentoDTO;
import com.espe.salud.mapper.catalogo.UnidadDepartamentoMapper;
import com.espe.salud.persistence.catalogo.UnidadDepartamentoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("unidadDepartamentoServiceImpl")
public class UnidadDepartamentoServiceImpl extends GenericCRUDServiceImpl<UnidadDepartamento, UnidadDepartamentoDTO>{

    private final UnidadDepartamentoRepository  domainRepository;
    private final UnidadDepartamentoMapper  mapper;

    @Autowired
    public UnidadDepartamentoServiceImpl(UnidadDepartamentoRepository domainRepository,
                                         UnidadDepartamentoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }


    @Override
    public UnidadDepartamento mapTo(UnidadDepartamentoDTO dtoObject) {
        return mapper.toUnidadDepartamento(dtoObject);
    }

    @Override
    public UnidadDepartamentoDTO build(UnidadDepartamento domainObject) {
        return mapper.toUnidadDepartamentoDTO(domainObject);
    }

    @Override
    public Optional<UnidadDepartamento> findExisting(UnidadDepartamentoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<UnidadDepartamentoDTO> findAllOrderByNameASC() {
        return mapper.toUnidadDepartamentoDTO(domainRepository.findAllByOrderByNombreAsc());
    }
}

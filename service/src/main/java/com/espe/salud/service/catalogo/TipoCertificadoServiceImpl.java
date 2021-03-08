package com.espe.salud.service.catalogo;


import com.espe.salud.domain.entities.catalogo.TipoCertificado;
import com.espe.salud.dto.catalogo.TipoCertificadoDTO;
import com.espe.salud.mapper.catalogo.TipoCertificadoMapper;
import com.espe.salud.persistence.catalogo.TipoCertificadoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("tipoCertificadoServiceImpl")
public class TipoCertificadoServiceImpl extends GenericCRUDServiceImpl<TipoCertificado, TipoCertificadoDTO> {

    private final TipoCertificadoRepository domainRepository;

    private final TipoCertificadoMapper mapper;

    @Autowired
    public TipoCertificadoServiceImpl(TipoCertificadoRepository domainRepository, TipoCertificadoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public TipoCertificado mapTo(TipoCertificadoDTO dtoObject) {
        return mapper.toTipoCertificado(dtoObject);
    }

    @Override
    public TipoCertificadoDTO build(TipoCertificado domainObject) {
        return mapper.toTipoCertificadoDTO(domainObject);
    }

    @Override
    public Optional<TipoCertificado> findExisting(TipoCertificadoDTO domainObject) {

        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<TipoCertificadoDTO> findAllOrderByNameASC() {
        return mapper.toTipoCertificadoDTO(domainRepository.findAllByOrderByNombreAsc());
    }
}

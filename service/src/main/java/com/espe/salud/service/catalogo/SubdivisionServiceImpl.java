package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Subdivision;
import com.espe.salud.domain.enums.TipoSubdivision;
import com.espe.salud.dto.catalogo.SubdivisionDTO;
import com.espe.salud.mapper.catalogo.SubdivisionMapper;
import com.espe.salud.persistence.catalogo.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubdivisionServiceImpl implements SubdivisionService {

    private final SubdivisionRepository domainRepository;

    private final SubdivisionMapper mapper;

    @Autowired
    public SubdivisionServiceImpl(SubdivisionRepository domainRepository,
                                             SubdivisionMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SubdivisionDTO> findById(Long id) {
        return domainRepository.findByCodigo(id).map(this::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubdivisionDTO> findAll() {
        return mapper.toSubdivisionsDTO(domainRepository.findAllByOrderByNombreAsc());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubdivisionDTO> getProvincias(Long idPais) {
        return mapper.toSubdivisionsDTO(domainRepository.findByPaisCodigoAndTipoOrderByNombreAsc(idPais, TipoSubdivision.PROVINCIA));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubdivisionDTO> getCantones(Long idPais) {
        return mapper.toSubdivisionsDTO(domainRepository.findByPaisCodigoAndTipoOrderByNombreAsc(idPais, TipoSubdivision.CANTON));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubdivisionDTO> getCantonesByProvincia(Long idPadre) {
        return mapper.toSubdivisionsDTO(domainRepository.findByPadreCodigoAndTipoOrderByNombreAsc(idPadre, TipoSubdivision.CANTON));
    }

    @Override
    public SubdivisionDTO toDTO(Subdivision subdivision) {
        return mapper.toSubdivisionDTO(subdivision);
    }
}

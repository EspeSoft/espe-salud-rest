package com.espe.salud.service.odontologia;

import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaCuantitativo;
import com.espe.salud.dto.odontologia.DetalleOdontogramaCuantitativoDTO;
import com.espe.salud.dto.odontologia.DetalleOdontogramaSimpleDTO;
import com.espe.salud.mapper.odontologia.DetalleOdontogramaCuantitativoMapper;
import com.espe.salud.persistence.odontologia.DetalleOdontogramaCuantitativoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("detalleOdontogramaCuantitativoServiceImpl")
public class DetalleOdontogramaCuantitativoServiceImpl extends GenericCRUDServiceOdontogramaImpl<DetalleOdontogramaCuantitativo, DetalleOdontogramaCuantitativoDTO> {

    private final DetalleOdontogramaCuantitativoRepository domainRepository;

    private final DetalleOdontogramaCuantitativoMapper mapper;

    @Autowired
    public DetalleOdontogramaCuantitativoServiceImpl(DetalleOdontogramaCuantitativoRepository domainRepository,
                                                     DetalleOdontogramaCuantitativoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public DetalleOdontogramaCuantitativo mapTo(DetalleOdontogramaCuantitativoDTO domainObject) {
        return mapper.toDetalleOdontogramaCuantitativo(domainObject);
    }

    @Override
    public DetalleOdontogramaCuantitativoDTO build(DetalleOdontogramaCuantitativo domainObject) {
        return mapper.toDetalleOdontogramaCuantitativoDTO(domainObject);
    }

    @Override
    public Optional<DetalleOdontogramaCuantitativo> findExisting(DetalleOdontogramaCuantitativoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<DetalleOdontogramaCuantitativoDTO> findAllOrderByNameASC() {
        return null;
    }

    @Override
    public List<DetalleOdontogramaCuantitativoDTO> findByHistoriaClinica(Long historiaId) {
        return mapper.toDetalleOdontogramaCuantitativoDTO(domainRepository.findByHistoriaId(historiaId));
    }
    @Override
    public void deleteByHistoriaClinica(Long historiaId) {
        domainRepository.findByHistoriaId(historiaId).forEach(detalle -> {
            domainRepository.deleteById(detalle.getCodigo());
        });
    }
}

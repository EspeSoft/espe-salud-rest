package com.espe.salud.service.odontologia;

import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaCompuesto;
import com.espe.salud.dto.odontologia.DetalleOdontogramaCompuestoDTO;
import com.espe.salud.dto.odontologia.DetalleOdontogramaCuantitativoDTO;
import com.espe.salud.mapper.odontologia.DetalleOdontogramaCompuestoMapper;
import com.espe.salud.persistence.odontologia.DetalleOdontogramaCompuestoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("detalleOdontogramaCompuestoServiceImpl")
public class DetalleOdontogramaCompuestoServiceImpl extends GenericCRUDServiceOdontogramaImpl<DetalleOdontogramaCompuesto, DetalleOdontogramaCompuestoDTO> {

    private final DetalleOdontogramaCompuestoRepository domainRepository;

    private final DetalleOdontogramaCompuestoMapper mapper;

    @Autowired
    public DetalleOdontogramaCompuestoServiceImpl(DetalleOdontogramaCompuestoRepository domainRepository,
                                                  DetalleOdontogramaCompuestoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public DetalleOdontogramaCompuesto mapTo(DetalleOdontogramaCompuestoDTO domainObject) {
        return mapper.toDetalleOdontogramaCompuesto(domainObject);
    }

    @Override
    public DetalleOdontogramaCompuestoDTO build(DetalleOdontogramaCompuesto domainObject) {
        return mapper.toDetalleOdontogramaCompuestoDTO(domainObject);
    }

    @Override
    public Optional<DetalleOdontogramaCompuesto> findExisting(DetalleOdontogramaCompuestoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<DetalleOdontogramaCompuestoDTO> findAllOrderByNameASC() {
        return null;
    }

    @Override
    public List<DetalleOdontogramaCompuestoDTO> findByHistoriaClinica(Long historiaId) {
        return mapper.toDetalleOdontogramaCompuestoDTO(domainRepository.findByHistoriaId(historiaId));
    }
    @Override
    public void deleteByHistoriaClinica(Long historiaId) {
        domainRepository.deleteByHistoriaId(historiaId);
    }
}

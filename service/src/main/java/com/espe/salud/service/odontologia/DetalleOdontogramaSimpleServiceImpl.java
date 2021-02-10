package com.espe.salud.service.odontologia;

import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaSimple;
import com.espe.salud.domain.entities.odontologia.HistoriaClinicaOdontologica;
import com.espe.salud.dto.odontologia.DetalleOdontogramaSimpleDTO;
import com.espe.salud.dto.odontologia.HistoriaClinicaOdontologicaDTO;
import com.espe.salud.mapper.odontologia.DetalleOdontogramaSimpleMapper;
import com.espe.salud.persistence.odontologia.DetalleOdontogramaSimpleRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("detalleOdontogramaSimpleServiceImpl")
public class DetalleOdontogramaSimpleServiceImpl extends GenericCRUDServiceOdontogramaImpl<DetalleOdontogramaSimple, DetalleOdontogramaSimpleDTO> {

    private final DetalleOdontogramaSimpleRepository domainRepository;

    private final DetalleOdontogramaSimpleMapper mapper;

    @Autowired
    public DetalleOdontogramaSimpleServiceImpl(DetalleOdontogramaSimpleRepository domainRepository,
                                               DetalleOdontogramaSimpleMapper mapper) {
        this.domainRepository = domainRepository;

        this.mapper = mapper;
    }

    @Override
    public DetalleOdontogramaSimple mapTo(DetalleOdontogramaSimpleDTO domainObject) {
        return mapper.toDetalleOdontogramaSimple(domainObject);
    }

    @Override
    public DetalleOdontogramaSimpleDTO build(DetalleOdontogramaSimple domainObject) {
        return mapper.toDetalleOdontogramaSimpleDTO(domainObject);
    }

    @Override
    public Optional<DetalleOdontogramaSimple> findExisting(DetalleOdontogramaSimpleDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<DetalleOdontogramaSimpleDTO> findAllOrderByNameASC() {
        return null;
    }

    @Override
    public List<DetalleOdontogramaSimpleDTO> findByHistoriaClinica(Long historiaId) {
        return mapper.toDetalleOdontogramaSimpleDTO(domainRepository.findByHistoriaId(historiaId));
    }

    @Override
    public void deleteByHistoriaClinica(Long historiaId) {
        domainRepository.deleteByHistoriaId(historiaId);
    }

}

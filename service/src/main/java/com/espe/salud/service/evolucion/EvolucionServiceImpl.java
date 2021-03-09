package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.MotivoAtencion;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.dto.catalogo.MotivoAtencionDTO;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.mapper.evolucion.EvolucionMapper;
import com.espe.salud.persistence.evolucion.EvolucionRepository;
import com.espe.salud.report.evolucion.EvolucionReportService;
import com.espe.salud.service.GenericCRUDService;
import com.espe.salud.service.catalogo.DispensarioService;
import com.espe.salud.service.enfermeria.NotaEnfermeriaService;
import com.espe.salud.service.usuario.AreaSaludService;
import com.espe.salud.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EvolucionServiceImpl implements EvolucionService {

    private final EvolucionRepository evolucionRepository;
    private final EvolucionMapper mapper;
    private final AreaSaludService serviceArea;
    private final NotaEnfermeriaService serviceNotEnf;
    private final DispensarioService serviceDisp;
    private final UsuarioService serviceUsu;
    private final GenericCRUDService<MotivoAtencion, MotivoAtencionDTO> serviceMot;
    private final EvolucionReportService reportService;


    @Autowired
    public EvolucionServiceImpl(
            EvolucionRepository evolucionRepository,
            EvolucionMapper mapper,
            AreaSaludService serviceArea,
            NotaEnfermeriaService serviceNotEnf,
            EvolucionReportService reportService,
            @Qualifier("dispensarioServiceImpl") DispensarioService serviceDisp,
            UsuarioService serviceUsu,
            @Qualifier("motivoAtencionServiceImpl") GenericCRUDService<MotivoAtencion, MotivoAtencionDTO> serviceMot) {
        this.evolucionRepository = evolucionRepository;
        this.mapper = mapper;
        this.serviceArea = serviceArea;
        this.serviceNotEnf = serviceNotEnf;
        this.serviceDisp = serviceDisp;
        this.serviceUsu = serviceUsu;
        this.serviceMot = serviceMot;
        this.reportService = reportService;
    }

    @Override
    @Transactional
    public EvolucionDTO save(EvolucionDTO evolucion) {
        Optional<Evolucion> optional = evolucionRepository.findByCodigo(evolucion.getId());
        if (optional.isEmpty()) {
            Evolucion domainObject = toEntity(evolucion);
            domainObject.addToDiagnosticos(domainObject.getDiagnosticos());
            domainObject.addToPrescripciones(domainObject.getPrescripciones());

            EvolucionDTO evolucionNuevo= toDTO(evolucionRepository.save(domainObject));

            evolucionNuevo.setAreaSalud(serviceArea.findById(evolucionNuevo.getIdAreaSalud()).orElse(null));
            evolucionNuevo.setNotaEnfermeria(serviceNotEnf.findById(evolucionNuevo.getIdNotaEnfermeria()).orElse(null));
            evolucionNuevo.setDispensario(serviceDisp.findById(evolucionNuevo.getIdDispensario()).orElse(null));
            evolucionNuevo.setUsuario(serviceUsu.findById(evolucionNuevo.getResponsablePidm()).orElse(null));
            evolucionNuevo.setMotivoAtencion(serviceMot.findById(evolucionNuevo.getIdMotivoAtencion()));
            return evolucionNuevo;
        } else {
            throw new ConflictException(String.format("Ya existe una evolucion registrada para ese código[%s]", evolucion.getId()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Evolucion> findExisting(EvolucionDTO evolucionDTO) {
        return evolucionRepository.findByCodigo(evolucionDTO.getId());
    }

    @Override
    public EvolucionDTO toDTO(Evolucion evolucion) {
        return mapper.toEvolucionDTO(evolucion);
    }

    @Override
    public Evolucion toEntity(EvolucionDTO dto) {
        return mapper.toEvolucion(dto);
    }

    @Override
    @Transactional
    public Boolean delete(String id) {
        return evolucionRepository.findById(id).map(evolucion -> {
            evolucionRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public EvolucionDTO update(EvolucionDTO dto) {
        Evolucion domainObject = toEntity(dto);
        EvolucionDTO evolucionNuevo= toDTO(evolucionRepository.save(domainObject));
        evolucionNuevo.setAreaSalud(serviceArea.findById(evolucionNuevo.getIdAreaSalud()).get());
        evolucionNuevo.setNotaEnfermeria(serviceNotEnf.findById(evolucionNuevo.getIdNotaEnfermeria()).get());
        evolucionNuevo.setDispensario(serviceDisp.findById(evolucionNuevo.getIdDispensario()).get());
        evolucionNuevo.setUsuario(serviceUsu.findById(evolucionNuevo.getResponsablePidm()).get());
        evolucionNuevo.setMotivoAtencion(serviceMot.findById(evolucionNuevo.getIdMotivoAtencion()));
        return evolucionNuevo;
    }

    @Override
    public Optional<EvolucionDTO> findById(String id) {
        return evolucionRepository.findById(id).map(this::toDTO);
    }

    @Override
    public List<EvolucionDTO> findByUsuario(Long pidm) {
        return mapper.toEvolucionesDTO(evolucionRepository.findByUsuarioPidm(pidm));
    }

    @Override
    public List<EvolucionDTO> findByPaciente(Long id) {
        return mapper.toEvolucionesDTO(evolucionRepository.findByPacienteCodigo(id));
    }

    @Override
    public byte[] getCertificadoMedico(String idEvolucion) {
//        Optional<Evolucion> evolucion = evolucionRepository.find
        Evolucion evolucion = new Evolucion();
        return this.reportService.generateCertificadoMedicoGeneral(evolucion);
    }
}

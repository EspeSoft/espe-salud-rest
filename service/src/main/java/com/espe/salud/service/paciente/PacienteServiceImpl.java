package com.espe.salud.service.paciente;

import com.espe.salud.banner.model.PersonaBanner;
import com.espe.salud.banner.service.PersonaBannerService;
import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.enums.TipoPaciente;
import com.espe.salud.dto.paciente.PacienteBannerDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.dto.paciente.PacienteExternoDTO;
import com.espe.salud.mapper.paciente.PacienteMapper;
import com.espe.salud.persistence.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper mapper;
    private final PersonaBannerService bannerService;

    @Autowired
    public PacienteServiceImpl(
            PacienteRepository pacienteRepository,
            PersonaBannerService bannerService,
            PacienteMapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = mapper;
        this.bannerService = bannerService;
    }

    @Override
    @Transactional
    public PacienteDTO saveExternal(PacienteExternoDTO pacienteDTO) {
        Optional<Paciente> optional = pacienteRepository.findByNumeroArchivo(pacienteDTO.getNumeroArchivo());
        if (optional.isEmpty()) {
            Paciente domainObject = mapper.fromPacienteExternoDTOToPaciente(pacienteDTO);
            domainObject.setPacienteAsExterno();
            domainObject.setNombreCompleto(domainObject.getPersona().getFullName());
            domainObject.getPersona().addToContactoEmergencia(domainObject.getPersona().getContactosEmergencia());
            return mapPacienteInfo(pacienteRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un paciente registrada para ese código[%s]", pacienteDTO.getNumeroArchivo()));
        }
    }

    @Override
    @Transactional
    public PacienteDTO saveBanner(PacienteBannerDTO pacienteBannerDTO) {
        Optional<Paciente> optional = pacienteRepository.findByNumeroArchivo(pacienteBannerDTO.getNumeroArchivo());
        if (optional.isEmpty()) {
            Paciente paciente = mapper.fromPacienteBannerDTOToPaciente(pacienteBannerDTO);
            paciente.setPacienteAsInterno();
            Optional<PersonaBanner> optionalPersonaBanner = bannerService.getPersonaBannerInfo(paciente.getNumeroArchivo());
            if (optionalPersonaBanner.isPresent()) {
                PersonaBanner personaBanner = optionalPersonaBanner.get();
                paciente.setNombreCompleto(personaBanner.getFullName());
                paciente = pacienteRepository.save(paciente);
                return mapper.fromPacienteAndPersonaBannerToPacienteDTO(paciente, personaBanner);
            }
            throw new ConflictException(String.format("El paciente con la cédula [%s] no se encuentra registrado en el sistema banner", pacienteBannerDTO.getNumeroArchivo()));
        } else {
            throw new ConflictException(String.format("Ya existe un paciente registrado para ese código[%s]", pacienteBannerDTO.getNumeroArchivo()));
        }
    }

    @Override
    public PacienteDTO updatePacienteExterno(PacienteExternoDTO paciente) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PacienteDTO> findById(Long codigo) {
        return pacienteRepository.findByCodigo(codigo).map(this::mapPacienteInfo);
    }

    @Override
    @Transactional
    public void darBajaPaciente(Long codigo) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(codigo);
        if (optionalPaciente.isPresent()) {
            Paciente paciente = optionalPaciente.get();
            paciente.disablePatient();
            pacienteRepository.save(paciente);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PacienteDTO> findExistingByNumeroArchivo(String numeroArchivo) {
        return pacienteRepository.findByNumeroArchivo(numeroArchivo).map(this::mapPacienteInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByNumeroArchivo(String numeroArchivo) {
        return pacienteRepository.existsByNumeroArchivo(numeroArchivo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteDTO> findByNumeroArchivo(String numeroArchivo) {
        List<Paciente> pacientes = pacienteRepository.findByNumeroArchivoStartingWith(numeroArchivo);
        List<PacienteDTO> dtos = new ArrayList<>();
        pacientes.forEach(paciente -> dtos.add(mapPacienteInfo(paciente)));
        return dtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteDTO> findByFullName(String query) {
        query = query.toUpperCase();
        List<Paciente> pacientes = pacienteRepository.findByNombreCompletoContains(query);
        List<PacienteDTO> dtos = new ArrayList<>();
        pacientes.forEach(paciente -> dtos.add(mapPacienteInfo(paciente)));
        return dtos;
    }

    @Override
    public PacienteDTO mapPacienteInfo(Paciente paciente) {
        if (paciente.getTipoPaciente() == TipoPaciente.INTERNO) {
            Optional<PersonaBanner> optionalPersonaBanner = bannerService.getPersonaBannerInfo(paciente.getNumeroArchivo());
            if (optionalPersonaBanner.isPresent()) {
                return mapper.fromPacienteAndPersonaBannerToPacienteDTO(paciente, optionalPersonaBanner.get());
            }
            return mapper.toPacienteDTO(paciente);
        }
        return mapper.toPacienteDTO(paciente);
    }
}

package com.espe.salud.service.paciente;

import com.espe.salud.banner.model.PersonaBanner;
import com.espe.salud.banner.service.PersonaBannerService;
import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.entities.paciente.Persona;
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
            Persona persona = domainObject.getPersona();
            domainObject.setNombreCompleto(persona.getFullName());
            persona.addToContactoEmergencia(persona.getContactosEmergencia());
            domainObject.setPersona(persona);
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
    @Transactional
    public PacienteDTO updatePacienteExterno(PacienteExternoDTO paciente, Paciente actual) {
        Paciente domainObject = mapper.fromPacienteExternoDTOToPaciente(paciente);
        Persona personaNueva = domainObject.getPersona();
        Persona personaActual = actual.getPersona();
        personaActual.setApellidoPaterno(personaNueva.getApellidoPaterno());
        personaActual.setApellidoMaterno(personaNueva.getApellidoMaterno());
        personaActual.setPrimerNombre(personaNueva.getPrimerNombre());
        personaActual.setSegundoNombre(personaNueva.getSegundoNombre());
        personaActual.setCedula(personaNueva.getCedula());
        personaActual.setFechaNacimiento(personaNueva.getFechaNacimiento());
        personaActual.setSexo(personaNueva.getSexo());
        personaActual.setEstadoCivil(personaNueva.getEstadoCivil());
        personaActual.setReligion(personaNueva.getReligion());
        personaActual.setGrupoSanguineo(personaNueva.getGrupoSanguineo());
        personaActual.setInstruccion(personaNueva.getInstruccion());
        personaActual.setProfesion(personaNueva.getProfesion());
        personaActual.setPueblos(personaNueva.getPueblos());
        personaActual.setEtnia(personaNueva.getEtnia());
        personaActual.setPaisNacimiento(personaNueva.getPaisNacimiento());
        personaActual.setProvinciaNacimiento(personaNueva.getProvinciaNacimiento());
        personaActual.setIdProvinciaNacimiento(personaNueva.getIdProvinciaNacimiento());
        personaActual.setCantonNacimiento(personaNueva.getCantonNacimiento());
        personaActual.setIdCantonNacimiento(personaNueva.getIdCantonNacimiento());
        personaActual.setNacionalidad(personaNueva.getNacionalidad());
        personaActual.setNacionalidad2(personaNueva.getNacionalidad2());
        personaActual.setContacto(personaNueva.getContacto());

        actual.setNombreCompleto(personaNueva.getFullName());
        actual.setAceptaTransfucion(domainObject.getAceptaTransfucion());
        actual.setLateralidad(domainObject.getLateralidad());
        actual.setVinculadoEspe(domainObject.getVinculadoEspe());
        actual.setSeguroSalud(domainObject.getSeguroSalud());
        actual.setAsociacionAfiliada(domainObject.getAsociacionAfiliada());
        actual.setInstruccion(domainObject.getInstruccion());
        actual.setIdDispensario(domainObject.getIdDispensario());

        actual.setPersona(personaActual);
        return mapPacienteInfo(pacienteRepository.save(actual));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PacienteDTO> findById(Long codigo) {
        return pacienteRepository.findByCodigo(codigo).map(this::mapPacienteInfo);
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
        return mapper.fromExternalPacienteToPacienteDTO(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Paciente> findExisting(Long id) {
        return pacienteRepository.findByCodigo(id);
    }
}

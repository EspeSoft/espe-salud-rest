package com.espe.salud.service.paciente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.entities.paciente.Persona;
import com.espe.salud.dto.paciente.PacienteBannerDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.dto.paciente.PacienteExternoDTO;
import com.espe.salud.mapper.paciente.PacienteMapper;
import com.espe.salud.persistence.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper mapper;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, PacienteMapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public PacienteDTO saveExternal(PacienteExternoDTO pacienteDTO) {
        Optional<Paciente> optional = findExistingByNumeroArchivo(pacienteDTO.getNumeroArchivo());
        if (optional.isEmpty()) {
            Paciente domainObject = mapper.fromPacienteExternoDTOToPaciente(pacienteDTO);
            domainObject.getPersona().addToContactoEmergencia(domainObject.getPersona().getContactosEmergencia());
            return mapper.toPacienteDTO(pacienteRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un paciente registrada para ese código[%s]", pacienteDTO.getNumeroArchivo()));
        }
    }

    @Override
    @Transactional
    public PacienteDTO saveBanner(PacienteBannerDTO pacienteBannerDTO) {
        Optional<Paciente> optional = findExistingByNumeroArchivo(pacienteBannerDTO.getNumeroArchivo());
        if (optional.isEmpty()) {
            Paciente paciente = mapper.fromPacienteBannerDTOToPaciente(pacienteBannerDTO);
            return mapper.toPacienteDTO(pacienteRepository.save(paciente));
        } else {
            throw new ConflictException(String.format("Ya existe un paciente registrada para ese código[%s]", pacienteBannerDTO.getNumeroArchivo()));
        }
    }

    //    @Override
//    public PacienteDTO update(PacienteDTO paciente) {
//        Paciente domainObject = toEntity(paciente);
//        return toDTO(pacienteRepository.save(domainObject));
//    }
//
    @Override
    public Optional<Paciente> findExistingByNumeroArchivo(String numeroArchivo) {
        return pacienteRepository.findByNumeroArchivo(numeroArchivo);
    }
//
//    @Override
//    public Boolean delete(Long id) {
//        return pacienteRepository.findById(id).map(object -> {
//            pacienteRepository.deleteById(id);
//            return true;
//        }).orElse(false);
//    }
//
//    @Override
//    public Optional<PacienteDTO> findByCodigo(Long codigo) {
//        return pacienteRepository.findByCodigo(codigo).map(paciente -> mapper.toPacienteDTO(paciente));
//    }

    @Override
    public List<PacienteDTO> findAll() {
        List<Paciente> pacientes = new ArrayList<>();
        pacienteRepository.findAll().forEach(pacientes::add);
        return mapper.toPacientesDTO(pacientes);
    }
}

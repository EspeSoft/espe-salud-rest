package com.espe.salud.service.odontologia;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.odontologia.HistoriaClinicaOdontologica;
import com.espe.salud.dto.odontologia.HistoriaClinicaOdontologicaDTO;
import com.espe.salud.mapper.odontologia.HistoriaClinicaOdontologicaMapper;
import com.espe.salud.persistence.odontologia.HistoriaClinicaOdontologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaOdontologicaServiceImpl implements HistoriaClinicaOdontologicaService {

    private final HistoriaClinicaOdontologicaRepository domainRepository;
    private final HistoriaClinicaOdontologicaMapper mapper;

    @Autowired
    public HistoriaClinicaOdontologicaServiceImpl(HistoriaClinicaOdontologicaRepository domainRepository,
                                                  HistoriaClinicaOdontologicaMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public HistoriaClinicaOdontologicaDTO save(HistoriaClinicaOdontologicaDTO historiaClinicaOdontologica) {
        Optional<HistoriaClinicaOdontologica> optional = domainRepository.findByCodigo(historiaClinicaOdontologica.getId());
        if (optional.isEmpty()) {
            HistoriaClinicaOdontologica domainObject = toEntity(historiaClinicaOdontologica);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una historia clinica registrada para ese código[%s]", historiaClinicaOdontologica.getId()));
        }
    }

    @Override
    public boolean delete(Long id) {
        return domainRepository.findById(id).map(historiaClinicaOdontologica -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public HistoriaClinicaOdontologicaDTO update(HistoriaClinicaOdontologicaDTO historiaClinicaOdontologicaDTO) {
        HistoriaClinicaOdontologica domainObject=toEntity(historiaClinicaOdontologicaDTO);
        return toDTO(domainRepository.save(domainObject));
    }

    @Override
    public List<HistoriaClinicaOdontologicaDTO> findAll() {
        return mapper.toHistoriasClinicasOdontologicasDTO(domainRepository.findAll());
    }

    @Override
    public Optional<HistoriaClinicaOdontologicaDTO> findByPaciente(Long idPaciente) {
        return Optional.of(this.toDTO(domainRepository.findByPacienteCodigo(idPaciente)));
    }

    @Override
    public Optional<HistoriaClinicaOdontologicaDTO> findById(Long idPaciente) {
        return domainRepository.findById(idPaciente).map(this::toDTO);
    }

    @Override
    public HistoriaClinicaOdontologicaDTO toDTO(HistoriaClinicaOdontologica historiaClinicaOdontologica) {
        return mapper.toHistoriaClinicaOdontologicaDTO(historiaClinicaOdontologica);
    }

    @Override
    public HistoriaClinicaOdontologica toEntity(HistoriaClinicaOdontologicaDTO dto) {
        return mapper.toHistoriaClinicaOdontologica(dto);
    }
}

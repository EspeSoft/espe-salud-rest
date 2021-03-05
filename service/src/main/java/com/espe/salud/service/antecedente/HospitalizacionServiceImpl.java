package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import com.espe.salud.domain.entities.antecedente.Hospitalizacion;
import com.espe.salud.dto.antecedente.HospitalizacionDTO;
import com.espe.salud.mapper.antecedente.HospitalizacionMapper;
import com.espe.salud.persistence.antecedente.HospitalizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalizacionServiceImpl implements HospitalizacionService{

    private final HospitalizacionRepository repository;
    private final HospitalizacionMapper mapper;

    @Autowired
    public HospitalizacionServiceImpl(
            HospitalizacionRepository repository,
            HospitalizacionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public HospitalizacionDTO save(HospitalizacionDTO hospitalizacionDTO) {
        Optional<Hospitalizacion> optional = repository.findByCodigo(hospitalizacionDTO.getId());
        if (optional.isEmpty()) {
            Hospitalizacion domainObject = mapper.toHospitalizacion(hospitalizacionDTO);
            return mapper.toHospitalizacionDTO(repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una estudio complementario para ese código[%s]", hospitalizacionDTO.getId()));
        }
    }

    @Override
    @Transactional
    public HospitalizacionDTO update(HospitalizacionDTO hospitalizacionDTO) {
        return mapper.toHospitalizacionDTO(repository.save(mapper.toHospitalizacion(hospitalizacionDTO)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<HospitalizacionDTO> findById(Long codigo) {
        return repository.findById(codigo).map(mapper::toHospitalizacionDTO);
    }

    @Override
    @Transactional
    public boolean delete(Long codigo) {
        return repository.findById(codigo).map(domainObject -> {
            repository.deleteById(codigo);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HospitalizacionDTO> findByPaciente(Long idPaciente) {
        return mapper.toHospitalizacionesDTO(repository.findByPacienteCodigo(idPaciente));
    }
}

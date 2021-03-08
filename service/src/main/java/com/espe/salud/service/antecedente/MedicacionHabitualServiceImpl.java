package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.MedicacionHabitual;
import com.espe.salud.dto.antecedente.MedicacionHabitualDTO;
import com.espe.salud.mapper.antecedente.MedicacionHabitualMapper;
import com.espe.salud.persistence.antecedente.MedicacionHabitualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicacionHabitualServiceImpl implements MedicacionHabitualService {

    private final MedicacionHabitualRepository repository;
    private final MedicacionHabitualMapper mapper;

    @Autowired
    public MedicacionHabitualServiceImpl(
            MedicacionHabitualRepository medicacionHabitualRepository,
            MedicacionHabitualMapper mapper) {
        this.repository = medicacionHabitualRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public MedicacionHabitualDTO save(MedicacionHabitualDTO medicacionHabitualDTO) {
        Optional<MedicacionHabitual> optional = repository.findByCodigo(medicacionHabitualDTO.getId());
        if (optional.isEmpty()) {
            MedicacionHabitual domainObject = mapper.toMedicacionHabitual(medicacionHabitualDTO);
            return mapper.toMedicacionHabitualDTO(repository.save(domainObject));
        } else {
            throw new ConflictException("Ya existe una medicación habitual para ese ID");
        }
    }

    @Override
    @Transactional
    public MedicacionHabitualDTO update(MedicacionHabitualDTO medicacionHabitualDTO) {
        MedicacionHabitual domainObject = mapper.toMedicacionHabitual(medicacionHabitualDTO);
        return mapper.toMedicacionHabitualDTO(repository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MedicacionHabitualDTO> findById(Long codigo) {
        return repository.findByCodigo(codigo).map(mapper::toMedicacionHabitualDTO);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return repository.findById(id).map(antecedentePatologicoFamiliar -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicacionHabitualDTO> findByPaciente(Long idPaciente) {
        return mapper.toMedicacionesHabitualesDTO(repository.findByAntecedentePersonalPacienteCodigo(idPaciente));
    }
}

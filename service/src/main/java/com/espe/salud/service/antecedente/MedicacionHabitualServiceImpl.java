package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.MedicacionHabitual;
import com.espe.salud.dto.antecedente.MedicacionHabitalDTO;
import com.espe.salud.mapper.antecedente.MedicacionHabitualMapper;
import com.espe.salud.persistence.antecedente.MedicacionHabitualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicacionHabitualServiceImpl implements MedicacionHabitualService {

    private final MedicacionHabitualRepository medicacionHabitualRepository;
    private final MedicacionHabitualMapper mapper;

    @Autowired
    public MedicacionHabitualServiceImpl(MedicacionHabitualRepository medicacionHabitualRepository, MedicacionHabitualMapper mapper) {
        this.medicacionHabitualRepository = medicacionHabitualRepository;
        this.mapper = mapper;
    }

    @Override
    public MedicacionHabitalDTO save(MedicacionHabitalDTO medicacionHabitalDTO) {
        MedicacionHabitual domainObject = toEntity(medicacionHabitalDTO);
        return toDTO(medicacionHabitualRepository.save(domainObject));
    }

    @Override
    public MedicacionHabitalDTO update(MedicacionHabitalDTO medicacionHabitalDTO) {
        MedicacionHabitual domainObject = toEntity(medicacionHabitalDTO);
        return toDTO(medicacionHabitualRepository.save(domainObject));
    }

    @Override
    public Optional<MedicacionHabitalDTO> findById(Long codigo) {
        return medicacionHabitualRepository.findById(codigo).map(medicacionHabitual -> toDTO(medicacionHabitual));
    }

    @Override
    public Optional<MedicacionHabitual> findExisting(MedicacionHabitalDTO medicacionHabitalDTO) {
        return medicacionHabitualRepository.findByCodigo(medicacionHabitalDTO.getId());
    }

    @Override
    public List<MedicacionHabitalDTO> findAll() {
        return mapper.toMedicacionHabitualDTO(medicacionHabitualRepository.findAll());
    }

    @Override
    public List<MedicacionHabitalDTO> findByIdAntecedentePersonal(Long idAntecedentePersonal) {
        return mapper.toMedicacionHabitualDTO(medicacionHabitualRepository.findByIdAntecedentePersonal(idAntecedentePersonal));
    }

    @Override
    public boolean deleteById(Long id) {
        return medicacionHabitualRepository.findById(id).map(medicacionHabitual -> {
            medicacionHabitualRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public MedicacionHabitalDTO toDTO(MedicacionHabitual medicacionHabitual) {
        return mapper.toMedicacionHabitualDTO(medicacionHabitual);
    }

    @Override
    public MedicacionHabitual toEntity(MedicacionHabitalDTO dto) {
        return mapper.toMedicacionHabitual(dto);
    }
}

package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.MedicacionHabitual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicacionHabitualRepository extends JpaRepository<MedicacionHabitual, Long> {
    Optional<MedicacionHabitual> findByCodigo(Long codigo);

    List<MedicacionHabitual> findByIdAntecedentePersonal(Long idAntecedentePersonal);
}

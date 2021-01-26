package com.espe.salud.persistence.paciente;

import com.espe.salud.domain.entities.catalogo.Parentesco;
import com.espe.salud.domain.entities.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNumeroArchivoStartingWith(String numeroArchivo);
    Optional<Paciente> findByCodigo(Long codigo);

//    @Query("select p from PacientePK p where p.numeroArchivo=?1")
//    Optional<PacientePK> findByNumeroArchivo(String numeroArchivo);
}

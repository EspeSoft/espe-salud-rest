package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.NacionalidadPueblo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NacionalidadPuebloRepository extends JpaRepository<NacionalidadPueblo, Long> {
//    List<NacionalidadPueblo> findByGrupoCulturalIdOrderByNombreAsc(Integer idGrupoCultural);
    // TODO Descomentar despues de relacionar con grupo cultural
    List<NacionalidadPueblo> findAllByOrderByNombreAsc();
    Optional<NacionalidadPueblo> findByCodigo(Long codigo);
}

package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.domain.entities.evolucion.ExamenExterno;
import com.espe.salud.domain.entities.evolucion.ExamenInterno;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCARE", schema = "SALUD")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCARE_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCARE_NOMBRE")
    private String nombre;


    //relaciones
    @OneToMany(mappedBy = "idArea", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExamenExterno> examenesExternos;

    //
    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Region> regiones;
}

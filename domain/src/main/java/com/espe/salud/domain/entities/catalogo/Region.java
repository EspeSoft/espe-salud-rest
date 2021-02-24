package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.evolucion.ExamenExterno;
import com.espe.salud.domain.entities.evolucion.ExamenInterno;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTCREG", schema = "SALUD")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCREG_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCREG_NOMBRE")
    private String nombre;

    @Column(name = "FK_ARE_REG")
    private Long idArea;

    //relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ARE_REG", insertable = false, updatable = false, nullable = false)
    private Area area;


}

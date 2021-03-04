package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTCMOTATE", schema = "SALUD")
public class MotivoAtencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCMOTATE_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCMOTATE_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "areaSalud", cascade = CascadeType.ALL)
    private List<Evolucion> evoluciones;
}

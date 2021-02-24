package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.evolucion.ExamenExterno;
import com.espe.salud.domain.entities.evolucion.Procedimiento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCTIPPROCE", schema = "SALUD")
public class TipoProcedimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPPROCE_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPPROCE_NOMBRE")
    private String nombre;

    //relaciones
    @OneToMany(mappedBy = "tipoProcedimiento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Procedimiento> procedimientos;
}

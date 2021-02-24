package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.enfermeria.ActividadEnfermeria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCTIPEXALAB", schema = "SALUD")
public class TipoExamenLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPEXALAB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPEXALAB_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "tipoExamenLaboratorio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TipoDetalleExamenLaboratorio> tipoDetalleExamenLaboratorios;

}

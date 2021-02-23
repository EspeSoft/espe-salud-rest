package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.enfermeria.ActividadEnfermeria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCTIPACTENF", schema = "SALUD")
public class TipoActividadEnfermeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPACTENF_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPACTENF_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "tipoActividadEnfermeria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DescripcionActividadEnfermeria> descripcionActividadEnfermerias;

    @OneToMany(mappedBy = "tipoActividadEnfermeria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ActividadEnfermeria> actividadesEnfermerias;
}

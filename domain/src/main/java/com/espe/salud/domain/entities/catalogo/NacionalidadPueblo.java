package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCNACPUE", schema = "SALUD")
public class NacionalidadPueblo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCNACPUE_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCNACPUE_NOMBRE")
    private String nombre;

    // TODO Add Many to One with Grupo Cultural
}

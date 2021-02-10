package com.espe.salud.domain.entities.catalogo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "MZSTCSED", schema = "SALUD")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCSED_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCSED_NOMBRE")
    @Size(max = 100)
    private String nombre;

    //CANTON ES UNA ENTIDAD QUE AUN NO ESTA CREADA
    @Column(name = "MZSTCSED_CANTON")
    @Size(max = 100)
    private String canton;

    @Column(name = "MZSTCSED_PARROQUIA")
    @Size(max = 100)
    private String parroquia;
}
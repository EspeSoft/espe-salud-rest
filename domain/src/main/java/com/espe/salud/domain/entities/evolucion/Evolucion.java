package com.espe.salud.domain.entities.evolucion;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTEVO", schema = "SALUD")
public class Evolucion {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consignne_generator")

    @Basic(optional = false)
    @Column(name = "MZSTEVO_CODIGO")
    private Long codigo;
}

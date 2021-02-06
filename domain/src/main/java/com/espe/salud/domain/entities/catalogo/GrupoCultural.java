package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.paciente.Paciente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCGRUCUL", schema = "SALUD")
public class GrupoCultural {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCGRUCUL_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCGRUCUL_NOMBRE")
    @Size(max = 150)
    private String nombre;

    //@OneToMany(mappedBy = "grupo_cultural", cascade = CascadeType.ALL)
    //private List<Paciente> pacientes;
}
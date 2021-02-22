package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.antecedente.Certificado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCTIPCER", schema = "SALUD")
public class TipoCertificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPCER_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPCER_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "tipoCertificado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Certificado> certificados;
}

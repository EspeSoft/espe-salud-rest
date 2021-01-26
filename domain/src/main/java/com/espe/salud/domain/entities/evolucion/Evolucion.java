package com.espe.salud.domain.entities.evolucion;

import com.espe.salud.domain.generators.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import org.hibernate.annotations.Parameter;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MZSTEVO", schema = "SALUD")
public class Evolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evolucion_sequence")
    @GenericGenerator(
            name = "evolucion_sequence",
            strategy = "com.espe.salud.domain.generators.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EV_"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%07d") })
    @Column(name = "MZSTEVO_CODIGO")
    private String codigo;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
}

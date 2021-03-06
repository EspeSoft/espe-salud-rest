package com.espe.salud.report.evolucion;

import com.espe.salud.common.exception.EspeSaludException;
import com.espe.salud.common.exception.enums.TipoReporte;
import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.domain.entities.catalogo.RepertorioMedicamento;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.domain.entities.evolucion.Prescripcion;
import com.espe.salud.domain.entities.usuario.AreaSalud;
import com.espe.salud.persistence.catalogo.DispensarioRepository;
import com.espe.salud.persistence.catalogo.RepertorioMedicamentoRepository;
import com.espe.salud.persistence.evolucion.PrescripcionRepository;
import com.espe.salud.persistence.usuario.AreaSaludRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvolucionReportServiceImpl implements EvolucionReportService {

    private final DispensarioRepository dispensarioRepository;
    private final AreaSaludRepository areaSaludRepository;
    private final PrescripcionRepository prescripcionRepository;
    private final RepertorioMedicamentoRepository medicamentoRepository;

    @Autowired
    public EvolucionReportServiceImpl(DispensarioRepository dispensarioRepository, AreaSaludRepository areaSaludRepository, PrescripcionRepository prescripcionRepository, RepertorioMedicamentoRepository medicamentoRepository) {
        this.dispensarioRepository = dispensarioRepository;
        this.areaSaludRepository = areaSaludRepository;
        this.prescripcionRepository = prescripcionRepository;
        this.medicamentoRepository = medicamentoRepository;
    }
    private HashMap<String, String> hmapDispensario;
    private HashMap<Long, String> hmapAreaSalud;
    private HashMap<String, Integer> hmapPrescripcion;
    private HashMap<String, String> hmapMedicamento;

    @PostConstruct
    public void init() {
        System.out.println("Iniciando evolucion report service");
    }

    public void cargarDatos(Evolucion evolucion){

        Optional<Dispensario> lstDispensarios = dispensarioRepository.findByCodigo(evolucion.getIdDispensario());
        Optional<AreaSalud> lstAreaSalud =  areaSaludRepository.findByCodigo(evolucion.getIdAreaSalud());
        List<Prescripcion> lstPrescrip = prescripcionRepository.findByEvolucionCodigo(evolucion.getCodigo());

        hmapDispensario = (HashMap<String, String>) lstDispensarios.stream().collect(Collectors.toMap(Dispensario::getInstitucionSistema, Dispensario::getUnidadOperativa));
        hmapAreaSalud = (HashMap<Long, String>) lstAreaSalud.stream().collect(Collectors.toMap(AreaSalud::getCodigo,AreaSalud::getNombre));
        hmapPrescripcion = (HashMap<String, Integer>) lstPrescrip.stream().collect(Collectors.toMap(Prescripcion::getDosis, Prescripcion::getCantidad));
        hmapMedicamento = (HashMap<String, String>) lstPrescrip.stream().collect(Collectors.toMap(Prescripcion::getPresentacion, Prescripcion::getNombreMedicamento));
    }

    @Override
    public byte[] generateCertificadoMedicoGeneral(Evolucion evolucion) {
        cargarDatos(evolucion);
        try {
            //Select template
            StringBuilder sbTemplate = new StringBuilder("com.espe.salud.report/");
            sbTemplate.append(TipoReporte.CERTIFICADO_MEDICO_GENERAL.getKey());
            sbTemplate.append(".jrxml");
            String template = sbTemplate.toString();
            InputStream reportStream = ClassLoader.getSystemResources(template).nextElement().openStream();

            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            final Map<String, Object> parameters = new HashMap<>();
            parameters.put("hmapDispensario", hmapDispensario);
            parameters.put("hmapAreaSalud", hmapAreaSalud);
            parameters.put("hmapPrescripcion", hmapPrescripcion);
            parameters.put("hmapMedicamento", hmapMedicamento);
//            parameters.put("createdBy", "javacodegeek.com");

            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(evolucion.getPrescripciones());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, data);
            if (jasperPrint == null) {
                throw new EspeSaludException("No se pudo generar el certificado");
            }
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            throw new EspeSaludException("Ocurrió un error interno al generar el certificado médico en PDF");
        }
    }
}

package com.espe.salud.report.evolucion;

import com.espe.salud.common.exception.EspeSaludException;
import com.espe.salud.common.exception.enums.TipoReporte;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class EvolucionReportServiceImpl implements EvolucionReportService{

    @PostConstruct
    public void init() {
        System.out.println("Iniciando evolucion report service");
    }

    @Override
    public byte[] generateCertificadoMedicoGeneral(Evolucion evolucion) {
        try {
            //Select template
            StringBuilder sbTemplate = new StringBuilder("com.espe.salud.report/");
            sbTemplate.append(TipoReporte.CERTIFICADO_MEDICO_GENERAL.getKey());
            sbTemplate.append(".jrxml");
            String template = sbTemplate.toString();
            InputStream reportStream = ClassLoader.getSystemResources(template).nextElement().openStream();

            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            final Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "javacodegeek.com");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
            if (jasperPrint == null) {
                throw new EspeSaludException("No se pudo generar el certificado");
            }
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            throw new EspeSaludException("Ocurrió un error interno al generar el certificado médico en PDF");
        }
    }
}

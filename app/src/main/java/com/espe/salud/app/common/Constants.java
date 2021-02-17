package com.espe.salud.app.common;

public class Constants {
    private Constants() {
    }

    // GENERAL
    private static final String URI_API_V1 = "/api/v1.0/";

    // CATALOGOS
    public static final String URI_API_V1_AREA = URI_API_V1 + "areas";
    public static final String URI_API_V1_ASO = URI_API_V1 +  "asociaciones";
    public static final String URI_API_V1_COD_CIUO = URI_API_V1 + "codigos-ciuo";
    public static final String URI_API_V1_DETEXALAB=URI_API_V1 + "detalles-laboratorio"; // TODO Revisar el nombre del endpoint
    public static final String URI_API_V1_DISP=URI_API_V1 + "dispensarios";
    public static final String URI_API_V1_ENFERMEDAD_CIE10 = URI_API_V1 + "tipos-enfermedad-cie10";




    public static final String URI_API_V1_TIP_EST_COM = URI_API_V1 + "tipos-estudio-complementario";



    public static final String URI_API_V1_PAR = URI_API_V1 + "parentescos";
    public static final String URI_API_V1_RIE_QUI = URI_API_V1 + "riesgos-quimicos";
    public static final String URI_API_V1_RIE_FIS = URI_API_V1 + "riesgos-fisicos";
    public static final String URI_API_V1_RIE_MEC = URI_API_V1 + "riesgos-mecanicos";
    public static final String URI_API_V1_RIE_BIO = URI_API_V1 + "riesgos-biologicos";
    public static final String URI_API_V1_RIE_ERG = URI_API_V1 + "riesgos-ergonomicos";
    public static final String URI_API_V1_RIE_PSI = URI_API_V1 + "riesgos-psicosociales";
    public static final String URI_API_V1_EVO = URI_API_V1 + "evoluciones";
    public static final String URI_API_V1_PAC = URI_API_V1 + "pacientes";
    public static final String URI_API_V1_NOT_ENF = URI_API_V1 + "notas-enfermeria";
    public static final String URI_API_V1_HIS_CLI_ODO = URI_API_V1 + "historia-clinica-odontologica";
    public static final String URI_API_V1_ENF_PRO_ACT = URI_API_V1 + "enfermedad-problema-actual";
    public static final String URI_API_V1_ODO_ODO = URI_API_V1 + "odontograma";
    public static final String URI_API_V1_IND_SAL_BUC = URI_API_V1 + "indicador-salud-bucal";
    public static final String URI_API_V1_EXA_SIS_EST = URI_API_V1 + "examen-sistema-estomatignatico";

    public static final String URI_API_V1_USU = URI_API_V1 + "usuarios";
    public static final String URI_API_V1_TIP_DIS = URI_API_V1 + "tipos-discapacidad";
    public static final String URI_API_V1_NAC_PUE = URI_API_V1 + "nacionalidades-pueblos";
    public static final String URI_API_V1_MOT_ATE = URI_API_V1 + "motivos-atencion";
    public static final String URI_API_V1_NEC_SOC = URI_API_V1 + "necesidades-sociales";
    public static final String URI_API_V1_TIP_PLA_FAM = URI_API_V1 + "tipos-planificacion-familiar";
    public static final String URI_API_V1_PRO_SOC = URI_API_V1 + "problemas-sociales";
    public static final String URI_API_V1_TIP_ING = URI_API_V1 + "tipos-ingresos";
    public static final String URI_API_V1_TIP_EGR = URI_API_V1 + "tipos-egresos";

    public static final String URI_API_V1_EMP = URI_API_V1 + "empleados";
    public static final String URI_API_V1_EST = URI_API_V1 + "estudiantes";

    public static final String URI_API_V1_PRO = URI_API_V1 + "procedimientos";
    public static final String URI_API_V1_DIA = URI_API_V1 + "diagnosticos";
    public static final String URI_API_V1_REC_LAB = URI_API_V1 + "records-laborales";
    public static final String URI_API_V1_ACT_FIS= URI_API_V1 + "actividades-fisicas";
    public static final String URI_API_V1_ANT_PER= URI_API_V1 + "antecedentes-personales";
    public static final String URI_API_V1_CON_NOC= URI_API_V1 + "consumos-nocivos";

    public static final String URI_API_V1_REG = URI_API_V1 + "regiones";
    public static final String URI_API_V1_ORG_SIST = URI_API_V1 + "organos-sistema";

    public static final String URI_API_V1_SED=URI_API_V1 + "sedes";
    public static final String URI_API_V1_GRU_CUL=URI_API_V1+"grupo-cultural";
    public static final String URI_API_V1_DISP=URI_API_V1+"dispensarios";
    public static final String URI_API_V1_ANTE_PAT_FAM=URI_API_V1 +"antecedente-patologico-familiar";
    public static final String URI_API_V1_ANTE_QUIRURGICO=URI_API_V1+"antecedente-quirurgico";
    public static final String URI_API_V1_DISCAPACIDAD=URI_API_V1+"dicapacidad";


    public static final String URI_API_V1_PAI = URI_API_V1 + "pais";
    public static final String URI_API_V1_CON_NOC = URI_API_V1 + "consumos-nocivos";
    
    public static final String URI_API_V1_SUB = URI_API_V1 + "subdivision";

    public static final String URI_API_V1_SEGSAL = URI_API_V1 +  "seguro-salud";
    public static final String URI_API_V1_TIPCER = URI_API_V1 +  "tipos-certificado";
    public static final String URI_API_V1_UNIDEP = URI_API_V1 +  "unidad-departamento";


    public static final String URI_API_V1_TIP_ENF = URI_API_V1 + "tipos-enfermedades";
    public static final String URI_API_V1_EST_COM = URI_API_V1 + "estudios-complementarios";

    public static final String URI_API_V1_TIPO_PROC = URI_API_V1 + "tipos procedimiento";
    public static final String URI_API_V1_GRUPO_ENFERMEDAD = URI_API_V1 + "grupos-enfermedad-cie10";

    public static final String URI_API_V1_ANT_PATOLOGICO_PERSONAL=URI_API_V1+"antecedentes-patologicos-perosnales";
    public static final String URI_API_V1_MED_HABITUAL=URI_API_V1+"medicacion-habitual";

    public static final String URI_API_V1_EXALAB=URI_API_V1+"examenes-laboratorio";

    public static final String URI_API_V1_TIPENFPER=URI_API_V1+"tipo-enfermedad-personal";

    public static final String URI_API_V1_ANTGIN=URI_API_V1+"antecedentes-ginecologicos";
    public static final String URI_API_V1_EXASEX=URI_API_V1+"examen-sexual";
    public static final String URI_API_V1_PLAFAM=URI_API_V1+"planificacion-familiar";
}

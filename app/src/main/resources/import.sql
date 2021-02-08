-- /*PARENTESCO */

INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Padre', 'CONSANGUINIDAD');
INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Madre', 'CONSANGUINIDAD');
INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Hijo/a', 'CONSANGUINIDAD');
INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Abuelo/a materna', 'CONSANGUINIDAD');
INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Abuelo/a paterno', 'CONSANGUINIDAD');
INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Tío/a materna', 'CONSANGUINIDAD');
INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Tío/a paterno', 'CONSANGUINIDAD');
INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Conyugue', 'AFINIDAD');
INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Amigo/a', 'AFINIDAD');
INSERT INTO MZSTCPAR(MZSTCPAR_NOMBRE, MZSTCPAR_TIPO) VALUES('Otro', 'CONSANGUINIDAD');

-- /*TIPO ENFERMEDAD PERSONAL*/

INSERT INTO MZSTCTIPENFPER(MZSTCTIPENFPER_NOMBRE) VALUES('Alergias');
INSERT INTO MZSTCTIPENFPER(MZSTCTIPENFPER_NOMBRE) VALUES('Piel y anexos');
INSERT INTO MZSTCTIPENFPER(MZSTCTIPENFPER_NOMBRE) VALUES('Órganos de los sentidos');
INSERT INTO MZSTCTIPENFPER(MZSTCTIPENFPER_NOMBRE) VALUES('Respiratorio');
INSERT INTO MZSTCTIPENFPER(MZSTCTIPENFPER_NOMBRE) VALUES('Digestivo');
INSERT INTO MZSTCTIPENFPER(MZSTCTIPENFPER_NOMBRE) VALUES('Genito - urinario y aparato reproductor');
INSERT INTO MZSTCTIPENFPER(MZSTCTIPENFPER_NOMBRE) VALUES('Músculo esquelético');

-- /* EXAMEN DE LABORATORIO */

INSERT INTO MZSTCEXALAB(MZSTCEXALAB_CODIGO, MZSTCEXALAB_NOMBRE) VALUES(1,'Hematología');
INSERT INTO MZSTCEXALAB(MZSTCEXALAB_CODIGO, MZSTCEXALAB_NOMBRE) VALUES(2,'Química sanguínea');
INSERT INTO MZSTCEXALAB(MZSTCEXALAB_CODIGO, MZSTCEXALAB_NOMBRE) VALUES(3,'Serología y coagulación');
INSERT INTO MZSTCEXALAB(MZSTCEXALAB_CODIGO, MZSTCEXALAB_NOMBRE) VALUES(4,'Marcadores tumorales');
INSERT INTO MZSTCEXALAB(MZSTCEXALAB_CODIGO, MZSTCEXALAB_NOMBRE) VALUES(5,'Uroanálisis');
INSERT INTO MZSTCEXALAB(MZSTCEXALAB_CODIGO, MZSTCEXALAB_NOMBRE) VALUES(6,'Coprología');
INSERT INTO MZSTCEXALAB(MZSTCEXALAB_CODIGO, MZSTCEXALAB_NOMBRE) VALUES(7,'Otros');

-- /* DETALLE EXAMEN DE LABORATORIO */
-- HEMATOLOGÍA

INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Neutrófilos','%',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Eosinófilos','%',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Linfocitos','%',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Leucocitos','k/ul',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Monocitos','%',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Basófilos','%',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Hematíes','m/ul',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Hemoglobina','g/dl',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('VCM','fl',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Hematocrito','%',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('HCM','pg',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('CHCM','g/dl',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('RDW','%',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('Plaquetas','x1000/mm3',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('T. Protombina','seg',1);
INSERT INTO MZSTCDETEXALAB(MZSTCDETEXALAB_NOMBRE, MZSTCDETEXALAB_UNIDAD, id_examen_laboratorio) VALUES('T. Promboplastina','seg',1);
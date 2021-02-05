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


/*ASOSIACIONES*/
INSERT INTO MZSTCASO(MZSTCASO_NOMBRE) VALUES('Ninguna');
INSERT INTO MZSTCASO(MZSTCASO_NOMBRE) VALUES('Asociacion de servidores públicos');
INSERT INTO MZSTCASO(MZSTCASO_NOMBRE) VALUES('Asociacion de docentes');
INSERT INTO MZSTCASO(MZSTCASO_NOMBRE) VALUES('Asociacion 5 de julio');

/*SEGURO SALUD*/
INSERT INTO MZSTCSEGSAL(MZSTCSEGSAL_NOMBRE) VALUES('No aporta');
INSERT INTO MZSTCSEGSAL(MZSTCSEGSAL_NOMBRE) VALUES('Seguro privado');
INSERT INTO MZSTCSEGSAL(MZSTCSEGSAL_NOMBRE) VALUES('Jubilado del IESS/SSC/ISSFA/ISSPOL');
INSERT INTO MZSTCSEGSAL(MZSTCSEGSAL_NOMBRE) VALUES('IESS-Seguro campesino');
INSERT INTO MZSTCSEGSAL(MZSTCSEGSAL_NOMBRE) VALUES('IESS-Seguro voluntario');
INSERT INTO MZSTCSEGSAL(MZSTCSEGSAL_NOMBRE) VALUES('IESS-Seguro general');
INSERT INTO MZSTCSEGSAL(MZSTCSEGSAL_NOMBRE) VALUES('IESS-ISSPOL');
INSERT INTO MZSTCSEGSAL(MZSTCSEGSAL_NOMBRE) VALUES('IESS-ISSFA');

-- /* TIPOS DE CERTIFICADO */
INSERT INTO MZSTCTIPCER(MZSTCTIPCER_NOMBRE) VALUES('CERTIFICADO1');
INSERT INTO MZSTCTIPCER(MZSTCTIPCER_NOMBRE) VALUES('CERTIFICADO2');
INSERT INTO MZSTCTIPCER(MZSTCTIPCER_NOMBRE) VALUES('CERTIFICADO3');

-- /*RIESGOS*/
--- /*RIESGOS QUIMICOS*/
INSERT INTO MZSTCRIEBIO(MZSTCRIEBIO_NOMBRE) VALUES ('Virus');
INSERT INTO MZSTCRIEBIO(MZSTCRIEBIO_NOMBRE) VALUES ('Hongos');
INSERT INTO MZSTCRIEBIO(MZSTCRIEBIO_NOMBRE) VALUES ('Bacterias');
INSERT INTO MZSTCRIEBIO(MZSTCRIEBIO_NOMBRE) VALUES ('Parásitos');
INSERT INTO MZSTCRIEBIO(MZSTCRIEBIO_NOMBRE) VALUES ('Exposiciones a bacterias');
INSERT INTO MZSTCRIEBIO(MZSTCRIEBIO_NOMBRE) VALUES ('Exposiciones a animales selváticos');
INSERT INTO MZSTCRIEBIO(MZSTCRIEBIO_NOMBRE) VALUES ('Otros');

--- /*RIESGOS ERGONÓMICOS*/
INSERT INTO MZSTCRIEERG(MZSTCRIEERG_NOMBRE) VALUES ('Manejo manual de cajas');
INSERT INTO MZSTCRIEERG(MZSTCRIEERG_NOMBRE) VALUES ('Movimientos repititivos');
INSERT INTO MZSTCRIEERG(MZSTCRIEERG_NOMBRE) VALUES ('Posturas forzadas');
INSERT INTO MZSTCRIEERG(MZSTCRIEERG_NOMBRE) VALUES ('Trabajos con PVD');
INSERT INTO MZSTCRIEERG(MZSTCRIEERG_NOMBRE) VALUES ('Otros');

--- /*RIESGOS FÍSICOS*/
INSERT INTO MZSTCRIEFIS(MZSTCRIEFIS_NOMBRE) VALUES ('Temperaturas altas');
INSERT INTO MZSTCRIEFIS(MZSTCRIEFIS_NOMBRE) VALUES ('Temperaturas bajas');
INSERT INTO MZSTCRIEFIS(MZSTCRIEFIS_NOMBRE) VALUES ('Radiación ionizante');
INSERT INTO MZSTCRIEFIS(MZSTCRIEFIS_NOMBRE) VALUES ('Ruido');
INSERT INTO MZSTCRIEFIS(MZSTCRIEFIS_NOMBRE) VALUES ('Vibración');
INSERT INTO MZSTCRIEFIS(MZSTCRIEFIS_NOMBRE) VALUES ('Iluminación');
INSERT INTO MZSTCRIEFIS(MZSTCRIEFIS_NOMBRE) VALUES ('Ventilación');
INSERT INTO MZSTCRIEFIS(MZSTCRIEFIS_NOMBRE) VALUES ('Fluído eléctrico');
INSERT INTO MZSTCRIEFIS(MZSTCRIEFIS_NOMBRE) VALUES ('Otros');

--- /*RIESGOS MECÁNICOS*/
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Atrapamiento en máquinas');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Atrapamiento en superficies');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Atrapamiento en objetos');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Atropellamiento por vehículos');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Caídas al mismo nivel');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Caídas de diferente nivel');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Choque vehicular');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Contacto eléctrico');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Contacto superficie de trabajo');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Contacto eléctrico');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Cortes');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Otros');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Proyección de partículas');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Proyección de fluídos');
INSERT INTO MZSTCRIEMEC(MZSTCRIEMEC_NOMBRE) VALUES ('Pinchazos');

--- /*RIESGOS PSICOSOCIALES*/
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Monotonía en el trabajo');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Sobrecarga laboral');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Minusiocidad en las tareas');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Responsabilidad');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Autonomía en la toma de desiciones');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Supervición deficiente de estilos');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Conflicto de roles');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Falta de claridad en las funciones');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Incorrecta distribución del trabajo');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Turnos rotativas');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Relaciones interpersonales');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Inestibilidad laboral');
INSERT INTO MZSTCRIEPSI(MZSTCRIEPSI_NOMBRE) VALUES ('Otros');

--- /*RIESGOS QUÍMICOS*/
INSERT INTO MZSTCRIEQUI(MZSTCRIEQUI_NOMBRE) VALUES ('Sólidos');
INSERT INTO MZSTCRIEQUI(MZSTCRIEQUI_NOMBRE) VALUES ('Polvos');
INSERT INTO MZSTCRIEQUI(MZSTCRIEQUI_NOMBRE) VALUES ('Humos');
INSERT INTO MZSTCRIEQUI(MZSTCRIEQUI_NOMBRE) VALUES ('Líquidos');
INSERT INTO MZSTCRIEQUI(MZSTCRIEQUI_NOMBRE) VALUES ('Vapores');
INSERT INTO MZSTCRIEQUI(MZSTCRIEQUI_NOMBRE) VALUES ('Aerosoles');
INSERT INTO MZSTCRIEQUI(MZSTCRIEQUI_NOMBRE) VALUES ('Neblinas');
INSERT INTO MZSTCRIEQUI(MZSTCRIEQUI_NOMBRE) VALUES ('Gaseoso');
INSERT INTO MZSTCRIEQUI(MZSTCRIEQUI_NOMBRE) VALUES ('Otros');


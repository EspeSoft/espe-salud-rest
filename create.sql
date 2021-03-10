
    create table salud.mzstactenf (
       mzstactenf_codigo  bigserial not null,
        mzstactenf_descripcion varchar(255),
        mzstactenf_fecha timestamp,
        mzstactenf_fecha_creacion date,
        mzstactenf_fecha_modificacion date,
        fk_tipactenf_actenf int8,
        fk_usu_actenf int8,
        mzstactenf_usuario_creacion varchar(255),
        mzstactenf_usuario_modificacion varchar(255),
        primary key (mzstactenf_codigo)
    );

    create table salud.mzstactext (
       mzstactext_codigo  bigserial not null,
        mzstdettra_actividad varchar(255),
        mzstdettra_empresa varchar(255),
        mzstdettra_meses float4,
        mzstdettra_observacion varchar(255),
        mzstdettra_puesto_trabajo varchar(255),
        mzstdettra_riesgo varchar(255),
        mzstdettra_usaban_seguridad boolean,
        mzstdettra_vigilancia_salud boolean,
        mzstactext_fecha_creacion timestamp,
        mzstactext_fecha_modificacion timestamp,
        fk_antlab_actext int8,
        mzstactext_usuario_creacion varchar(255),
        mzstactext_usuario_modificacion varchar(255),
        primary key (mzstactext_codigo)
    );

    create table salud.mzstactfis (
       mzstactfis_codigo  bigserial not null,
        mzstactfis_fecha_creacion timestamp,
        mzstactfis_fecha_modificacion timestamp,
        mzstactfis_frecuencia varchar(255),
        fk_antper_actfis int8,
        mzstactfis_nombre_actividad varchar(255),
        mzstactfis_observacion varchar(255),
        mzstactfis_horas int4,
        mzstactfis_usuario_creacion varchar(255),
        mzstactfis_usuario_modificacion varchar(255),
        primary key (mzstactfis_codigo)
    );

    create table salud.mzstant (
       mzstant_codigo  bigserial not null,
        mzstant_fecha_creacion timestamp,
        mzstant_fecha_modificacion timestamp,
        mzstant_indice_masa_corporal float8,
        mzstant_perimetro_abdominal float8,
        mzstant_peso float8,
        mzstant_talla float8,
        mzstant_usuario_creacion varchar(255),
        mzstant_usuario_modificacion varchar(255),
        primary key (mzstant_codigo)
    );

    create table salud.mzstantacctra (
       mzstantacctra_codigo  bigserial not null,
        mzstanttra_empresa varchar(255),
        mzstanttra_fecha date,
        mzstanttra_horas_reposo float4,
        mzstanttra_observaciones varchar(255),
        mzstanttra_recibio_atencion boolean,
        mzstanttra_riesgo_implicado varchar(255),
        mzstanttra_secuelas varchar(255),
        mzstdetant_lugar_atencion varchar(255),
        mzstdetant_naturaleza varchar(255),
        mzstdetant_parte_cuerpo_afectada varchar(255),
        mzstantacctra_fecha_creacion timestamp,
        mzstantacctra_fecha_modificacion timestamp,
        fk_antlab_antacctra int8,
        mzstantacctra_usuario_creacion varchar(255),
        mzstantacctra_usuario_modificacion varchar(255),
        primary key (mzstantacctra_codigo)
    );

    create table salud.mzstantempant (
       mzstantempant_codigo  bigserial not null,
        mzstdettra_actividad varchar(255),
        mzstdettra_empresa varchar(255),
        mzstdettra_meses float4,
        mzstdettra_observacion varchar(255),
        mzstdettra_puesto_trabajo varchar(255),
        mzstdettra_riesgo varchar(255),
        mzstdettra_usaban_seguridad boolean,
        mzstdettra_vigilancia_salud boolean,
        mzstantempant_fecha_creacion timestamp,
        mzstantempant_fecha_modificacion timestamp,
        fk_antlab_antempant int8,
        mzstantempant_usuario_creacion varchar(255),
        mzstantempant_usuario_modificacion varchar(255),
        primary key (mzstantempant_codigo)
    );

    create table salud.mzstantenfpro (
       mzstantenfpro_codigo  bigserial not null,
        mzstanttra_empresa varchar(255),
        mzstanttra_fecha date,
        mzstanttra_horas_reposo float4,
        mzstanttra_observaciones varchar(255),
        mzstanttra_recibio_atencion boolean,
        mzstanttra_riesgo_implicado varchar(255),
        mzstanttra_secuelas varchar(255),
        mzstantenfpro_diagnostico varchar(255),
        mzstantenfpro_fecha_creacion timestamp,
        mzstantenfpro_fecha_modificacion timestamp,
        fk_antlab_antenfpro int8,
        mzstantenfpro_usuario_creacion varchar(255),
        mzstantenfpro_usuario_modificacion varchar(255),
        primary key (mzstantenfpro_codigo)
    );

    create table salud.mzstantgin (
       mzstantgin_codigo  bigserial not null,
        mzstantgin_ciclo_menstruacion varchar(255),
        mzstantgin_edad_menarquia int4,
        mzstantgin_fecha date,
        mzstantgin_fecha_creacion timestamp,
        mzstantgin_fecha_modificacion timestamp,
        mzstantgin_fecha_ultima_menstruacion date,
        mzstantgin_gestas int4,
        mzstantgin_hijos_muertos int4,
        mzstantgin_hijos_vivos int4,
        fk_antper_antgin int8,
        mzstantgin_numero_abortos int4,
        mzstantgin_numero_cesareas int4,
        mzstantgin_numero_partos_vaginales int4,
        mzstantgin_usuario_creacion varchar(255),
        mzstantgin_usuario_modificacion varchar(255),
        primary key (mzstantgin_codigo)
    );

    create table salud.mzstantinctra (
       mzstantinctra_codigo  bigserial not null,
        mzstanttra_empresa varchar(255),
        mzstanttra_fecha date,
        mzstanttra_horas_reposo float4,
        mzstanttra_observaciones varchar(255),
        mzstanttra_recibio_atencion boolean,
        mzstanttra_riesgo_implicado varchar(255),
        mzstanttra_secuelas varchar(255),
        mzstdetant_lugar_atencion varchar(255),
        mzstdetant_naturaleza varchar(255),
        mzstdetant_parte_cuerpo_afectada varchar(255),
        mzstantinctra_fecha_creacion timestamp,
        mzstantinctra_fecha_modificacion timestamp,
        fk_antlab_antinctra int8,
        mzstantinctra_usuario_creacion varchar(255),
        mzstantinctra_usuario_modificacion varchar(255),
        primary key (mzstantinctra_codigo)
    );

    create table salud.mzstantlab (
       mzstantlab_codigo  bigserial not null,
        mzstantlab_fecha_creacion timestamp,
        mzstantlab_fecha_modificacion timestamp,
        fk_pac_antlab int8,
        fk_usu_antlab int8,
        mzstantlab_usuario_creacion varchar(255),
        mzstantlab_usuario_modificacion varchar(255),
        primary key (mzstantlab_codigo)
    );

    create table salud.mzstantpatfam (
       mzstantpatfam_codigo  bigserial not null,
        mzstantpatfam_fecha_creacion timestamp,
        mzstantpatfam_fecha_modificacion timestamp,
        fk_antper_antpatfam int8,
        fk_enfcie10_antpatfam varchar(255),
        fk_tipenf_antpatfam int8,
        mzstantpatfam_observacion TEXT,
        mzstantpatfam_parentesco varchar(255),
        mzstantpatfam_usuario_creacion varchar(255),
        mzstantpatfam_usuario_modificacion varchar(255),
        primary key (mzstantpatfam_codigo)
    );

    create table salud.mzstantpatper (
       mzstantpatper_codigo  bigserial not null,
        mzstantpatper_fecha_creacion timestamp,
        mzstantpatper_fecha_diagnostico date,
        mzstantpatper_fecha_modificacion timestamp,
        mzstantpatper_frecuencia_medicacion varchar(255),
        fk_antper_antpatper int8,
        fk_enfcie10_antpatper varchar(255),
        fk_tipenfper_antpatper int8,
        mzstantpatper_observaciones varchar(255),
        mzstantpatper_usuario_creacion varchar(255),
        mzstantpatper_usuario_modificacion varchar(255),
        primary key (mzstantpatper_codigo)
    );

    create table salud.mzstantper (
       mzstantper_codigo  bigserial not null,
        mzstantper_descripcion_alergia varchar(255),
        mzstantper_fecha_creacion timestamp,
        mzstantper_fecha_modificacion timestamp,
        mzstantper_frecuencia_alimentacion varchar(255),
        mzstantper_hora_despertar varchar(255),
        mzstantper_hora_suenio varchar(255),
        fk_pac_antper int8,
        mzstantper_identidad_genero varchar(255),
        mzstantper_observacion_alimentacion varchar(255),
        mzstantper_observacion_habito_suenio varchar(255),
        mzstantper_orientacion_sexual varchar(255),
        mzstantper_posee_alergia varchar(255),
        mzstantper_predominio_alimentario varchar(255),
        mzstantper_usuario_creacion varchar(255),
        mzstantper_usuario_modificacion varchar(255),
        primary key (mzstantper_codigo)
    );

    create table salud.mzstantqui (
       mzstantqui_codigo  bigserial not null,
        mzstantqui_fecha_creacion timestamp,
        mzstantqui_fecha_modificacion timestamp,
        mzstantqui_fecha_procedimiento date,
        fk_antper_antqui int8,
        fk_enfcie10_antqui varchar(255),
        mzstantqui_procedimiento_quirurgico varchar(255),
        mzstantqui_secuelas varchar(255),
        mzstantqui_usuario_creacion varchar(255),
        mzstantqui_usuario_modificacion varchar(255),
        primary key (mzstantqui_codigo)
    );

    create table salud.mzstcare (
       mzstcare_codigo  bigserial not null,
        fk_reg_are int8,
        mzstcare_nombre varchar(255),
        primary key (mzstcare_codigo)
    );

    create table salud.mzstcaresal (
       mzstcaresal_codigo  bigserial not null,
        mzstcaresal_nombre varchar(255),
        primary key (mzstcaresal_codigo)
    );

    create table salud.mzstcaso (
       mzstcaso_codigo  bigserial not null,
        mzstcaso_nombre varchar(255),
        primary key (mzstcaso_codigo)
    );

    create table salud.mzstccodciuo (
       mzstccodciuo_codigo varchar(255) not null,
        mzstccodciuo_descripcion varchar(255),
        mzstccodciuo_nivel varchar(255),
        primary key (mzstccodciuo_codigo)
    );

    create table salud.mzstcdesactenf (
       mzstcdesactenf_codigo  bigserial not null,
        mzstcdesactenf_nombre varchar(255),
        fk_tipactenf_desactenf int8,
        primary key (mzstcdesactenf_codigo)
    );

    create table salud.mzstcdis (
       mzstcdis_codigo  bigserial not null,
        mzstcdis_campus varchar(255),
        mzstcdis_canton varchar(255),
        mzstcdis_direccion varchar(255),
        mzstcdis_fax varchar(255),
        mzstcdis_institucion_sistema varchar(255),
        mzstcdis_nombre_imagen varchar(255),
        mzstcdis_provincia varchar(255),
        mzstcdis_telefono varchar(255),
        mzstcdis_uni_codigo varchar(255),
        mzstcdis_unidad_operativa varchar(255),
        primary key (mzstcdis_codigo)
    );

    create table salud.mzstcenfcie10 (
       mzstcenfcie10_codigo varchar(255) not null,
        fk_gruenf_enfcie10 varchar(255),
        mzstcenfcie10_nombre varchar(255),
        primary key (mzstcenfcie10_codigo)
    );

    create table salud.mzstcer (
       mzstcer_codigo  bigserial not null,
        mzstcer_diagnostico_cie10 varchar(255),
        mzstcer_dias_reposo int4 not null,
        mzstcer_equivalente_horas_laborables int4 not null,
        mzstcer_fecha_creacion timestamp,
        mzstcer_fecha_desde timestamp,
        mzstcer_fecha_hasta timestamp,
        mzstcer_fecha_modificacion timestamp,
        mzstcer_fecha_registro timestamp,
        fk_evo_cer varchar(255),
        fk_tipcer_cer int8,
        mzstcer_institucion_emite varchar(255),
        mzstcer_usuario_creacion varchar(255),
        mzstcer_usuario_modificacion varchar(255),
        primary key (mzstcer_codigo)
    );

    create table salud.mzstcfreali (
       mzstcfreali_codigo  bigserial not null,
        mzstcfreali_nombre varchar(255),
        primary key (mzstcfreali_codigo)
    );

    create table salud.mzstcfremedhab (
       mzstcfremedhab_codigo  bigserial not null,
        mzstcfremedhab_nombre varchar(255),
        primary key (mzstcfremedhab_codigo)
    );

    create table salud.mzstcgruenf (
       mzstcgruenf_codigo varchar(255) not null,
        mzstcgruenf_nombre varchar(255),
        primary key (mzstcgruenf_codigo)
    );

    create table salud.mzstcidegen (
       mzstcidegen_codigo  bigserial not null,
        mzstcidegen_nombre varchar(255),
        primary key (mzstcidegen_codigo)
    );

    create table salud.mzstcmotate (
       mzstcmotate_codigo  bigserial not null,
        mzstcmotate_nombre varchar(255),
        primary key (mzstcmotate_codigo)
    );

    create table salud.mzstcnecsoc (
       mzstcnecsoc_codigo  bigserial not null,
        mzstcnecsoc_nombre varchar(255),
        primary key (mzstcnecsoc_codigo)
    );

    create table salud.mzstcnivins (
       mzstcnivins_codigo  bigserial not null,
        mzstcnivins_nombre varchar(255),
        primary key (mzstcnivins_codigo)
    );

    create table salud.mzstconeme (
       mzstcodeme_codigo  bigserial not null,
        mzstconeme_direccion varchar(255),
        mzstconeme_fecha_creacion timestamp,
        mzstconeme_fecha_modificacion timestamp,
        mzstconeme_nombre_contacto varchar(255),
        mzstconeme_parentesco varchar(255),
        mzstconeme_telefono_celular varchar(255),
        mzstconeme_telefono_convencional varchar(255),
        mzstconeme_usuario_creacion varchar(255),
        mzstconeme_usuario_modificacion varchar(255),
        fk_per_coneme int8,
        primary key (mzstcodeme_codigo)
    );

    create table salud.mzstconnoc (
       mzstconnoc_codigo  bigserial not null,
        mzstconnoc_cantidad_consumo varchar(255),
        mzstconnoc_fecha_creacion timestamp,
        mzstconnoc_fecha_modificacion timestamp,
        mzstconnoc_fecha_registro date,
        mzstconnoc_fecha_tentativa_inicio date,
        mzstconnoc_frecuencia_consumo varchar(255),
        fk_antper_connoc int8,
        mzstconnoc_observacion varchar(255),
        mzstconnoc_tiempo_abstinencia_mes int4,
        mzstconnoc_tiempo_consumo_mes int4,
        mzstconnoc_tipo_consumidor varchar(255),
        mzstconnoc_usuario_creacion varchar(255),
        mzstconnoc_usuario_modificacion varchar(255),
        fk_tipconnoc_connoc int8,
        primary key (mzstconnoc_codigo)
    );

    create table salud.mzstcorgsis (
       mzstcorgsis_codigo  bigserial not null,
        mzstcorgsis_fecha_creacion timestamp,
        mzstcorgsis_fecha_modificacion timestamp,
        mzstcorgsis_nombre varchar(255),
        mzstcorgsis_usuario_creacion varchar(255),
        mzstcorgsis_usuario_modificacion varchar(255),
        primary key (mzstcorgsis_codigo)
    );

    create table salud.mzstcorisex (
       mzstcorisex_codigo  bigserial not null,
        mzstcorisex_nombre varchar(255),
        primary key (mzstcorisex_codigo)
    );

    create table salud.mzstcpar (
       mzstcpar_codigo  bigserial not null,
        mzstcpar_nombre varchar(255),
        mzstcpar_tipo varchar(255),
        primary key (mzstcpar_codigo)
    );

    create table salud.mzstcplu (
       mzstcplu_codigo  bigserial not null,
        mzstcplu_nombre varchar(255),
        primary key (mzstcplu_codigo)
    );

    create table salud.mzstcprosoc (
       mzstcprosoc_codigo  bigserial not null,
        mzstcprosoc_nombre varchar(255),
        primary key (mzstcprosoc_codigo)
    );

    create table salud.mzstcreg (
       mzstcreg_codigo  bigserial not null,
        mzstcreg_nombre varchar(255),
        primary key (mzstcreg_codigo)
    );

    create table salud.mzstcrelesp (
       mzstcrelesp_codigo  bigserial not null,
        mzstcrelesp_nombre varchar(255),
        primary key (mzstcrelesp_codigo)
    );

    create table salud.mzstcrepmed (
       mzstcrepmed_codigo  bigserial not null,
        mzstcrepmed_nombre varchar(255),
        primary key (mzstcrepmed_codigo)
    );

    create table salud.mzstcriebio (
       mzstcriebio_codigo  bigserial not null,
        mzstcriebio_nombre varchar(255),
        primary key (mzstcriebio_codigo)
    );

    create table salud.mzstcrieerg (
       mzstcrieerg_codigo  bigserial not null,
        mzstcrieerg_nombre varchar(255),
        primary key (mzstcrieerg_codigo)
    );

    create table salud.mzstcriefis (
       mzstcriefis_codigo  bigserial not null,
        mzstcriefis_nombre varchar(255),
        primary key (mzstcriefis_codigo)
    );

    create table salud.mzstcriemec (
       mzstcriemec_codigo  bigserial not null,
        mzstcriemec_nombre varchar(255),
        primary key (mzstcriemec_codigo)
    );

    create table salud.mzstcriepsi (
       mzstcriepsi_codigo  bigserial not null,
        mzstcriepsi_nombre varchar(255),
        primary key (mzstcriepsi_codigo)
    );

    create table salud.mzstcriequi (
       mzstcriequi_codigo  bigserial not null,
        mzstcriequi_nombre varchar(255),
        primary key (mzstcriequi_codigo)
    );

    create table salud.mzstcsegsal (
       mzstcsegsal_codigo  bigserial not null,
        mzstcsegsal_nombre varchar(255),
        primary key (mzstcsegsal_codigo)
    );

    create table salud.mzstctipactenf (
       mzstctipactenf_codigo  bigserial not null,
        mzstctipactenf_nombre varchar(255),
        primary key (mzstctipactenf_codigo)
    );

    create table salud.mzstctipcer (
       mzstctipcer_codigo  bigserial not null,
        mzstctipcer_nombre varchar(255),
        primary key (mzstctipcer_codigo)
    );

    create table salud.mzstctipconnoc (
       mzstctipconnoc_codigo  bigserial not null,
        mzstctipconnoc_nombre varchar(255),
        primary key (mzstctipconnoc_codigo)
    );

    create table salud.mzstctipdetexalab (
       mzstctipdetexalab_codigo  bigserial not null,
        fk_tipexalab_detexlab int8,
        mzstctipdetexalab_nombre varchar(255),
        mzstctipdetexalab_unidad varchar(255),
        primary key (mzstctipdetexalab_codigo)
    );

    create table salud.mzstctipdis (
       mzstctipdis_codigo  bigserial not null,
        mzstctipdis_nombre varchar(255),
        primary key (mzstctipdis_codigo)
    );

    create table salud.mzstctipegr (
       mzstctipegr_codigo  bigserial not null,
        mzstctipegr_nombre varchar(255),
        primary key (mzstctipegr_codigo)
    );

    create table salud.mzstctipenf (
       mzstctipenf_codigo  bigserial not null,
        mzstctipenf_nombre varchar(255),
        primary key (mzstctipenf_codigo)
    );

    create table salud.mzstctipenfper (
       mzstctipenfper_codigo  bigserial not null,
        mzstctipenfper_nombre varchar(255),
        primary key (mzstctipenfper_codigo)
    );

    create table salud.mzstctipestcom (
       mzstctipestcom_codigo  bigserial not null,
        mzstctipestcom_nombre varchar(255),
        primary key (mzstctipestcom_codigo)
    );

    create table salud.mzstctipexalab (
       mzstctipexalab_codigo  bigserial not null,
        mzstctipexalab_nombre varchar(255),
        primary key (mzstctipexalab_codigo)
    );

    create table salud.mzstctipexasex (
       mzstctipexasex_codigo  bigserial not null,
        mzstctipexasex_nombre varchar(255),
        mzstctipexasex_sexo varchar(255),
        primary key (mzstctipexasex_codigo)
    );

    create table salud.mzstctiping (
       mzstctiping_codigo  bigserial not null,
        mzstctiping_nombre varchar(255),
        primary key (mzstctiping_codigo)
    );

    create table salud.mzstctipplafam (
       mzstctipplafam_codigo  bigserial not null,
        mzstctipplafam_nombre varchar(255),
        mzstctipplafam_sexo varchar(255),
        primary key (mzstctipplafam_codigo)
    );

    create table salud.mzstctipproce (
       mzstctipproce_codigo  bigserial not null,
        mzstctipproce_nombre varchar(255),
        primary key (mzstctipproce_codigo)
    );

    create table salud.mzstdetodocom (
       mzstdetodo_codigo int8 not null,
        fk_hiscliodo_detodo int8,
        mzstdetodo_tipo varchar(30),
        mzstdetodogra_realizado boolean,
        primary key (mzstdetodo_codigo)
    );

    create table salud.mzstdetodocua (
       mzstdetodo_codigo int8 not null,
        fk_hiscliodo_detodo int8,
        mzstdetodo_tipo varchar(30),
        detodocua_nivel int4 check (detodocua_nivel<=4 AND detodocua_nivel>=1),
        detodocua_pieza int4,
        primary key (mzstdetodo_codigo)
    );

    create table salud.mzstdetodograsim (
       mzstdetodo_codigo int8 not null,
        fk_hiscliodo_detodo int8,
        mzstdetodo_tipo varchar(30),
        mzstdetodogra_realizado boolean,
        mzstdetodograsim_cara varchar(255),
        mzstdetodograsim_pieza int4,
        primary key (mzstdetodo_codigo)
    );

    create table salud.mzstdia (
       mzstdia_codigo  bigserial not null,
        fk_enfcie10_dia varchar(255),
        mzstdia_condicion__diagnostico varchar(255),
        mzstdia_fecha_creacion timestamp,
        mzstdia_fecha_modificacion timestamp,
        mzstdia_pmorbilidad varchar(255),
        mzstdia_prevencion varchar(255),
        mzstdia_usuario_creacion varchar(255),
        mzstdia_usuario_modificacion varchar(255),
        fk_evo_dia varchar(255),
        primary key (mzstdia_codigo)
    );

    create table salud.mzstdis (
       mzstdis_codigo  bigserial not null,
        mzstdis_fecha_creacion timestamp,
        mzstdis_fecha_modificacion timestamp,
        mzstdis_grado_discapacidad varchar(255),
        fk_antper_dis int8,
        fk_enfcie10_dis varchar(255),
        mzstdis_porcentaje_discapacidad varchar(255),
        mzstdis_tipo_colaborador varchar(255),
        mzstdis_tipo_discapacidad varchar(255),
        mzstdis_usuario_creacion varchar(255),
        mzstdis_usuario_modificacion varchar(255),
        primary key (mzstdis_codigo)
    );

    create table salud.mzstemp (
       mzstemp_codigo  bigserial not null,
        mzstemp_actividades_relevante varchar(255),
        mzstemp_area_trabajo varchar(255),
        mzstemp_cargo_trabajo_actual varchar(255),
        mzstemp_cumple_mision_servicio varchar(255),
        mzstemp_direccion_laboral varchar(255),
        mzstemp_fecha_creacion timestamp,
        mzstemp_fecha_ingreso_laboral date,
        mzstemp_fecha_modificacion timestamp,
        mzstemp_horas_trabajo_dia int4 not null,
        mzstemp_horas_trabajo_mes int4 not null,
        mzstemp_horas_trabajo_semana int4 not null,
        mzstemp_observacion_horario varchar(255),
        mzstemp_parroquia varchar(255),
        mzstemp_situacion_administrativa varchar(255),
        mzstemp_tipo_jornada_laboral varchar(255),
        mzstemp_unidad_departamento varchar(255),
        mzstemp_usuario_creacion varchar(255),
        mzstemp_usuario_modificacion varchar(255),
        fk_pac_emp int8,
        primary key (mzstemp_codigo)
    );

    create table salud.mzstenfproact (
       mzstenfproact_codigo  bigserial not null,
        mzstenfproact_codigo_cie varchar(12),
        mzstenfproact_descripcion varchar(255),
        fk_hiscliodo_enfproact int8,
        primary key (mzstenfproact_codigo)
    );

    create table salud.mzstest (
       fk_pac_est int8 not null,
        mzstest_actividades_relevantes varchar(255),
        mzstest_campus varchar(255),
        mzstest_carrera varchar(255),
        mzstest_departamento varchar(255),
        mzstest_direccion_lugar_estudio varchar(255),
        mzstest_escuela varchar(255),
        mzstest_fecha_creacion timestamp,
        mzstest_fecha_ingreso_espe date,
        mzstest_fecha_modificacion timestamp,
        mzstest_usuario_creacion varchar(255),
        mzstest_usuario_modificacion varchar(255),
        primary key (fk_pac_est)
    );

    create table salud.mzstestcom (
       mzstestcom_codigo  bigserial not null,
        mzstestcom_descripcion_estudio TEXT,
        mzstestcom_fecha_estudio date,
        fk_pac_estcom int8,
        fk_tipestcom_estcom int8,
        primary key (mzstestcom_codigo)
    );

    create table salud.mzstevo (
       mzstevo_codigo varchar(255) not null,
        mzstevo_es_enfermedad_ocupacional boolean,
        mzstevo_estado varchar(255),
        mzstevo_fecha_creacion timestamp,
        mzstevo_fecha_finalizacion timestamp,
        mzstevo_fecha_inicio timestamp,
        mzstevo_fecha_modificacion timestamp,
        fk_caresal_evo int8,
        fk_cdis_evo int8,
        fk_cmotiate_evo int8,
        fk_notenf int8,
        fk_pac_evo int8,
        mzstevo_motivo_consulta varchar(255),
        mzstevo_nota_evolucion TEXT,
        mzstevo_observacion varchar(255),
        fk_usu_evo int8,
        mzstevo_usuario_creacion varchar(255),
        mzstevo_usuario_modificacion varchar(255),
        primary key (mzstevo_codigo)
    );

    create table salud.mzstexaext (
       mzstexaext_codigo  bigserial not null,
        mzstexaext_descripcion TEXT,
        mzstexaext_fecha_creacion timestamp,
        mzstexaext_fecha_modificacion timestamp,
        mzstexaext_fecha_registro timestamp,
        fk_are_exaext int8,
        fk_pac_exaext int8,
        fk_reg_exaext int8,
        mzstexaext_usuario_creacion varchar(255),
        mzstexaext_usuario_modificacion varchar(255),
        primary key (mzstexaext_codigo)
    );

    create table salud.mzstexaint (
       mzstexaint_codigo  bigserial not null,
        mzstexaint_descripcion varchar(255),
        mzstexaint_fecha_creacion timestamp,
        mzstexaint_fecha_modificacion timestamp,
        mzstexaint_fecha_registro timestamp,
        fk_orgsis_exaint int8,
        fk_pac_exaint int8,
        mzstexaint_usuario_creacion varchar(255),
        mzstexaint_usuario_modificacion varchar(255),
        primary key (mzstexaint_codigo)
    );

    create table salud.mzstexasex (
       mzstexasex_codigo  bigserial not null,
        mzstexasex_fecha date,
        mzstexasex_fecha_creacion timestamp,
        mzstexasex_fecha_modificacion timestamp,
        fk_antper_exasex int8,
        fk_tipexasex_exasex int8,
        mzstexasex_resultado TEXT,
        mzstexasex_tiempo_anios int4,
        mzstexasex_usuario_creacion varchar(255),
        mzstexasex_usuario_modificacion varchar(255),
        primary key (mzstexasex_codigo)
    );

    create table salud.mzstexasisest (
       mzstexasisest_codigo  bigserial not null,
        mzstexasisest_codigo_cie_asociado varchar(12),
        fk_hiscliodo_exasisest int8,
        mzstexasisest_unidad_estomatognatica varchar(255),
        primary key (mzstexasisest_codigo)
    );

    create table salud.mzstfacriepueact (
       mzstfacriepueact_codigo  bigserial not null,
        mzstfacriepueact_actividad_puesto varchar(255),
        mzstfacriepueact_fecha_creacion timestamp,
        mzstfacriepueact_fecha_modificacion timestamp,
        fk_antlab_facriepueact int8,
        mzstfacriepueact_maquinaria varchar(255),
        mzstfacriepueact_medida_preventiva varchar(255),
        mzstfacriepueact_puesto_trabajo varchar(255),
        mzstfacriepueact_usuario_creacion varchar(255),
        mzstfacriepueact_usuario_modificacion varchar(255),
        primary key (mzstfacriepueact_codigo)
    );

    create table salud.mzsthiscliodo (
       mzsthiscliodo_codigo  bigserial not null,
        mzsthiscliodo_codigoprofesional varchar(20),
        mzsthiscliodo_fecha_apertura timestamp not null,
        mzsthiscliodo_fecha_control timestamp not null,
        fk_pac_hiscliodo int8,
        mzsthiscliodo_profesional varchar(50),
        primary key (mzsthiscliodo_codigo)
    );

    create table salud.mzsthos (
       mzsthos_codigo  bigserial not null,
        mzsthos_casa_salud varchar(255),
        mzsthos_diagnostico_egreso varchar(255),
        mzsthos_diagnostico_ingreso varchar(255),
        mzsthos_dias_incapacidad int4,
        mzsthos_especialidad_medico varchar(255),
        mzsthos_evolucion_procedimiento_complicaciones TEXT,
        mzsthos_fecha_alta date,
        mzsthos_fecha_creacion timestamp,
        mzsthos_fecha_ingreso date,
        mzsthos_fecha_modificacion timestamp,
        fk_pac_hos int8,
        mzsthos_indicaciones_alta varchar(255),
        mzsthos_medico_tratante varchar(255),
        mzsthos_tiempo_estadia varchar(255),
        mzsthos_tipo_egreso varchar(255),
        mzsthos_usuario_creacion varchar(255),
        mzsthos_usuario_modificacion varchar(255),
        primary key (mzsthos_codigo)
    );

    create table salud.mzstindsalbuc (
       mzstindsalbuc_codigo  bigserial not null,
        fk_hiscliodo_indsalbuc int8,
        mzstindsalbuc_nivel_enfermedad_periodontal int4 check (mzstindsalbuc_nivel_enfermedad_periodontal<=3 AND mzstindsalbuc_nivel_enfermedad_periodontal>=1),
        mzstindsalbuc_nivel_fluorosis int4 check (mzstindsalbuc_nivel_fluorosis<=3 AND mzstindsalbuc_nivel_fluorosis>=1),
        mzstindsalbuc_nivel_maloclusion int4 check (mzstindsalbuc_nivel_maloclusion<=3 AND mzstindsalbuc_nivel_maloclusion>=1),
        primary key (mzstindsalbuc_codigo)
    );

    create table salud.mzstmedhab (
       mzstmedhab_codigo  bigserial not null,
        mzstmedhab_cantidad int4,
        mzstmedhab_descripcion_medicamento varchar(255),
        mzstmedhab_fecha_creacion timestamp,
        mzstmedhab_fecha_modificacion timestamp,
        fk_antper_medhab int8,
        fk_fremedhab_medhab int8,
        mzstmedhab_observacion varchar(255),
        mzstmedhab_usuario_creacion varchar(255),
        mzstmedhab_usuario_modificacion varchar(255),
        primary key (mzstmedhab_codigo)
    );

    create table salud.mzstnotenf (
       mzstnotenf_codigo  bigserial not null,
        mzstnotenf_estado varchar(255),
        mzstnotenf_fecha_creacion timestamp,
        mzstnotenf_fecha_fin timestamp,
        mzstnotenf_fecha_inicio timestamp,
        mzstnotenf_fecha_modificacion timestamp,
        fk_caresal_notenf int8,
        fk_cdis_notenf int8,
        fk_pac_notenf int8,
        fk_usu_notenf int8,
        mzstnotenf_post_consulta TEXT,
        mzstnotenf_pre_consulta TEXT,
        mzstnotenf_usuario_creacion varchar(255),
        mzstnotenf_usuario_modificacion varchar(255),
        primary key (mzstnotenf_codigo)
    );

    create table salud.mzstpac (
       mzstpac_codigo  bigserial not null,
        mzstpac_acepta_transfucion boolean,
        mzstpac_asociacion_afiliada varchar(255),
        mzstpac_es_empleado boolean,
        mzstpac_es_estudiante boolean,
        mzstpac_fecha_creacion timestamp,
        mzstpac_fecha_modificacion timestamp,
        fk_cdis_pac int8,
        mzstpac_instruccion varchar(255),
        mzstpac_lateralidad varchar(255),
        mzstpac_nombre_completo varchar(255),
        mzstpac_numero_archivo varchar(255) not null,
        mzstpac_seguro_salud varchar(255),
        mzstpac_tipo_paciente varchar(255),
        mzstpac_usuario_creacion varchar(255),
        mzstpac_usuario_modificacion varchar(255),
        mzstpac_vinculado_espe varchar(255),
        primary key (mzstpac_codigo)
    );

    create table salud.mzstper (
       mzstper_codigo  bigserial not null,
        mzstper_apellido_materno varchar(255),
        mzstper_apellido_paterno varchar(255),
        mzstper_canton_nacimiento varchar(255) not null,
        mzstper_cedula varchar(255),
        mzstper_barrio varchar(255),
        mzstper_calle_principal varchar(255),
        mzstper_calle_secundaria varchar(255),
        mzstper_canton_residencia varchar(255),
        mzstper_correo_institucional varchar(255),
        mzstper_correo_personal varchar(255),
        mzstper_direccion_referencia varchar(255),
        mzstper_extension varchar(255),
        mzstper_id_canton_residencia varchar(255),
        mzstper_id_provincia_residencia int4,
        mzstper_numero_celular varchar(255),
        mzstper_numero_convencional varchar(255),
        mzstper_parroquia_residencia varchar(255),
        mzstper_provincia_residencia varchar(255),
        mzstper_zona_geografica varchar(255),
        mzstper_estado_civil varchar(255),
        mzstper_etnia varchar(255),
        mzstper_fecha_creacion timestamp,
        mzstper_fecha_modificacion timestamp,
        mzstper_fecha_nacimiento date,
        mzstper_grupo_sanguineo varchar(255),
        mzstper_id_canton_nacimiento varchar(255),
        mzstper_id_provincia_nacimiento int4,
        mzstper_instruccion varchar(255),
        mzstper_nacionalidad varchar(255) not null,
        mzstper_nacionalidad_2 varchar(255),
        mzstper_pais_nacimiento varchar(255) not null,
        mzstper_primer_nombre varchar(255),
        mzstper_profesion varchar(255),
        mzstper_provincia_nacimiento varchar(255) not null,
        mzstper_plurinacionalidad varchar(255),
        mzstper_religion varchar(255),
        mzstper_segundo_nombre varchar(255),
        mzstper_sexo varchar(255),
        mzstper_usuario_creacion varchar(255),
        mzstper_usuario_modificacion varchar(255),
        primary key (mzstper_codigo)
    );

    create table salud.mzstplafam (
       mzstplafam_codigo  bigserial not null,
        mzstplafam_edad_inicio_planificacion_familiar int4,
        mzstplafam_fecha date,
        mzstplafam_fecha_creacion timestamp,
        mzstplafam_fecha_modificacion timestamp,
        mzstplafam_frecuencia_planificacion_familiar varchar(255),
        mzstplafam_hijos_muertos int4,
        mzstplafam_hijos_vivos int4,
        fk_antper_plafam int8,
        fk_tipplafam_plafam int8,
        mzstplafam_metodo_planificacion boolean,
        mzstplafam_observacion varchar(255),
        mzstplafam_usuario_creacion varchar(255),
        mzstplafam_usuario_modificacion varchar(255),
        mzstplafam_vida_sexual_activa varchar(255),
        primary key (mzstplafam_codigo)
    );

    create table salud.mzstpres (
       mzstpres_codigo  bigserial not null,
        mzstpres_cantidad int4,
        mzstpres_dosis varchar(255),
        mzstpres_fecha_creacion timestamp,
        mzstpres_fecha_modificacion timestamp,
        mzstpres_inidicacion varchar(255),
        mzstpres_presentacion varchar(255),
        mzstpres_usuario_creacion varchar(255),
        mzstpres_usuario_modificacion varchar(255),
        fk_evo_pres varchar(255),
        fk_repmed_pres int8,
        primary key (mzstpres_codigo)
    );

    create table salud.mzstpro (
       mzstpro_codigo  bigserial not null,
        mzstpro_fecha_creacion timestamp,
        mzstpro_fecha_modificacion timestamp,
        fk_evo_proc varchar(255),
        fk_tipproc_proc int8,
        fk_usu_proc int8,
        mzstpro_nota TEXT,
        mzstpro_numero_actividad int4 not null,
        mzstpro_usuario_creacion varchar(255),
        mzstpro_usuario_modificacion varchar(255),
        primary key (mzstpro_codigo)
    );

    create table salud.mzstreclab (
       mzstreclab_codigo  bigserial not null,
        mzstreclab_causa varchar(50),
        mzstreclab_dias_entre_salido_ingreso int4,
        mzstreclab_edad int4,
        mzstreclab_fecha_creacion timestamp,
        mzstreclab_fecha_modificacion timestamp,
        mzstreclab_fecha_registro date not null,
        mzstreclab_fecha_reingreso date,
        mzstreclab_fecha_salida date,
        mzstreclab_usuario_creacion varchar(255),
        mzstreclab_usuario_modificacion varchar(255),
        primary key (mzstreclab_codigo)
    );

    create table salud.mzstsigvit (
       mzstsigvit_codigo  bigserial not null,
        mzstsigvit_fecha_creacion timestamp,
        mzstsigvit_fecha_modificacion timestamp,
        mzstsigvit_fecha_ultima_menstruacion date,
        mzstsigvit_frecuencia_cardiaca float8,
        mzstsigvit_frecuencia_respiratoria float8,
        mzstsigvit_presion_arterial int8,
        mzstsigvit_presion_arterial2 int8,
        mzstsigvit_saturacion_oxigeno float8,
        mzstsigvit_temperatura float8,
        mzstsigvit_usuario_creacion varchar(255),
        mzstsigvit_usuario_modificacion varchar(255),
        primary key (mzstsigvit_codigo)
    );

    create table salud.mzstusu (
       mzstusu_pidm int8 not null,
        mzstusu_activo boolean,
        mzstusu_cedula varchar(255),
        fk_aresal_usu int8,
        fk_cdis_usu int8,
        mzstusu_nombres varchar(255),
        primary key (mzstusu_pidm)
    );

    alter table salud.mzstpac 
       add constraint UK_pbloipxffm1x7rl61o8dql04c unique (mzstpac_numero_archivo);

    alter table salud.mzstper 
       add constraint UK_fitc4anv9pahe6h225ot9d9qu unique (mzstper_cedula);
create sequence evolucion_sequence start 1 increment 1;
create sequence hibernate_sequence start 1 increment 1;

    create table detodocompie (
       detalle_odontograma_compuesto_mzstdetodo_codigo int8 not null,
        detodocompiezas int4
    );

    create table mzstevo_ant (
       fk_notenf int8,
        fk_evo varchar(255) not null,
        primary key (fk_evo)
    );

    create table mzstpac_ant (
       fk_ant int8,
        fk_notenf int8 not null,
        primary key (fk_notenf)
    );

    create table mzstpac_per (
       fk_per int8,
        fk_pac int8 not null,
        primary key (fk_pac)
    );

    create table mzstpac_sigvit (
       fk_sigvit int8,
        fk_notenf int8 not null,
        primary key (fk_notenf)
    );

    create table mzstrel_riebio_facriepueact (
       fk_facriepueact int8 not null,
        fk_riebio int8 not null
    );

    create table mzstrel_rieerg_facriepueact (
       fk_facriepueact int8 not null,
        fk_rieerg int8 not null
    );

    create table mzstrel_riefis_facriepueact (
       fk_facriepueact int8 not null,
        fk_riefis int8 not null
    );

    create table mzstrel_riemec_facriepueact (
       fk_facriepueact int8 not null,
        fk_riemec int8 not null
    );

    create table mzstrel_riepsi_facriepueact (
       fk_facriepueact int8 not null,
        fk_riepsi int8 not null
    );

    create table mzstrel_riequi_facriepueact (
       fk_facriepueact int8 not null,
        fk_riequi int8 not null
    );

    alter table salud.mzstactenf 
       add constraint FKomeorbpc6sflgbo4yinblfdm5 
       foreign key (fk_tipactenf_actenf) 
       references salud.mzstctipactenf;

    alter table salud.mzstactenf 
       add constraint FK1n2f9548hf534qg95bry4b6mx 
       foreign key (fk_usu_actenf) 
       references salud.mzstusu;

    alter table salud.mzstactext 
       add constraint FKexhv9b324agu84kqw595vq8v3 
       foreign key (fk_antlab_actext) 
       references salud.mzstantlab;

    alter table salud.mzstactfis 
       add constraint FKapunkou377whvk2ltrxukji74 
       foreign key (fk_antper_actfis) 
       references salud.mzstantper;

    alter table salud.mzstantacctra 
       add constraint FKf3n50q71p3hxpu3s0kbjl47xm 
       foreign key (fk_antlab_antacctra) 
       references salud.mzstantlab;

    alter table salud.mzstantempant 
       add constraint FKtm55q2coo2lau1og5jqg5hka3 
       foreign key (fk_antlab_antempant) 
       references salud.mzstantlab;

    alter table salud.mzstantenfpro 
       add constraint FKmx1p067optq7y57ag3vwjh0vs 
       foreign key (fk_antlab_antenfpro) 
       references salud.mzstantlab;

    alter table salud.mzstantgin 
       add constraint FKehct9x9ib1oec22spbql958bf 
       foreign key (fk_antper_antgin) 
       references salud.mzstantper;

    alter table salud.mzstantinctra 
       add constraint FK2oj8gng3vaoewan1pgihe8d04 
       foreign key (fk_antlab_antinctra) 
       references salud.mzstantlab;

    alter table salud.mzstantlab 
       add constraint FKeam7gn9nkufeudj2sw7dvi8ub 
       foreign key (fk_pac_antlab) 
       references salud.mzstpac;

    alter table salud.mzstantlab 
       add constraint FKq4842g6usod90x7wp3q4j87uy 
       foreign key (fk_usu_antlab) 
       references salud.mzstusu;

    alter table salud.mzstantpatfam 
       add constraint FKcl4txv1lb874w27plwgad37ib 
       foreign key (fk_antper_antpatfam) 
       references salud.mzstantper;

    alter table salud.mzstantpatfam 
       add constraint FKo6p0evkos2kktn7l22vhlmtat 
       foreign key (fk_enfcie10_antpatfam) 
       references salud.mzstcenfcie10;

    alter table salud.mzstantpatfam 
       add constraint FKgbg7upd7mh0dfd2hohf47asls 
       foreign key (fk_tipenf_antpatfam) 
       references salud.mzstctipenf;

    alter table salud.mzstantpatper 
       add constraint FKikg57lbix5kit9w0f2itgw5fx 
       foreign key (fk_antper_antpatper) 
       references salud.mzstantper;

    alter table salud.mzstantpatper 
       add constraint FKksga8qevay7r99iy8wsnaf6sj 
       foreign key (fk_enfcie10_antpatper) 
       references salud.mzstcenfcie10;

    alter table salud.mzstantpatper 
       add constraint FKa3w8mvn4c5quhdnf6sm3j60h3 
       foreign key (fk_tipenfper_antpatper) 
       references salud.mzstctipenfper;

    alter table salud.mzstantper 
       add constraint FK29lka6w6dj785ma4hvlkbvw8 
       foreign key (fk_pac_antper) 
       references salud.mzstpac;

    alter table salud.mzstantqui 
       add constraint FK8fyibfepetpunhpgk9h43rprm 
       foreign key (fk_antper_antqui) 
       references salud.mzstantper;

    alter table salud.mzstantqui 
       add constraint FKof0o1u46jxjtcb5l9fbcljn0 
       foreign key (fk_enfcie10_antqui) 
       references salud.mzstcenfcie10;

    alter table salud.mzstcare 
       add constraint FKp5rp3larybfi5ana6e46oscde 
       foreign key (fk_reg_are) 
       references salud.mzstcreg;

    alter table salud.mzstcdesactenf 
       add constraint FKhxhqokgfaxlll1nxiusdurhvd 
       foreign key (fk_tipactenf_desactenf) 
       references salud.mzstctipactenf;

    alter table salud.mzstcenfcie10 
       add constraint FK7v1uo3w35xns03pbep65pwx43 
       foreign key (fk_gruenf_enfcie10) 
       references salud.mzstcgruenf;

    alter table salud.mzstcer 
       add constraint FKfmp9g0js9l7u5da1ua0yfkf5k 
       foreign key (fk_evo_cer) 
       references salud.mzstevo;

    alter table salud.mzstcer 
       add constraint FKhbbsy52kbmrnnera79qwq3c7t 
       foreign key (fk_tipcer_cer) 
       references salud.mzstctipcer;

    alter table salud.mzstconeme 
       add constraint FKmdq29lv71udy5faem5crhd4h4 
       foreign key (fk_per_coneme) 
       references salud.mzstper;

    alter table salud.mzstconnoc 
       add constraint FKmwh7lulgccjgknkkgu5u0aujy 
       foreign key (fk_antper_connoc) 
       references salud.mzstantper;

    alter table salud.mzstconnoc 
       add constraint FKkr9l9sq3k0447ibifmvoqtetf 
       foreign key (fk_tipconnoc_connoc) 
       references salud.mzstctipconnoc;

    alter table salud.mzstctipdetexalab 
       add constraint FKo0spylrpi9xibn429935tq0o7 
       foreign key (fk_tipexalab_detexlab) 
       references salud.mzstctipexalab;

    alter table salud.mzstdetodocom 
       add constraint FK_a5gff2hqkat01ljy0rvuvidqo 
       foreign key (fk_hiscliodo_detodo) 
       references salud.mzsthiscliodo;

    alter table salud.mzstdetodocua 
       add constraint FK_nvmp3pcdphslirwx7qemrnpom 
       foreign key (fk_hiscliodo_detodo) 
       references salud.mzsthiscliodo;

    alter table salud.mzstdetodograsim 
       add constraint FK_g4v8mqp4jrnl1h1er1q933qii 
       foreign key (fk_hiscliodo_detodo) 
       references salud.mzsthiscliodo;

    alter table salud.mzstdia 
       add constraint FK3xhup7678s7rj9w24axi3wl12 
       foreign key (fk_enfcie10_dia) 
       references salud.mzstcenfcie10;

    alter table salud.mzstdia 
       add constraint FKiv6fis3k09a3wq3gyfjc3xn9u 
       foreign key (fk_evo_dia) 
       references salud.mzstevo;

    alter table salud.mzstdis 
       add constraint FKj0csfswre7tkbp48lj5pbukvf 
       foreign key (fk_antper_dis) 
       references salud.mzstantper;

    alter table salud.mzstdis 
       add constraint FK4ge808eo6asm9v4h02oxv83qw 
       foreign key (fk_enfcie10_dis) 
       references salud.mzstcenfcie10;

    alter table salud.mzstemp 
       add constraint FKd41w75brlhwsvp41lot9d36qw 
       foreign key (fk_pac_emp) 
       references salud.mzstpac;

    alter table salud.mzstenfproact 
       add constraint FKo3ft1xs2leo4iypkf6t4wg0fd 
       foreign key (fk_hiscliodo_enfproact) 
       references salud.mzsthiscliodo;

    alter table salud.mzstest 
       add constraint FKn9vhompdsxok5hf8shnjuj4i5 
       foreign key (fk_pac_est) 
       references salud.mzstpac;

    alter table salud.mzstestcom 
       add constraint FK92pdq48nxbmhp9htwq5v58g5y 
       foreign key (fk_tipestcom_estcom) 
       references salud.mzstctipestcom;

    alter table salud.mzstestcom 
       add constraint FKk91972ai2e4fl9iw764xm6trb 
       foreign key (fk_pac_estcom) 
       references salud.mzstpac;

    alter table salud.mzstevo 
       add constraint FK3xmasj4aira7iq8lxbd25jh30 
       foreign key (fk_caresal_evo) 
       references salud.mzstcaresal;

    alter table salud.mzstevo 
       add constraint FKgso4urkvp209v13eds93su4k 
       foreign key (fk_cdis_evo) 
       references salud.mzstcdis;

    alter table salud.mzstevo 
       add constraint FK522ybnxj3uu4hgq6w6qp7qrx3 
       foreign key (fk_cmotiate_evo) 
       references salud.mzstcmotate;

    alter table salud.mzstevo 
       add constraint FK2xfjro04ifuu3wa7vawiolsc8 
       foreign key (fk_pac_evo) 
       references salud.mzstpac;

    alter table salud.mzstevo 
       add constraint FKp4plf8dnlvyng7a0qp96haye9 
       foreign key (fk_usu_evo) 
       references salud.mzstusu;

    alter table salud.mzstexaext 
       add constraint FKd402ww0o03nrpvv586thv0nlt 
       foreign key (fk_are_exaext) 
       references salud.mzstcare;

    alter table salud.mzstexaext 
       add constraint FKodg4l1plsrp53fxtpg3requ7l 
       foreign key (fk_pac_exaext) 
       references salud.mzstpac;

    alter table salud.mzstexaext 
       add constraint FKr1plvnc3x34syawaqrrfa8qy1 
       foreign key (fk_reg_exaext) 
       references salud.mzstcreg;

    alter table salud.mzstexaint 
       add constraint FKrxinr8wypof2f7kpdf7qqdbf5 
       foreign key (fk_orgsis_exaint) 
       references salud.mzstcorgsis;

    alter table salud.mzstexaint 
       add constraint FKd4ul8ht5jqyauojraw946k469 
       foreign key (fk_pac_exaint) 
       references salud.mzstpac;

    alter table salud.mzstexasex 
       add constraint FKr45rrlxp8a2vi2gfjgkpgj2jj 
       foreign key (fk_antper_exasex) 
       references salud.mzstantper;

    alter table salud.mzstexasex 
       add constraint FK3mvhmu7vkvap98n5rtyymlgkf 
       foreign key (fk_tipexasex_exasex) 
       references salud.mzstctipexasex;

    alter table salud.mzstexasisest 
       add constraint FKcw3do3d7y8u26c9v4l87k3wwl 
       foreign key (fk_hiscliodo_exasisest) 
       references salud.mzsthiscliodo;

    alter table salud.mzstfacriepueact 
       add constraint FKibbsgxrflphmmg72cjjbowcut 
       foreign key (fk_antlab_facriepueact) 
       references salud.mzstantlab;

    alter table salud.mzsthiscliodo 
       add constraint FKsablq73qlrato42ww69lor70w 
       foreign key (fk_pac_hiscliodo) 
       references salud.mzstpac;

    alter table salud.mzsthos 
       add constraint FK5nggbf1kp9a7lkxd97l7cysjq 
       foreign key (fk_pac_hos) 
       references salud.mzstpac;

    alter table salud.mzstindsalbuc 
       add constraint FKbyitciqoytn197rngnb4b6b4r 
       foreign key (fk_hiscliodo_indsalbuc) 
       references salud.mzsthiscliodo;

    alter table salud.mzstmedhab 
       add constraint FKee8xo1d026gglkma4lu53sl43 
       foreign key (fk_antper_medhab) 
       references salud.mzstantper;

    alter table salud.mzstmedhab 
       add constraint FKkndnpsk2ksg26v1k12a8vwqxp 
       foreign key (fk_fremedhab_medhab) 
       references salud.mzstcfremedhab;

    alter table salud.mzstnotenf 
       add constraint FKk19i86gi0f59afekvafx3v4wy 
       foreign key (fk_caresal_notenf) 
       references salud.mzstcaresal;

    alter table salud.mzstnotenf 
       add constraint FK9s3w0dmsb4i9y6pdf4hetm5oc 
       foreign key (fk_cdis_notenf) 
       references salud.mzstcdis;

    alter table salud.mzstnotenf 
       add constraint FKsanashgebt94j3f69o799jhim 
       foreign key (fk_pac_notenf) 
       references salud.mzstpac;

    alter table salud.mzstnotenf 
       add constraint FK9m3ob6l70axme2s21r447gyek 
       foreign key (fk_usu_notenf) 
       references salud.mzstusu;

    alter table salud.mzstpac 
       add constraint FKo1vlx4wtc254vv92jw8kgms4q 
       foreign key (fk_cdis_pac) 
       references salud.mzstcdis;

    alter table salud.mzstplafam 
       add constraint FK5u98laj8xwlppqrxg82qq3jwf 
       foreign key (fk_antper_plafam) 
       references salud.mzstantper;

    alter table salud.mzstplafam 
       add constraint FKaav7njsgu6wawgrfnndan54mn 
       foreign key (fk_tipplafam_plafam) 
       references salud.mzstctipplafam;

    alter table salud.mzstpres 
       add constraint FK8eqyoat022s4d29whu7yjhsjj 
       foreign key (fk_evo_pres) 
       references salud.mzstevo;

    alter table salud.mzstpres 
       add constraint FK9lym2or1tus41lflm9rvh844u 
       foreign key (fk_repmed_pres) 
       references salud.mzstcrepmed;

    alter table salud.mzstpro 
       add constraint FK2nwvahsg6wv9tk4p572tgk6xn 
       foreign key (fk_evo_proc) 
       references salud.mzstevo;

    alter table salud.mzstpro 
       add constraint FKk4leu5c5o0p5bagvhdjabppki 
       foreign key (fk_tipproc_proc) 
       references salud.mzstctipproce;

    alter table salud.mzstpro 
       add constraint FK3qr329sv79eu1ph304y17cg5r 
       foreign key (fk_usu_proc) 
       references salud.mzstusu;

    alter table salud.mzstusu 
       add constraint FK34i3j36yyyg62auwyvph0hn7v 
       foreign key (fk_aresal_usu) 
       references salud.mzstcaresal;

    alter table salud.mzstusu 
       add constraint FKdvu8s8bqcly6viei0rttbfo3d 
       foreign key (fk_cdis_usu) 
       references salud.mzstcdis;

    alter table detodocompie 
       add constraint FKep9ebvehjtqq59xmarwvydspv 
       foreign key (detalle_odontograma_compuesto_mzstdetodo_codigo) 
       references salud.mzstdetodocom;

    alter table mzstevo_ant 
       add constraint FKlrulpukdjksftpfwusg4h1hj4 
       foreign key (fk_notenf) 
       references salud.mzstnotenf;

    alter table mzstevo_ant 
       add constraint FK80rhjdfkkxd17g90bax6c7164 
       foreign key (fk_evo) 
       references salud.mzstevo;

    alter table mzstpac_ant 
       add constraint FK14s0drwdndcx0l20fldflr6pf 
       foreign key (fk_ant) 
       references salud.mzstant;

    alter table mzstpac_ant 
       add constraint FKcseqsaoyuiumlnmsepbqv3my4 
       foreign key (fk_notenf) 
       references salud.mzstnotenf;

    alter table mzstpac_per 
       add constraint FKjwcjkujy98t17csw3exem8tfr 
       foreign key (fk_per) 
       references salud.mzstper;

    alter table mzstpac_per 
       add constraint FKk750fkngnusca5ic7n9p7nhih 
       foreign key (fk_pac) 
       references salud.mzstpac;

    alter table mzstpac_sigvit 
       add constraint FKbr3yerotx06sepjs2n5nradxr 
       foreign key (fk_sigvit) 
       references salud.mzstsigvit;

    alter table mzstpac_sigvit 
       add constraint FKmu6jx6y9427k71sn9j0eil4ib 
       foreign key (fk_notenf) 
       references salud.mzstnotenf;

    alter table mzstrel_riebio_facriepueact 
       add constraint FKe1ya86f33t79ds154xmvp4w71 
       foreign key (fk_riebio) 
       references salud.mzstcriebio;

    alter table mzstrel_riebio_facriepueact 
       add constraint FKatgn0e749sotm6clwxcia8vnt 
       foreign key (fk_facriepueact) 
       references salud.mzstfacriepueact;

    alter table mzstrel_rieerg_facriepueact 
       add constraint FKnl1geuq5j54airp8bahkmmvbh 
       foreign key (fk_rieerg) 
       references salud.mzstcrieerg;

    alter table mzstrel_rieerg_facriepueact 
       add constraint FKu9cici1fk7fcbtnmpirko9tb 
       foreign key (fk_facriepueact) 
       references salud.mzstfacriepueact;

    alter table mzstrel_riefis_facriepueact 
       add constraint FKi4yf0hpduau2r24qmjgbsnd5u 
       foreign key (fk_riefis) 
       references salud.mzstcriefis;

    alter table mzstrel_riefis_facriepueact 
       add constraint FKhxampa9nmyjl3662ywxiknjlk 
       foreign key (fk_facriepueact) 
       references salud.mzstfacriepueact;

    alter table mzstrel_riemec_facriepueact 
       add constraint FK8iomuyewpk0s9vbqwh67v36bl 
       foreign key (fk_riemec) 
       references salud.mzstcriemec;

    alter table mzstrel_riemec_facriepueact 
       add constraint FKbbxa3lskg63temnkowa1kebbr 
       foreign key (fk_facriepueact) 
       references salud.mzstfacriepueact;

    alter table mzstrel_riepsi_facriepueact 
       add constraint FKeel84ydrlhcpvhixwuich11pd 
       foreign key (fk_riepsi) 
       references salud.mzstcriepsi;

    alter table mzstrel_riepsi_facriepueact 
       add constraint FKjrv6ioblexq198u7r4xgeau8n 
       foreign key (fk_facriepueact) 
       references salud.mzstfacriepueact;

    alter table mzstrel_riequi_facriepueact 
       add constraint FK9x8kgg3ywbvewwlrej9s3qyvs 
       foreign key (fk_riequi) 
       references salud.mzstcriequi;

    alter table mzstrel_riequi_facriepueact 
       add constraint FK5tq9xyhimpp2s3tvo9w7nqs5q 
       foreign key (fk_facriepueact) 
       references salud.mzstfacriepueact;

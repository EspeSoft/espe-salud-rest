package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.FrecuenciaMedicacionHabitual;
import com.espe.salud.dto.catalogo.FrecuenciaMedicacionHabitualDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_FRE_MED_HAB;

@RestController
@RequestMapping(value = {URI_API_V1_FRE_MED_HAB})
@Tag(description = "Gestiona el catálogo de frecuencias de medicación habitual", name = "Frecuencias de medicación habitual")
public class FrecuenciaMedicacionHabitualController {
    private GenericCRUDService<FrecuenciaMedicacionHabitual, FrecuenciaMedicacionHabitualDTO> service;

    public FrecuenciaMedicacionHabitualController(
            @Qualifier("frecuenciaMedicacionHabitualServiceImpl") GenericCRUDService<FrecuenciaMedicacionHabitual, FrecuenciaMedicacionHabitualDTO> service) {
        this.service = service;
    }


    @Operation(summary = "Retorna el listado de todas las frecuencias de medicación habitual")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<FrecuenciaMedicacionHabitualDTO>> getAll() {
        return new ResponseEntity<>(service.findAllOrderByNameASC(), HttpStatus.OK);
    }

}

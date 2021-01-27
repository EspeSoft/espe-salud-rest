package com.espe.salud.app.api.v1.paciente;

import com.espe.salud.dto.paciente.EmpleadoDTO;
import com.espe.salud.service.paciente.EmpleadoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.espe.salud.app.common.Constants.URI_API_V1_EMP;

@RestController
@Tag(name = "Gestiona los empleados de un paciente")
@RequestMapping(value = {URI_API_V1_EMP})
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }


    @PostMapping("/")
    public ResponseEntity<EmpleadoDTO> save(@RequestBody EmpleadoDTO paciente){
        return new ResponseEntity<>(empleadoService.save(paciente), HttpStatus.CREATED);
    }

}

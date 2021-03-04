package com.espe.salud.app.api.v1.paciente;

import com.espe.salud.dto.paciente.EstudianteDTO;
import com.espe.salud.service.paciente.EstudianteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.espe.salud.app.common.Constants.URI_API_V1_EST;

@RestController
@Tag(description = "Gestiona el perfil de estudiante de un paciente", name = "Estudiantes")
@RequestMapping(value = {URI_API_V1_EST})
public class EstudianteController {
    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }


    @PostMapping("/")
    public ResponseEntity<EstudianteDTO> save(@RequestBody EstudianteDTO paciente) {
        return new ResponseEntity<>(estudianteService.save(paciente), HttpStatus.CREATED);
    }
}

package com.sem3.matricula.controller;

import java.util.Optional;

import com.sem3.matricula.model.Alumno;
import com.sem3.matricula.repository.AlumnoRepository;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/alumno",produces = "application/json")

public class AlumnoController {

    private final AlumnoRepository alumnoData;

    public AlumnoController(AlumnoRepository alumnoData) {
        this.alumnoData = alumnoData;

    }

    @PostMapping(value = "/registro", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody Alumno alu){
        alumnoData.save(alu);
        alumnoData.flush();
        return new ResponseEntity<String>(alu.getId(),HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> findById(@PathVariable String id){
        Optional<Alumno> optAlumno = alumnoData.findById(id);
        if(optAlumno.isPresent()){
            Alumno a = optAlumno.get();
            return new ResponseEntity<Alumno>(a, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }

    }
}

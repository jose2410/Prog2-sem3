package com.sem3.matricula.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="t_alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nombres;
    private String apellidos;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;
    private String genero;
    private int edad;
    private String carrera;
}

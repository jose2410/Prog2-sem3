package com.sem3.matricula.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.sem3.matricula.model.*;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    @Query(value = "SELECT o FROM Alumno o WHERE o.id=?1")
    Optional <Alumno> findById(String id);
}

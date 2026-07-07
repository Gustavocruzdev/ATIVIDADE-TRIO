package com.example.leaibackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leaibackend.model.AlunoModel;



public interface AlunoRepository extends JpaRepository<AlunoModel, Long>{
    Optional<AlunoModel>findByMatricula(String matricula);

    boolean existsByMatricula(String matricula);
}

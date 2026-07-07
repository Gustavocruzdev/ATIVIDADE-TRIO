package com.example.leaibackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leaibackend.model.BibliotecarioModel;



public interface BlibliotecarioRepository extends JpaRepository<BibliotecarioModel, Long>{
    //Criar Optional para futura validação de Login do Spring Security

    Optional<BibliotecarioModel>findByEmail(String email);

    boolean existsByEmail(String email);
}

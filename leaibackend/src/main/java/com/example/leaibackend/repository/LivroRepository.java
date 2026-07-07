package com.example.leaibackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leaibackend.model.LivroModel;



public interface LivroRepository extends JpaRepository<LivroModel, Long>{
    Optional<LivroModel>findByIsbn(String   isbn);

    boolean existsByIsbn(String isbn);
}

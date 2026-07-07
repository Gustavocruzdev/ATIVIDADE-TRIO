package com.example.leaibackend.dto;

import com.example.leaibackend.model.BibliotecarioModel;

public record BibliotecarioResponseDTO(Long id, String nome, String email, String cargo) {
    public static BibliotecarioResponseDTO fromEntity(BibliotecarioModel bibliotecario){
        return new BibliotecarioResponseDTO(bibliotecario.getId(), bibliotecario.getNome(), bibliotecario.getEmail(), bibliotecario.getCargo());
    }
}

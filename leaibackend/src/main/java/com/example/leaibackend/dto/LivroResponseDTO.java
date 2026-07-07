package com.example.leaibackend.dto;

import com.example.leaibackend.model.LivroModel;

public record LivroResponseDTO(Long id, String titulo, String autor, String isbn, String genero, Integer quantidadeEstoque) {
    public static LivroResponseDTO fromEntity(LivroModel livro){
        return new LivroResponseDTO(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getIsbn(), livro.getGenero(), livro.getQuantidadeEstoque());
    }
}

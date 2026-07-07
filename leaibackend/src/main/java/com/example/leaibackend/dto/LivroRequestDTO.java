package com.example.leaibackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequestDTO(
    @NotBlank(message = "O título do livro é obrigatório.")
    String titulo,

    @NotBlank(message = "O autor do livro é obrigatório.")
    String autor,

    @NotBlank(message = "O código ISBN é obrigatório.")
    String isbn,

    String genero,

    @NotNull(message = "A quantidade em estoque não pode ser nula.")
    @Min(value = 0, message = "A quantidade em estoque não pode ser negativa.")
    Integer quantidadeEstoque
) {

}

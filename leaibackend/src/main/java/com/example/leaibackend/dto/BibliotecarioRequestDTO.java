package com.example.leaibackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BibliotecarioRequestDTO(
    @NotBlank(message = "O nome do funcionário é obrigatório.")
    String nome,

    @NotBlank(message = "O -email é obrigatório.")
    @Email(message = "Formato de e-mail inválido.")
    String email,

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, message = "A senha deve conter no mínimo 6 caracteres.")
    String senha
) {
    
}

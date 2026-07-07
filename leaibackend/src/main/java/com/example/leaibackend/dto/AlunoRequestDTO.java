package com.example.leaibackend.dto;

import jakarta.validation.constraints.NotBlank;

public record AlunoRequestDTO(
    @NotBlank(message = "Ma matrícula do aluno é obrigatória.")
    String matricula,

    @NotBlank(message = "O nome do aluno é obrigatório.")
    String nome,

    @NotBlank(message = "A turma é obrigatória.")
    String turma,

    String telefone
) {

}

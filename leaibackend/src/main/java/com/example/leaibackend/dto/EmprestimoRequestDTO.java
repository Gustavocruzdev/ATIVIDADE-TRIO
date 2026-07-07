package com.example.leaibackend.dto;

import jakarta.validation.constraints.NotNull;

public record EmprestimoRequestDTO(
    @NotNull(message = "O ID do aluno é obrigatório para o empréstimo.")
    Long alunoId,

    @NotNull(message = "O ID do livro é obrigatório para o empréstimo.")
    Long livroId
) {

}

package com.example.leaibackend.dto;

import com.example.leaibackend.model.AlunoModel;

public record AlunoResponseDTO(Long id, String matricula, String nome, String turma, String telefone) {
    public static AlunoResponseDTO fromEntity(AlunoModel aluno){
        return new AlunoResponseDTO(aluno.getId(), aluno.getMatricula(), aluno.getNome(), aluno.getTurma(), aluno.getTelefone());
    }
}

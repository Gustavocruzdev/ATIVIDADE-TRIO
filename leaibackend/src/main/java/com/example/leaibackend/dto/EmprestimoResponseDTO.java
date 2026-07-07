package com.example.leaibackend.dto;

import java.time.LocalDate;

import com.example.leaibackend.model.EmprestimoModel;

public record EmprestimoResponseDTO(Long id, AlunoResponseDTO aluno, LivroResponseDTO livro, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista, String status) {
    
    public static EmprestimoResponseDTO fromEntity(EmprestimoModel emprestimo) {
        return new EmprestimoResponseDTO(
            emprestimo.getId(),
            AlunoResponseDTO.fromEntity(emprestimo.getAluno()),
            LivroResponseDTO.fromEntity(emprestimo.getLivro()),
            emprestimo.getDataEmprestimo(),
            emprestimo.getDataDevolucaoPrevista(),
            emprestimo.getStatus().name()
        );
    }
}

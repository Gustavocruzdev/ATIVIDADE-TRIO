package com.example.leaibackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leaibackend.model.EmprestimoModel;
import com.example.leaibackend.model.enums.StatusEmprestimo;

public interface EmprestimoRepository extends JpaRepository<EmprestimoModel,Long>{
    //Repository para buscar os empréstimos ativos de um aluno

    List<EmprestimoModel>findByAlunoIdAndStatus(Long alunoId, StatusEmprestimo status);

   // Conta quantos empréstimos ativos existem para um livro específico
   long countByLivroIdAndStatus(Long livroId, StatusEmprestimo status);
}

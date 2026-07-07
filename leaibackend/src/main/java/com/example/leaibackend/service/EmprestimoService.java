package com.example.leaibackend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.leaibackend.dto.EmprestimoRequestDTO;
import com.example.leaibackend.dto.EmprestimoResponseDTO;
import com.example.leaibackend.exception.BusinessException;
import com.example.leaibackend.model.AlunoModel;
import com.example.leaibackend.model.EmprestimoModel;
import com.example.leaibackend.model.LivroModel;
import com.example.leaibackend.model.enums.StatusEmprestimo;
import com.example.leaibackend.repository.AlunoRepository;
import com.example.leaibackend.repository.EmprestimoRepository;
import com.example.leaibackend.repository.LivroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    private final AlunoRepository alunoRepository;

    private final LivroRepository livroRepository;

    @Transactional
    public EmprestimoResponseDTO realizarEmprestimo(EmprestimoRequestDTO dto){
        AlunoModel aluno = alunoRepository.findById(dto.alunoId()).orElseThrow(() -> new BusinessException("Aluno não encontrado."));

        LivroModel livro = livroRepository.findById(dto.livroId()).orElseThrow(() -> new BusinessException("Livro não encontrado."));

        //Regra de negócio:Caso o Estoque esteja zerado

        if (livro.getQuantidadeEstoque() <= 0) {
         throw new BusinessException("Não é possível realizar empréstimos sem livros oras");   
        }

        //Sempre que o empréstimo for feito, retira 1 unidade do estoque

        livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() -1);

        //Aqui é onde se monta o empréstimo com data atual e devolução para 7 dias depois

        EmprestimoModel emprestimo = new EmprestimoModel();

        emprestimo.setAluno(aluno);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucaoPrevista(LocalDate.now().plusDays(7));
        emprestimo.setStatus(StatusEmprestimo.ATIVO);

        return EmprestimoResponseDTO.fromEntity(emprestimoRepository.save(emprestimo));
    }

    @Transactional
    public EmprestimoResponseDTO devolverLivro(Long emprestimoId){
        EmprestimoModel emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new BusinessException("Emprestimo não encontrado."));

        if (emprestimo.getStatus() == StatusEmprestimo.DEVOLVIDO) {
            throw new BusinessException("Este empréstimo já foi devolvido anteriormente.");
        }

        //Alterando status
        emprestimo.setStatus(StatusEmprestimo.DEVOLVIDO);

        //Livro devolvido para o Estoque (Estoque + 1)

        LivroModel livro = emprestimo.getLivro();
        livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() + 1);

        livroRepository.save(livro);
        return EmprestimoResponseDTO.fromEntity(emprestimoRepository.save(emprestimo));
    }

    public List<EmprestimoResponseDTO> listarTodos(){
        return emprestimoRepository.findAll().stream().map(EmprestimoResponseDTO::fromEntity).toList();
    }
}

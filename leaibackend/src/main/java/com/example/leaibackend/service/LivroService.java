package com.example.leaibackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.leaibackend.dto.LivroRequestDTO;
import com.example.leaibackend.dto.LivroResponseDTO;
import com.example.leaibackend.exception.BusinessException;
import com.example.leaibackend.model.LivroModel;
import com.example.leaibackend.repository.LivroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    @Transactional
    public LivroResponseDTO cadastrar(LivroRequestDTO dto){
        if (livroRepository.existsByIsbn(dto.isbn())) {
            throw new BusinessException("Já existe um livro cadastrado com este ISBN.");
        }

        LivroModel livro = new LivroModel(null, dto.titulo(), dto.autor(), dto.isbn(), dto.genero(), dto.quantidadeEstoque());

        return LivroResponseDTO.fromEntity(livroRepository.save(livro));
    }

    public List<LivroResponseDTO>listarTodos(){
        return livroRepository.findAll().stream().map(LivroResponseDTO::fromEntity).toList();
    }

    public LivroResponseDTO buscarPorId(Long id){
      LivroModel livro = livroRepository.findById(id).orElseThrow(() -> new BusinessException("Livro não encontrado com o ID fornecido."));
      
      return LivroResponseDTO.fromEntity(livro);
    }
}

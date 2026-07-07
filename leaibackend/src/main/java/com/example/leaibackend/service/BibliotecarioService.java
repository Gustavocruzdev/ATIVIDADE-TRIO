package com.example.leaibackend.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.leaibackend.dto.BibliotecarioRequestDTO;
import com.example.leaibackend.dto.BibliotecarioResponseDTO;
import com.example.leaibackend.exception.BusinessException;
import com.example.leaibackend.model.BibliotecarioModel;
import com.example.leaibackend.repository.BlibliotecarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BibliotecarioService {
    
    private final BlibliotecarioRepository blibliotecarioRepository;

    

    @Transactional
    public BibliotecarioResponseDTO cadastrar(BibliotecarioRequestDTO dto){
        if (blibliotecarioRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Este e-mail já está cadastrado no sistema, tente outro email.");
        }

        BibliotecarioModel bib = new BibliotecarioModel();

        bib.setNome(dto.nome());
        bib.setEmail(dto.email());
        bib.setSenha(dto.senha());//Inserir o BYCrypt futuramente aqui...alunoRepository

        return BibliotecarioResponseDTO.fromEntity(blibliotecarioRepository.save(bib));

    }

    public List<BibliotecarioResponseDTO>listarTodos(){
        return blibliotecarioRepository.findAll().stream().map(BibliotecarioResponseDTO::fromEntity).toList();
    }
}

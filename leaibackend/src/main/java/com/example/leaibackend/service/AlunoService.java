package com.example.leaibackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.leaibackend.dto.AlunoRequestDTO;
import com.example.leaibackend.dto.AlunoResponseDTO;
import com.example.leaibackend.exception.BusinessException;
import com.example.leaibackend.model.AlunoModel;
import com.example.leaibackend.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;

    @Transactional
    public AlunoResponseDTO cadastrar(AlunoRequestDTO dto){
        if (alunoRepository.existsByMatricula(dto.matricula())) {
          throw new BusinessException("Já existe um aluno cadastrado com esta matrícula.");  
        }

        AlunoModel aluno = new AlunoModel(null, dto.matricula(), dto.nome(), dto.turma(), dto.telefone());
        
        return AlunoResponseDTO.fromEntity(alunoRepository.save(aluno));
    }

    public List<AlunoResponseDTO>listarTodos(){
        return alunoRepository.findAll().stream().map(AlunoResponseDTO::fromEntity).toList();
    }
}

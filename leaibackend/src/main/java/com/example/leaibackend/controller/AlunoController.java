package com.example.leaibackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leaibackend.dto.AlunoRequestDTO;
import com.example.leaibackend.dto.AlunoResponseDTO;
import com.example.leaibackend.service.AlunoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/alunos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AlunoController {
    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponseDTO>cadastrar(@Valid @RequestBody AlunoRequestDTO dto){
        AlunoResponseDTO response = alunoService.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>>listarTodos(){
        return ResponseEntity.ok(alunoService.listarTodos());
    }
}

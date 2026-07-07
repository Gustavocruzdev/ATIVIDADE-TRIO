package com.example.leaibackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leaibackend.dto.LivroRequestDTO;
import com.example.leaibackend.dto.LivroResponseDTO;
import com.example.leaibackend.service.LivroService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/livros")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LivroController {
    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDTO>cadastrar(@Valid @RequestBody LivroRequestDTO dto){
        LivroResponseDTO response = livroService.cadastrar(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>>listarTodos(){
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO>buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }
}

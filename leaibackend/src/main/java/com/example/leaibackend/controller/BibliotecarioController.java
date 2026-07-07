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

import com.example.leaibackend.dto.BibliotecarioRequestDTO;
import com.example.leaibackend.dto.BibliotecarioResponseDTO;
import com.example.leaibackend.service.BibliotecarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BibliotecarioController {
    private final BibliotecarioService bibliotecarioService;

    @PostMapping
    public ResponseEntity<BibliotecarioResponseDTO>cadastrar(@Valid @RequestBody BibliotecarioRequestDTO dto){
        BibliotecarioResponseDTO response = bibliotecarioService.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BibliotecarioResponseDTO>>listarTodos(){
        return ResponseEntity.ok(bibliotecarioService.listarTodos());
    }
}

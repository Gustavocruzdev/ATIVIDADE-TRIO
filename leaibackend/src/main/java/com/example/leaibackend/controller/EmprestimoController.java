package com.example.leaibackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leaibackend.dto.EmprestimoRequestDTO;
import com.example.leaibackend.dto.EmprestimoResponseDTO;
import com.example.leaibackend.service.EmprestimoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/emprestimos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO>realizarEmprestimo(@Valid @RequestBody EmprestimoRequestDTO dto){
        EmprestimoResponseDTO response = emprestimoService.realizarEmprestimo(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<EmprestimoResponseDTO>devolverLivro(@PathVariable Long id){
        return ResponseEntity.ok(emprestimoService.devolverLivro(id));
    }

    @GetMapping
    public ResponseEntity<List<EmprestimoResponseDTO>>listarTodos(){
        return ResponseEntity.ok(emprestimoService.listarTodos());
    }
}

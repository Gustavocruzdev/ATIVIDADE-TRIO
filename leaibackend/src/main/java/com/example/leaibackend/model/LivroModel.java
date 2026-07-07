package com.example.leaibackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_livros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false, unique = true)
    private String isbn;

    private String genero;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;

    //OBS:Com os "ArgsConstructor" do Lombok não é necessário fazer os Construtores, Getters e Setters. Mas por precaução...Retire os Args e faça os construtores e GETTERS E SETTERS"

    
}

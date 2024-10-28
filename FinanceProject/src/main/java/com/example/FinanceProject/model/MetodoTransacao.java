package com.example.FinanceProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "metodotransacao")
public class MetodoTransacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public MetodoTransacao() {
    }

    public MetodoTransacao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

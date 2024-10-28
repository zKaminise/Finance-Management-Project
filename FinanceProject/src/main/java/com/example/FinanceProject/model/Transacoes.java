package com.example.FinanceProject.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Transacao")

public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;
    private Date data;
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "tipotran_id")
    private TipoTransacao tipoTransacao;

    @ManyToOne
    @JoinColumn(name = "metodo_id")
    private MetodoTransacao metodoTransacao;

    public Transacoes() {
    }

    public Transacoes(String nome, String categoria, Date data, Double valor, TipoTransacao tipoTransacao, MetodoTransacao metodoTransacao) {
        this.nome = nome;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.metodoTransacao = metodoTransacao;


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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public MetodoTransacao getMetodoTransacao() {
        return metodoTransacao;
    }

    public void setMetodoTransacao(MetodoTransacao metodoTransacao) {
        this.metodoTransacao = metodoTransacao;
    }

}

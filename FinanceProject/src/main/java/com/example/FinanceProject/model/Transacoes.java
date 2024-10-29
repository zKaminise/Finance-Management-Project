package com.example.FinanceProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Transacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

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

}

package com.example.FinanceProject.controller;

import com.example.FinanceProject.model.TipoTransacao;
import com.example.FinanceProject.repository.TipoTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tipotransacao")
public class TipoTransacaoController {

    @Autowired
    private TipoTransacaoRepository tipoTransacaoRepository;

    @GetMapping
    public List<TipoTransacao> getAllTiposTransacao() {
        return tipoTransacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTransacao> getTipoTransacaoById(@PathVariable Long id) {
        Optional<TipoTransacao> tipoTransacao = tipoTransacaoRepository.findById(id);
        return tipoTransacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

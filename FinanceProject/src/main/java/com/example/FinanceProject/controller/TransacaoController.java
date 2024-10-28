package com.example.FinanceProject.controller;

import com.example.FinanceProject.model.Transacoes;
import com.example.FinanceProject.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public List<Transacoes> getAllTrasacoes() {
        return transacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacoes> getTransacaoById(@PathVariable Long id) {
        Optional<Transacoes> transacoes = transacaoRepository.findById(id);
        return transacoes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Transacoes createTrasacao(@RequestBody Transacoes transacoes){
        return transacaoRepository.save(transacoes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacoes> updateTransacao(@PathVariable Long id, @RequestBody Transacoes transacoes) {
        Optional<Transacoes> transacaoOptional = transacaoRepository.findById(id);

        if (transacaoOptional.isPresent()) {
            Transacoes transacao = transacaoOptional.get();
            transacao.setNome(transacao.getNome());
            transacao.setCategoria(transacao.getCategoria());
            transacao.setData(transacao.getData());
            transacao.setValor(transacao.getValor());
            transacao.setTipoTransacao(transacao.getTipoTransacao());
            transacao.setMetodoTransacao(transacao.getMetodoTransacao());

            return new ResponseEntity<>(transacaoRepository.save(transacao), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable Long id) {
        if (transacaoRepository.existsById(id)) {
            transacaoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

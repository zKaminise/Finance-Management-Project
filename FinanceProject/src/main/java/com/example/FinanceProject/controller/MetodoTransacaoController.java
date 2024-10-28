package com.example.FinanceProject.controller;

import com.example.FinanceProject.model.MetodoTransacao;
import com.example.FinanceProject.repository.MetodoTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("metodotransacao")
public class MetodoTransacaoController {

    @Autowired
    private MetodoTransacaoRepository metodoTransacaoRepository;

    @GetMapping
    public List<MetodoTransacao> getAllMetodos(){
        return metodoTransacaoRepository.findAll();
    }
}

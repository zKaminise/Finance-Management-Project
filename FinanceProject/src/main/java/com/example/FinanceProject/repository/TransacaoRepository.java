package com.example.FinanceProject.repository;

import com.example.FinanceProject.model.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacoes, Long> {
}

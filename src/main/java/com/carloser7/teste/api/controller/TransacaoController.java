package com.carloser7.teste.api.controller;

import com.carloser7.teste.domain.model.Transacao;
import com.carloser7.teste.domain.repository.TransacaoRepository;
import com.carloser7.teste.domain.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public Transacao criar(@RequestBody Transacao transacao) {
        return this.transacaoService.criar(transacao);
    }
}

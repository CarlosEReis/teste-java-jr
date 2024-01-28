package com.carloser7.teste.domain.service;

import com.carloser7.teste.domain.event.TransacaoProcessadaEvent;
import com.carloser7.teste.domain.model.Cliente;
import com.carloser7.teste.domain.model.Empresa;
import com.carloser7.teste.domain.model.Transacao;
import com.carloser7.teste.domain.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired private TransacaoRepository transacaoRepository;
    @Autowired private UsuarioService usuarioService;
    @Autowired private ApplicationEventPublisher publisher;

    public Transacao criar(Transacao transacao) {
        Cliente cliente = usuarioService.buscarClienteOuFalha(transacao.getCliente().getId());
        Empresa empresa = usuarioService.buscarEmpresaOuFalha(transacao.getEmpresa().getId());

        transacao = new Transacao(cliente, empresa, transacao.getValor(), transacao.getTipo());
        Transacao transacaoSave = transacaoRepository.save(transacao);

        publisher.publishEvent(new TransacaoProcessadaEvent(transacaoSave));

        return transacaoSave;
    }


}

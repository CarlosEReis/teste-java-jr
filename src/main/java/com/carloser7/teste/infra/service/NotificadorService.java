package com.carloser7.teste.infra.service;

import com.carloser7.teste.domain.event.TransacaoProcessadaEvent;
import com.carloser7.teste.infra.noticacao.NotificaPor;
import com.carloser7.teste.infra.noticacao.Notificador;
import com.carloser7.teste.infra.noticacao.TipoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificadorService {

    @NotificaPor(TipoNotificador.SMS)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void transacapProcessadaListener(TransacaoProcessadaEvent event) {
        var nomeCliente = event.transacao().getCliente().getNome();
        var nomeEmpresa = event.transacao().getEmpresa().getNome();
        var valor = event.transacao().getValor();

        notificador.notificar(nomeCliente, nomeEmpresa, valor);
    }
}

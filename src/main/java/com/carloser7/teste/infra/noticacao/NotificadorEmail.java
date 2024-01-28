package com.carloser7.teste.infra.noticacao;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@NotificaPor(TipoNotificador.EMAIL)
public class NotificadorEmail implements Notificador {

    private static final String mensagem = """
            __________________________________________________________________________
            Caro cliente %s,
            Sua transação no valor de %.2f na empresa %s, foi efetuada com sucesso
            
            """;

    @Override
    public void notificar(String cliente, String empresa, BigDecimal valor) {
        System.out.println("\nNotificando via EMAIL");
        System.out.println(
                String.format(mensagem, cliente, valor, empresa)
        );
    }
}

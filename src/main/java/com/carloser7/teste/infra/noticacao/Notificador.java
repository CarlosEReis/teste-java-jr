package com.carloser7.teste.infra.noticacao;

import java.math.BigDecimal;

public interface Notificador {

    void notificar(String cliente, String empresa, BigDecimal valor);
}

package com.carloser7.teste.domain.exception;

import java.math.BigDecimal;

public class SaldoInsuficienteException extends SaldoException{

    private static final String msg =
            "Saldo insuficiente para saque. Saldo atual igual a %.2f e o valor de saque é de %.2f";

    public SaldoInsuficienteException(BigDecimal valorSaldo, BigDecimal valorSaque) {
        super(String.format(msg, valorSaldo, valorSaque));
    }
}

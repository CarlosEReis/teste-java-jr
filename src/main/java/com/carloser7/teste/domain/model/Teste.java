package com.carloser7.teste.domain.model;

import java.math.BigDecimal;

public class Teste {

    public static void main(String[] args) {

        Cliente c1 = new Cliente(
            1L,
            "Carlos Reis",
            "08701821024");

        Empresa e1 = new Empresa(
            1L,
            "ER7 Sistemas",
            "93158570000195",
            0.1);

        System.out.println(e1.imprimeDados());
        Transacao transacao = new Transacao(null, e1, BigDecimal.valueOf(100), TipoDeTransacao.SAQUE);
        System.out.println(e1.imprimeDados());


    }

}

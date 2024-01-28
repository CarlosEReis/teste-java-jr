package com.carloser7.teste.domain.exception;

public class EmpresaNaoEncontradaException extends EntidadeNaoEncontradaException{

    private static final String mensagem = "Não existe uma empresa com ID %s cadastrada.";

    public EmpresaNaoEncontradaException(Long empresaID) {
        super(String.format(mensagem, empresaID));
    }
}

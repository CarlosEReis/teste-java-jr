package com.carloser7.teste.domain.exception;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final String mensagem = "Não existe um cliente com ID %s cadastrado.";

    public ClienteNaoEncontradoException(Long clienteID) {
        super(String.format(mensagem, clienteID));
    }
}

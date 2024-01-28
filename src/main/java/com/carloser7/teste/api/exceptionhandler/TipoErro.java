package com.carloser7.teste.api.exceptionhandler;

public enum TipoErro {


    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos."),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado.");

    private String title;
    private String uri;

    TipoErro(String path, String title) {
        this.uri = "https://er7food.com.br".concat(path);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }
}

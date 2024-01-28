package com.carloser7.teste.api.exceptionhandler;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;


public class ApiErro {

    private Integer status;
    private String type;
    private String title;
    private String detail;
    private List<Field> erros;

    public ApiErro(Integer status, TipoErro type, String detail, List<FieldError> bindingResult) {
        this.status = status;
        this.type = type.getUri();
        this.title = type.getTitle();
        this.detail = detail;
        criaListaDeErros(bindingResult);
    }

    public Integer getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public List<Field> getErros() {
        return erros;
    }

    public void setErros(List<Field> erros) {
        this.erros = erros;
    }

    public class Field {

        private String name;
        private String userMessage;

        public Field(String name, String userMessage) {
            this.name = name;
            this.userMessage = userMessage;
        }
    }

    private void criaListaDeErros(List<FieldError> errors) {
        List<Field> erros = new ArrayList<>();

        for (FieldError fieldError : errors) {

            String msgUsuario = fieldError.getField();
            String msgDesenvolvedor = fieldError.getDefaultMessage();
            erros.add(new Field(msgUsuario, msgDesenvolvedor));
        }
        this.erros = erros;
    }
}
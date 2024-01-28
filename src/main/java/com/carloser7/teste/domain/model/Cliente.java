package com.carloser7.teste.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Usuario {

    @CPF
    @Column(name = "documento")
    private String cpf;

    @NotBlank
    private String telefone;

    @NotBlank
    @Email
    private String email;

    public Cliente() {}

    public Cliente(Long id, String nome, String cpf) {
        super(id, nome);
        this.setCpf(cpf);
        //;Validador.validar(this);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}

package com.carloser7.teste.domain.model;

import com.carloser7.teste.domain.exception.SaldoInsuficienteException;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("EMPRESA")
public class Empresa extends Usuario {

    @CNPJ
    @Column(name = "documento")
    private String cnpj;

    @NotNull
    private Double taxa;
    private BigDecimal saldo = BigDecimal.ZERO;

    public Empresa() {}

    public Empresa(Long id, String nome, String cnpj, double taxa) {
        super(id, nome);
        this.cnpj = cnpj;
        this.taxa = taxa;
        //Validador.validar(this);
    }

    public String getCnpj() {
        return cnpj;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public void deposita(BigDecimal valorDeposito) {
        valorDeposito = this.incideTaxaNo(valorDeposito);
        this.saldo = this.saldo.add(valorDeposito);
    }

    public void saca(BigDecimal valorDoSaque) {
        if (this.saldo.compareTo(valorDoSaque) < 0)
            throw new SaldoInsuficienteException(this.saldo, valorDoSaque);
        valorDoSaque = this.incideTaxaNo(valorDoSaque);
        this.saldo = this.saldo.subtract(valorDoSaque);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal incideTaxaNo(BigDecimal valorMovimentacao) {
        BigDecimal valorTaxa = valorMovimentacao.multiply(BigDecimal.valueOf(taxa).divide(BigDecimal.valueOf(100)));
        return valorMovimentacao =  valorMovimentacao.subtract(valorTaxa);
    }

    public String imprimeDados() {
        return String.format("""
                
            SALDO EMPRESA....
            ---------------------------------------------------------------
            id: %s
            nome: %s
            CPF: %s
            Taxa: %.2f
            Saldo: %.2f
            """,
            this.getId(), this.getNome(), this.getCnpj(), this.getTaxa(), this.getSaldo());
    }

}

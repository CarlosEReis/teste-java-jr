package com.carloser7.teste.domain.model;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
public class Transacao {

    private static final Logger logger = LoggerFactory.getLogger(Transacao.class);
    private static final String msgTipoTransacao = "Realizando operação do tipo %s no valor %.2f";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private OffsetDateTime data = OffsetDateTime.now();

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoDeTransacao tipo;

    public Transacao() {}

    public Transacao(Cliente cliente, Empresa empresa, BigDecimal valor, TipoDeTransacao tipo) {
        this.cliente = cliente;
        this.empresa = empresa;
        this.valor = valor;
        this.tipo = tipo;

        logger.info(
            String.format("Abrindo uma transação entre CLIENTE: %s e EMPRESA: %s", getCliente().getCpf(), getEmpresa().getCnpj())
        );

        processarTransacao();
    }

    private void processarTransacao() {
        logger.info("Efetuando transação");

        if (tipo.equals(TipoDeTransacao.DEPOSITO))
            deposita();
        if (tipo.equals(TipoDeTransacao.SAQUE))
            saque();

        logger.info(String.format("%s realizado com sucesso.", tipo));
    }

    private void saque() {
        logger.info(String.format(msgTipoTransacao, tipo, valor));
        empresa.saca(valor);
    }

    private void deposita() {
        logger.info(String.format(msgTipoTransacao, tipo, valor));
        empresa.deposita(valor);
    }

    public String getId() {
        return id;
    }

    public OffsetDateTime getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoDeTransacao getTipo() {
        return tipo;
    }
}

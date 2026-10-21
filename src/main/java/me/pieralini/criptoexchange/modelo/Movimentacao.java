package me.pieralini.criptoexchange.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movimentacao {

    private final LocalDateTime dataHora;
    private final String tipo;
    private final String moeda;
    private final BigDecimal valor;
    private final BigDecimal cotacao;
    private final BigDecimal taxa;
    private final BigDecimal saldoReais;
    private final BigDecimal saldoBitcoin;
    private final BigDecimal saldoEthereum;
    private final BigDecimal saldoRipple;

    public Movimentacao(LocalDateTime dataHora, String tipo, String moeda,
                        BigDecimal valor, BigDecimal cotacao, BigDecimal taxa,
                        BigDecimal saldoReais, BigDecimal saldoBitcoin,
                        BigDecimal saldoEthereum, BigDecimal saldoRipple) {

        this.dataHora = dataHora;
        this.tipo = tipo;
        this.moeda = moeda;
        this.valor = valor;
        this.cotacao = cotacao;
        this.taxa = taxa;
        this.saldoReais = saldoReais;
        this.saldoBitcoin = saldoBitcoin;
        this.saldoEthereum = saldoEthereum;
        this.saldoRipple = saldoRipple;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMoeda() {
        return moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getCotacao() {
        return cotacao;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public BigDecimal getSaldoReais() {
        return saldoReais;
    }

    public BigDecimal getSaldoBitcoin() {
        return saldoBitcoin;
    }

    public BigDecimal getSaldoEthereum() {
        return saldoEthereum;
    }

    public BigDecimal getSaldoRipple() {
        return saldoRipple;
    }
}
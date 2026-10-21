package me.pieralini.criptoexchange.modelo;

import java.math.BigDecimal;

public class Carteira {

    private final BigDecimal reais;
    private final BigDecimal bitcoin;
    private final BigDecimal ethereum;
    private final BigDecimal ripple;

    public Carteira(BigDecimal reais, BigDecimal bitcoin, BigDecimal ethereum, BigDecimal ripple) {
        this.reais = reais;
        this.bitcoin = bitcoin;
        this.ethereum = ethereum;
        this.ripple = ripple;
    }

    public BigDecimal getReais() {
        return reais;
    }

    public BigDecimal getBitcoin() {
        return bitcoin;
    }

    public BigDecimal getEthereum() {
        return ethereum;
    }

    public BigDecimal getRipple() {
        return ripple;
    }

    public BigDecimal getSaldo(String moeda) {
        switch (moeda) {
            case "BRL":
                return reais;
            case "BTC":
                return bitcoin;
            case "ETH":
                return ethereum;
            case "XRP":
                return ripple;
            default:
                throw new IllegalArgumentException("Moeda inválida");
        }
    }
}
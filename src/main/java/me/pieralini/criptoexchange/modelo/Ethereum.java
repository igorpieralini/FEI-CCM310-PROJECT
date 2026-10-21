package me.pieralini.criptoexchange.modelo;

import java.math.BigDecimal;

public class Ethereum extends Moeda implements Tarifacao {

    public Ethereum() {
        super("ETH");
    }

    public BigDecimal getTaxaCompra() {
        return new BigDecimal("0.01");
    }

    public BigDecimal getTaxaVenda() {
        return new BigDecimal("0.02");
    }
}
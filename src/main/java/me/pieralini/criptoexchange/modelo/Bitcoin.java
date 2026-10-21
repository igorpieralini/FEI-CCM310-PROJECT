package me.pieralini.criptoexchange.modelo;

import java.math.BigDecimal;

public class Bitcoin extends Moeda implements Tarifacao {

    public Bitcoin() {
        super("BTC");
    }

    public BigDecimal getTaxaCompra() {
        return new BigDecimal("0.02");
    }

    public BigDecimal getTaxaVenda() {
        return new BigDecimal("0.03");
    }
}
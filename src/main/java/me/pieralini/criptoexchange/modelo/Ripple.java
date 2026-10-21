package me.pieralini.criptoexchange.modelo;

import java.math.BigDecimal;

public class Ripple extends Moeda implements Tarifacao {

    public Ripple() {
        super("XRP");
    }

    public BigDecimal getTaxaCompra() {
        return new BigDecimal("0.01");
    }

    public BigDecimal getTaxaVenda() {
        return new BigDecimal("0.01");
    }
}
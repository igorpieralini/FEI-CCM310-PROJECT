package me.pieralini.criptoexchange.modelo;

import java.math.BigDecimal;

public interface Tarifacao {

    BigDecimal getTaxaCompra();

    BigDecimal getTaxaVenda();
}
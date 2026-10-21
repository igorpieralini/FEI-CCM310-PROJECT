package me.pieralini.criptoexchange.modelo;

public abstract class Moeda {

    private final String codigo;

    protected Moeda(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
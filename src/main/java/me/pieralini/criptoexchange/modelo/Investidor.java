package me.pieralini.criptoexchange.modelo;

public class Investidor extends Pessoa {

    private final long id;
    private final String senhaHash;

    public Investidor(long id, String nome, String cpf, String senhaHash) {
        super(nome, cpf);
        this.id = id;
        this.senhaHash = senhaHash;
    }

    public long getId() {
        return id;
    }

    public String getSenhaHash() {
        return senhaHash;
    }
}
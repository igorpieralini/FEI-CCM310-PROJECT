package me.pieralini.criptoexchange.controle;

import java.math.BigDecimal;
import me.pieralini.criptoexchange.modelo.Carteira;
import me.pieralini.criptoexchange.modelo.Investidor;
import me.pieralini.criptoexchange.servico.OperacaoServico;

public class OperacaoControle {

    private final OperacaoServico operacaoServico = new OperacaoServico();

    public Carteira comprar(Investidor investidor, String senha, String moeda, BigDecimal valorReais) throws Exception {
        return operacaoServico.comprar(investidor, senha, moeda, valorReais);
    }

    public Carteira vender(Investidor investidor, String senha, String moeda, BigDecimal quantidade) throws Exception {
        return operacaoServico.vender(investidor, senha, moeda, quantidade);
    }
}
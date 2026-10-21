package me.pieralini.criptoexchange.controle;

import java.math.BigDecimal;
import java.util.List;
import me.pieralini.criptoexchange.modelo.Carteira;
import me.pieralini.criptoexchange.modelo.Investidor;
import me.pieralini.criptoexchange.modelo.Movimentacao;
import me.pieralini.criptoexchange.servico.OperacaoServico;

public class CarteiraControle {

    private final OperacaoServico operacaoServico = new OperacaoServico();

    public Carteira consultarSaldo(Investidor investidor, String senha) throws Exception {
        return operacaoServico.consultarSaldo(investidor, senha);
    }

    public List<Movimentacao> consultarExtrato(Investidor investidor, String senha) throws Exception {
        return operacaoServico.consultarExtrato(investidor, senha);
    }

    public Carteira depositar(Investidor investidor, BigDecimal valor) throws Exception {
        return operacaoServico.depositar(investidor, valor);
    }

    public Carteira sacar(Investidor investidor, BigDecimal valor) throws Exception {
        return operacaoServico.sacar(investidor, valor);
    }
}
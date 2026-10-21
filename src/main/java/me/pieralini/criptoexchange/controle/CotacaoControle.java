package me.pieralini.criptoexchange.controle;

import java.math.BigDecimal;
import java.util.Map;
import me.pieralini.criptoexchange.servico.CotacaoServico;

public class CotacaoControle {

    private final CotacaoServico cotacaoServico = new CotacaoServico();

    public Map<String, BigDecimal> consultar() throws Exception {
        return cotacaoServico.consultar();
    }

    public Map<String, BigDecimal> atualizar() throws Exception {
        return cotacaoServico.atualizar();
    }
}
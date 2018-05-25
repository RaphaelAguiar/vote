package br.com.rca.votos.domain.eleicao;

import java.util.List;

public class Resultado {
    private List<Contagem> contagem;

    public List<Contagem> getContagem() {
        return contagem;
    }

    public void setContagem(List<Contagem> contagem) {
        this.contagem = contagem;
    }
}

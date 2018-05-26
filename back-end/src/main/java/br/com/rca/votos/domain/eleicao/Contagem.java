package br.com.rca.votos.domain.eleicao;

public class Contagem {
    private String cpfCandidato;
    private long votos;

    public String getCpfCandidato() {
        return cpfCandidato;
    }

    public void setCpfCandidato(String cpfCandidato) {
        this.cpfCandidato = cpfCandidato;
    }

    public long getVotos() {
        return votos;
    }

    public void setVotos(long votos) {
        this.votos = votos;
    }
}

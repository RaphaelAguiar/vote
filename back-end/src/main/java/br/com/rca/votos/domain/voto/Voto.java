package br.com.rca.votos.domain.voto;

//Criptogravar para que apenas o autor do eleicao saiba qual foi o seu eleicao;

import org.springframework.data.annotation.Id;

public class Voto {
    @Id
    private String id;
    private String cpfVotante;
    private String nomeCargo;
    private String cpfVotado;

    public String getCpfVotante() {
        return cpfVotante;
    }

    public void setCpfVotante(String cpfVotante) {
        this.cpfVotante = cpfVotante;
        this.atualizarId();
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
        this.atualizarId();
    }

    public String getCpfVotado() {
        return cpfVotado;
    }

    public void setCpfVotado(String cpfVotado) {
        this.cpfVotado = cpfVotado;
    }

    private void atualizarId() {
        this.id = cpfVotante + nomeCargo;
    }

    public String getId(){
        return cpfVotante + nomeCargo;
    }
}

package br.com.rca.votos.api.cidadao;

public class CidadaoGetReturn {
    private String cpf;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nomeCargoCandidatado;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCargoCandidatado() {
        return nomeCargoCandidatado;
    }

    public void setNomeCargoCandidatado(String nomeCargoCandidatado) {
        this.nomeCargoCandidatado = nomeCargoCandidatado;
    }
}

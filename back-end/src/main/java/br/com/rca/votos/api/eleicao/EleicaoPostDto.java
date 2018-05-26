package br.com.rca.votos.api.eleicao;

import javax.validation.constraints.NotNull;

public class EleicaoPostDto {
    @NotNull
    private String cargo;
    @NotNull
    private String cpfCandidato;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpfCandidato() {
        return cpfCandidato;
    }

    public void setCpfCandidato(String cpfCandidato) {
        this.cpfCandidato = cpfCandidato;
    }
}

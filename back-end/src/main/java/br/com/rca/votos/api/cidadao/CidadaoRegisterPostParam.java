package br.com.rca.votos.api.cidadao;

import javax.validation.constraints.NotNull;

public class CidadaoRegisterPostParam {
    @NotNull
    private String cpf;
    @NotNull
    private String password;
    @NotNull
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package br.com.rca.votos.domain.cargo;

import java.util.Objects;

public class Cargo {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(nome, cargo.nome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Cargo{" +
            "nome='" + nome + '\'' +
            '}';
    }
}

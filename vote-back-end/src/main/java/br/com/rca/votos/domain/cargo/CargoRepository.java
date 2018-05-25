package br.com.rca.votos.domain.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class CargoRepository {
    private List<Cargo> cargos;

    @Autowired
    public CargoRepository() {
        cargos = new LinkedList<>();
        cargos.add(novoCargo("presidente"));
    }

    private Cargo novoCargo(String nomeCargo) {
        Cargo cargo = new Cargo();
        cargo.setNome(nomeCargo);
        return cargo;
    }

    public Optional<Cargo> findByNome(String nomeCargo) {
        synchronized (cargos) {
            return cargos.stream().filter(cargo -> cargo.getNome().equals(nomeCargo)).findFirst();
        }
    }
}

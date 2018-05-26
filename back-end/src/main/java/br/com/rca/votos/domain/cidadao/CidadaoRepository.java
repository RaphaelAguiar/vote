package br.com.rca.votos.domain.cidadao;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CidadaoRepository extends Repository<Cidadao, String> {
    Cidadao save(Cidadao cidadao);
    Optional<Cidadao> findByCpf(String cpf);
    List<Cidadao> findByNomeCargoCandidatado(String cargo);
    List<Cidadao> findAll();
}

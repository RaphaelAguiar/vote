package br.com.rca.votos.domain.voto;

import org.springframework.data.repository.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface VotoRepository extends Repository<Voto,String> {
    Voto save(Voto voto);
    long countByCpfVotadoAndNomeCargo(String cpfVotado, String nomeCargo);
    Optional<Voto> findByCpfVotanteAndNomeCargo(String cpfVotante, String nomeCargo);
}

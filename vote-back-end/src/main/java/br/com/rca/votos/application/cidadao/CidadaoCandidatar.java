package br.com.rca.votos.application.cidadao;

import br.com.rca.votos.domain.cargo.CargoRepository;
import br.com.rca.votos.domain.cidadao.Cidadao;
import br.com.rca.votos.domain.cidadao.CidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadaoCandidatar {

    @Autowired
    private CidadaoRepository cidadaoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    public void candidatar(String cpf, String cargo) {
        final Cidadao cidadao = cidadaoRepository
            .findByCpf(cpf)
            .orElseThrow(() -> new IllegalArgumentException("Cidadão não encontrado!"));
        cargoRepository
            .findByNome(cargo)
            .orElseThrow(() -> new IllegalArgumentException("Cargo não encontrado!"));

        cidadao.setNomeCargoCandidatado(cargo);
        cidadaoRepository.save(cidadao);
    }
}

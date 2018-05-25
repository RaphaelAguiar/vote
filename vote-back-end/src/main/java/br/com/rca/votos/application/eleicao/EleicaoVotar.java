package br.com.rca.votos.application.eleicao;

import br.com.rca.votos.domain.cargo.CargoRepository;
import br.com.rca.votos.domain.cidadao.CidadaoRepository;
import br.com.rca.votos.domain.voto.Voto;
import br.com.rca.votos.domain.voto.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleicaoVotar {
    private final CidadaoRepository cidadaoRepository;
    private final CargoRepository cargoRepository;
    private final VotoRepository votoRepository;

    @Autowired
    public EleicaoVotar(CidadaoRepository cidadaoRepository,
                        CargoRepository cargoRepository,
                        VotoRepository votoRepository) {
        this.cidadaoRepository = cidadaoRepository;
        this.cargoRepository = cargoRepository;
        this.votoRepository = votoRepository;
    }

    public void votar(String cpfVotante, String cpfVotado, String nomeCargo) {
        cidadaoRepository.findByCpf(cpfVotante)
            .orElseThrow(() -> new IllegalArgumentException("Cidadão inválido!"));

        cidadaoRepository.findByCpf(cpfVotado)
            .orElseThrow(() -> new IllegalArgumentException("Cidadão inválido!"));

        cargoRepository.findByNome(nomeCargo)
            .orElseThrow(() -> new IllegalArgumentException("Cargo inválido!"));

        Voto voto = new Voto();
        voto.setNomeCargo(nomeCargo);
        voto.setCpfVotado(cpfVotado);
        voto.setCpfVotante(cpfVotante);
        votoRepository.save(voto);
    }
}

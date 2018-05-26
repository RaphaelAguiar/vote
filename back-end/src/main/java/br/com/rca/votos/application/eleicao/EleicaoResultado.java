package br.com.rca.votos.application.eleicao;

import br.com.rca.votos.domain.cidadao.CidadaoRepository;
import br.com.rca.votos.domain.eleicao.Contagem;
import br.com.rca.votos.domain.eleicao.Resultado;
import br.com.rca.votos.domain.voto.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EleicaoResultado {
    private final VotoRepository votoRepository;
    private final CidadaoRepository cidadaoRepository;

    @Autowired
    public EleicaoResultado(VotoRepository votoRepository, CidadaoRepository cidadaoRepository) {
        this.votoRepository = votoRepository;
        this.cidadaoRepository = cidadaoRepository;
    }

    public Resultado paraCargo(String nomeCargo) {
        final Resultado resultado = new Resultado();
        resultado.setContagem(
            cidadaoRepository
                .findByNomeCargoCandidatado(nomeCargo)
                .stream()
                .map(cidadao -> {
                    final long votos = votoRepository.countByCpfVotadoAndNomeCargo(cidadao.getCpf(),nomeCargo);
                    final Contagem contagem = new Contagem();
                    contagem.setCpfCandidato(cidadao.getCpf());
                    contagem.setVotos(votos);
                    return contagem;
                })
                .collect(Collectors.toList())
        );
        return resultado;
    }
}

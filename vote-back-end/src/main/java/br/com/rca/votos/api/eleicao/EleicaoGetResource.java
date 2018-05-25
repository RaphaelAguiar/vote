package br.com.rca.votos.api.eleicao;

import br.com.rca.votos.application.eleicao.EleicaoResultado;
import br.com.rca.votos.domain.eleicao.Contagem;
import br.com.rca.votos.domain.eleicao.Resultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EleicaoGetResource {
    private final EleicaoResultado eleicaoResultado;

    @Autowired
    public EleicaoGetResource(EleicaoResultado eleicaoResultado) {
        this.eleicaoResultado = eleicaoResultado;
    }

    @GetMapping("/api/eleicao/{nomeCargo}")
    public Resultado get(@PathVariable String nomeCargo) {
        return eleicaoResultado.paraCargo(nomeCargo);
    }
}

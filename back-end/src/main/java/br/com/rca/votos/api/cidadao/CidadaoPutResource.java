package br.com.rca.votos.api.cidadao;

import br.com.rca.votos.application.cidadao.CidadaoCandidatar;
import br.com.rca.votos.application.eleicao.EleicaoVotar;
import br.com.rca.votos.security.LogginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CidadaoPutResource {

    private final CidadaoCandidatar cidadaoCandidatar;
    private final LogginService logginService;

    @Autowired
    public CidadaoPutResource(CidadaoCandidatar cidadaoCandidatar, LogginService logginService) {
        this.cidadaoCandidatar = cidadaoCandidatar;
        this.logginService = logginService;
    }

    @PutMapping("/api/cidadao")
    public void put(@RequestBody CidadaoPutParam cidadaoPutParam) {
        if (cidadaoPutParam.getCargo() != null)
            cidadaoCandidatar.candidatar(
                logginService.getUser().getCpf(),
                cidadaoPutParam.getCargo()
            );
    }
}

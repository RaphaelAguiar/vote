package br.com.rca.votos.api.eleicao;

import br.com.rca.votos.application.eleicao.EleicaoVotar;
import br.com.rca.votos.security.LogginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EleicaoPostResource {
    @Autowired
    private EleicaoVotar eleicaoVotar;

    @Autowired
    private LogginService logginService;

    //TODO criptografar
    @PostMapping("/api/eleicao")
    public void post(@Valid @RequestBody EleicaoPostDto eleicaoPostDto) {
        eleicaoVotar.votar(
            logginService.getUser().getCpf(),
            eleicaoPostDto.getCpfCandidato(),
            eleicaoPostDto.getCargo()
        );
    }
}

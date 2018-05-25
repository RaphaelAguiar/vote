package br.com.rca.votos.security;

import br.com.rca.votos.domain.cidadao.Cidadao;
import br.com.rca.votos.domain.cidadao.CidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LogginService {
    private final CidadaoRepository cidadaoRepository;

    @Autowired
    public LogginService(CidadaoRepository cidadaoRepository) {
        this.cidadaoRepository = cidadaoRepository;
    }

    public Cidadao getUser() {
        final String cpf = (String) SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getPrincipal();

        return cidadaoRepository.findByCpf(cpf).get();
    }
}

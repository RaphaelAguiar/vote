package br.com.rca.votos.application.cidadao;

import br.com.rca.votos.domain.cidadao.Cidadao;
import br.com.rca.votos.domain.cidadao.CidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CidadaoNovo {
    @Autowired
    private CidadaoRepository cidadaoRepository;

    public Cidadao novo(String cpf, String nome, String senha) {
        //TODO verificar CPF Válido
        //TODO verificar senha valida

        cidadaoRepository
            .findByCpf(cpf)
            .ifPresent(c -> {
                throw new IllegalArgumentException("Cpf já cadastrado existe!");
            });
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Cidadao cidadao = new Cidadao();
        cidadao.setCpf(cpf);
        cidadao.setNome(nome);
        cidadao.setPassword(passwordEncoder.encode(senha));
        return cidadaoRepository.save(cidadao);
    }
}

package br.com.rca.votos.api.cidadao;

import br.com.rca.votos.domain.cidadao.Cidadao;
import br.com.rca.votos.domain.cidadao.CidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CidadaoGetResource {
    @Autowired
    private CidadaoRepository cidadaoRepository;

    @GetMapping("/api/cidadao/{cpf}")
    public CidadaoGetReturn get(@PathVariable String cpf) {
        Cidadao cidadao = cidadaoRepository.findByCpf(cpf)
            .orElseThrow(() -> new IllegalArgumentException("Cidadão não encontrado!"));

        return cast(cidadao);
    }

    @GetMapping("/api/cidadao")
    public List<CidadaoGetReturn> getFilted(@RequestParam(required = false) String cargo) {
        if(cargo!=null)
            return cast(cidadaoRepository.findByNomeCargoCandidatado(cargo));
        return cast(cidadaoRepository.findAll());
    }

    private List<CidadaoGetReturn> cast(List<Cidadao> cidadaos) {
        return cidadaos.stream().map(cidadao -> cast(cidadao)).collect(Collectors.toList());
    }

    private CidadaoGetReturn cast(Cidadao cidadao) {
        CidadaoGetReturn cidadaoGetReturn = new CidadaoGetReturn();
        cidadaoGetReturn.setCpf(cidadao.getCpf());
        cidadaoGetReturn.setNome(cidadao.getNome());
        cidadaoGetReturn.setNomeCargoCandidatado(cidadao.getNomeCargoCandidatado());
        return cidadaoGetReturn;
    }
}

package br.com.rca.votos.security;

import br.com.rca.votos.domain.cidadao.CidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
  @Autowired
  private CidadaoRepository cidadaoRepository;

  @Override
  public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
    try {
      return cidadaoRepository.findByCpf(cpf)
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
    }catch(Exception e){
      e.printStackTrace(); //TODO Log Info
      throw e;
    }
  }
}

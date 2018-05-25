package br.com.rca.votos.security;

import br.com.rca.votos.domain.cidadao.Cidadao;
import br.com.rca.votos.domain.cidadao.CidadaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {


    protected JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException, IOException {

        Cidadao credentials = new ObjectMapper()
            .readValue(request.getInputStream(), Cidadao.class);

        return getAuthenticationManager().authenticate(
            new UsernamePasswordAuthenticationToken(
                credentials.getCpf(),
                credentials.getPassword(),
                Collections.emptyList()
            ));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain filterChain,
                                            Authentication auth) {
        String cpf = auth.getName();
        JWTTokenService.addAuthentication(response, cpf);
        response.addHeader("userCpf",cpf);
    }

}
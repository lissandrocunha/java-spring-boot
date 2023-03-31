package dev.lissandrocunha.api.controller;

import dev.lissandrocunha.api.domain.usuario.DadosAutenticacao;
import dev.lissandrocunha.api.domain.usuario.Usuario;
import dev.lissandrocunha.api.infra.security.DadosTokenJWT;
import dev.lissandrocunha.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> login(
        @RequestBody @Valid DadosAutenticacao dados
    ){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity
                .ok(new DadosTokenJWT(tokenJWT));
    }
}

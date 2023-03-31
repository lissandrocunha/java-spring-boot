package dev.lissandrocunha.api.controller;

import dev.lissandrocunha.api.domain.usuario.DadosAutenticacao;
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

    @PostMapping
    public ResponseEntity<Void> login(
        @RequestBody @Valid DadosAutenticacao dados
    ){
        var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var authentication = authenticationManager.authenticate(token);

        return ResponseEntity
                .ok()
                .build();
    }
}

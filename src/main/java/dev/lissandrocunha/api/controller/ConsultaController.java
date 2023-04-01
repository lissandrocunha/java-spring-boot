package dev.lissandrocunha.api.controller;

import dev.lissandrocunha.api.domain.consulta.DadosAgendamentoConsulta;
import dev.lissandrocunha.api.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsulta> agendar(
        @RequestBody @Valid DadosAgendamentoConsulta dados
    ){
        System.out.println(dados);
        return ResponseEntity
                .ok(
                        new DadosDetalhamentoConsulta(null, null, null, null)
                );
    }
}

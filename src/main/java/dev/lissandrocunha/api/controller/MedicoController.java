package dev.lissandrocunha.api.controller;

import dev.lissandrocunha.api.medico.DadosCadastroMedico;
import dev.lissandrocunha.api.medico.Medico;
import dev.lissandrocunha.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")

public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(
            @RequestBody @Valid DadosCadastroMedico dados
    ){
        medicoRepository.save(new Medico(dados));
    }

}

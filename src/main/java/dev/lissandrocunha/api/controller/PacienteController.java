package dev.lissandrocunha.api.controller;

import dev.lissandrocunha.api.paciente.DadosCadastroPaciente;
import dev.lissandrocunha.api.paciente.Paciente;
import dev.lissandrocunha.api.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(
            @RequestBody @Valid DadosCadastroPaciente dados
    ){
        pacienteRepository.save(new Paciente(dados));
    }
}

package dev.lissandrocunha.api.controller;

import dev.lissandrocunha.api.medico.DadosCadastroMedico;
import dev.lissandrocunha.api.medico.DadosListagemMedico;
import dev.lissandrocunha.api.medico.Medico;
import dev.lissandrocunha.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicos")

public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(
            @RequestBody @Valid DadosCadastroMedico dados
    ) {
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(
           @PageableDefault(size = 10, page = 0) Pageable paginacao
    ) {
        return medicoRepository
                .findAll(paginacao)
                .map(DadosListagemMedico::new);
    }

}

package dev.lissandrocunha.api.controller;

import dev.lissandrocunha.api.medico.DadosListagemMedico;
import dev.lissandrocunha.api.paciente.DadosAtualizacaoPaciente;
import dev.lissandrocunha.api.paciente.DadosCadastroPaciente;
import dev.lissandrocunha.api.paciente.DadosListagemPaciente;
import dev.lissandrocunha.api.paciente.Paciente;
import dev.lissandrocunha.api.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public Page<DadosListagemPaciente> listar(
            @PageableDefault(page = 0, size = 10, sort = { "nome" }) Pageable paginacao
    ) {
        return pacienteRepository
                .findAllByAtivoTrue(paginacao)
                .map(DadosListagemPaciente::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(
            @RequestBody @Valid DadosCadastroPaciente dados
    ){
        pacienteRepository.save(new Paciente(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.inativar();
    }


}

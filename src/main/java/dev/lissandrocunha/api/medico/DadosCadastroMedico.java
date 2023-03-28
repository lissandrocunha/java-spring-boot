package dev.lissandrocunha.api.medico;

import dev.lissandrocunha.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}

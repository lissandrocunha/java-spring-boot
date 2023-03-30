package dev.lissandrocunha.api.domain.medico;

import dev.lissandrocunha.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,

        String nome,


        String telefone,

        DadosEndereco endereco
) {
}

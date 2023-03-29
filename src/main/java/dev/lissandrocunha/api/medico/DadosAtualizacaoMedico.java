package dev.lissandrocunha.api.medico;

import dev.lissandrocunha.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,

        String nome,


        String telefone,

        DadosEndereco endereco
) {
}

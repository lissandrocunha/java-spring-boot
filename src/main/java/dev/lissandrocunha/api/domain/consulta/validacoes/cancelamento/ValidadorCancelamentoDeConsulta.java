package dev.lissandrocunha.api.domain.consulta.validacoes.cancelamento;

import dev.lissandrocunha.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);
}

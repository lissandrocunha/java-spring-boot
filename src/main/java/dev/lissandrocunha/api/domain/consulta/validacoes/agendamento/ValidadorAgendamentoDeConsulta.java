package dev.lissandrocunha.api.domain.consulta.validacoes.agendamento;

import dev.lissandrocunha.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados);
}

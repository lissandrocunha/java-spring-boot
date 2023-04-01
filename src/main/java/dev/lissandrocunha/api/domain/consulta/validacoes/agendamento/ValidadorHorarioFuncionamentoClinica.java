package dev.lissandrocunha.api.domain.consulta.validacoes.agendamento;

import dev.lissandrocunha.api.domain.BusinessException;
import dev.lissandrocunha.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new BusinessException("Consulta fora do horário de funcionamento da clínica");
        }

    }
}

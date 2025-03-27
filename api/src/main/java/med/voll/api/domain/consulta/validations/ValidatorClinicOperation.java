package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidatorClinicOperation implements ValidatorAppointmentService {
    public void validate(DadosAgendamentoConsulta data) {
        var dataConsulta = data.data();

        var sunday = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeOpen = dataConsulta.getHour() < 7;
        var afterCosed = dataConsulta.getHour() > 18;

        if (sunday || beforeOpen || afterCosed) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}

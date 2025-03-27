package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidatorAntecedence implements ValidatorAppointmentService {
    public void validate(DadosAgendamentoConsulta data) {
        var dataConsulta = data.data();
        var now = LocalDateTime.now();

        var antecedenceMinutes = Duration.between(now, dataConsulta).toMinutes();

        if(antecedenceMinutes < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }
    }
}

package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorPatientWithExistingService implements ValidatorAppointmentService {
    @Autowired
    private ConsultaRepository repository;

    public void validate(DadosAgendamentoConsulta data) {
        var firstTime = data.data().withHour(7);
        var lastTime = data.data().withHour(18);

        var hasPatientAnotherServiceAtTheSameDay = repository.existsByPacienteIdAndDataBetween(data.idMedico(), firstTime, lastTime);
        if (hasPatientAnotherServiceAtTheSameDay) {
            throw new ValidacaoException("Paciente já possui atendimento para esse dia");
        }

    }
}

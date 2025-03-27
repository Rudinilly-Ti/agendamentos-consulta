package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorMedicWithExistingService implements ValidatorAppointmentService {
    @Autowired
    private ConsultaRepository repository;

    public void validate(DadosAgendamentoConsulta data) {
        var hasMedicAnotherServiceAtTheSameTime = repository.existsByMedicoIdAndData(data.idMedico(), data.data());
        if (hasMedicAnotherServiceAtTheSameTime) {
            throw new ValidacaoException("Médico já possui atendimento nesse mesmo horário");
        }

    }
}

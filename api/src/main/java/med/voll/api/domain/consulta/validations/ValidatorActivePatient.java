package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorActivePatient implements ValidatorAppointmentService {
    @Autowired
    private PacienteRepository repository;

    public void validate(DadosAgendamentoConsulta data) {
        var isPatientActive = repository.findAtivoById(data.idMedico());
        if (!isPatientActive) {
            throw new ValidacaoException("Consulta não pode ser agendada para um paciente não ativo");
        }

    }
}

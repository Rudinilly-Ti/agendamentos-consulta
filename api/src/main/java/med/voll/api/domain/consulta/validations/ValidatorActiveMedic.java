package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorActiveMedic implements ValidatorAppointmentService {

    @Autowired
    private MedicoRepository repository;

    public void validate(DadosAgendamentoConsulta data) {
        if(data.idMedico() == null) {
            return;
        }

        var isMedicActive = repository.findAtivoById(data.idMedico());
        if (!isMedicActive) {
            throw new ValidacaoException("Consulta não pode ser agendada com um medico não ativo");
        }

    }
}

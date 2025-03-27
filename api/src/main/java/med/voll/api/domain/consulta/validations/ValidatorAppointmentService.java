package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidatorAppointmentService {
    void validate(DadosAgendamentoConsulta data);
}

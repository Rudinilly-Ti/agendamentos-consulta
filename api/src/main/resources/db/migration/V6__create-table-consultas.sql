CREATE TABLE consultas (
    id BIGSERIAL NOT NULL,
    medico_id INTEGER NOT NULL,
    paciente_id INTEGER NOT NULL,
    data TIMESTAMP WITH TIME ZONE not null,

    PRIMARY KEY (id),
    constraint fk_consultas_medico_id foreign key(medico_id) references medicos(id),
    constraint fk_consultas_paciente_id foreign key(paciente_id) references pacientes(id)
);
package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }
    @GetMapping
    public ResponseEntity<PagedModel<DadosListagemMedico>> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = new PagedModel<>(repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new));

        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAtualizarMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarDados(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.delete(medico);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}

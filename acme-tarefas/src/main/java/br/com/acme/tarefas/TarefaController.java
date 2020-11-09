package br.com.acme.tarefas;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {
	
	
	private final TarefaService tarefaService;
	private final TarefaAssembler tarefaAssembler;
	
	
	/**
     * {@code GET  /tarefas} : get all the tarefas.
     *
     * @param search the search which the requested entities should match.
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tarefas in body.
     */
	@GetMapping
    public Page<TarefaResponse> search(@RequestBody TarefaFilter search, @PageableDefault(sort = "id") Pageable pageable) {
		return tarefaService.findAll(search, pageable).map(tarefaAssembler::toResponse);
    }
	
	
	/**
     * {@code POST  /tarefas} : Create a new tarefa.
     *
     * @param pessoaDTO the tarefaRequest to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tarefaResponse, or with status {@code 400 (Bad Request)} if the tarefa has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping
    public ResponseEntity<TarefaResponse> create(@RequestBody TarefaRequest tarefaRequest) throws URISyntaxException {
        TarefaResponse result = tarefaService.save(tarefaRequest);
        return ResponseEntity.created(new URI("/tarefas/" + result.getId()))
            .body(result);
    }
	
    
    /**
     * {@code PUT  /tarefas} : Updates an existing tarefa.
     *
     * @param tarefaRequest the tarefaRequest to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tarefaResponse,
     * or with status {@code 400 (Bad Request)} if the pessoaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tarefaResponse couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping
    public ResponseEntity<TarefaResponse> update(@RequestBody TarefaRequest tarefaRequest) throws URISyntaxException {
    	TarefaResponse result = tarefaService.save(tarefaRequest);
        return ResponseEntity.ok()
            .body(result);
    }
    
    /**
     * {@code DELETE  /tarefas/:id} : delete the "id" tarefa.
     *
     * @param id the id of the tarefaResponse to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

}

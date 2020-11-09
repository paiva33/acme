package br.com.acme.tarefas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {

	private final TarefaAssembler tarefaAssembler;
	private final TarefaRepository tarefaRepository;

	public Page<Tarefa> findAll(TarefaFilter filter, Pageable pageable) {
		return tarefaRepository.findAll(TarefaSpecs.withFilter(filter), pageable);
	}

	public TarefaResponse save(TarefaRequest tarefaRequest) {
		Tarefa tarefa = tarefaAssembler.toEntity(tarefaRequest);
		tarefa = tarefaRepository.save(tarefa);
		return tarefaAssembler.toResponse(tarefa);
	}

	public void delete(Long id) {
		tarefaRepository.deleteById(id);
	}
}

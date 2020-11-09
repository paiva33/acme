package br.com.acme.tarefas;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TarefaAssembler {

	private final ModelMapper modelMapper;

	public TarefaResponse toResponse(Tarefa tarefa) {
		return modelMapper.map(tarefa, TarefaResponse.class);
	}

	public Tarefa toEntity(TarefaRequest tarefaRequest) {
		return modelMapper.map(tarefaRequest, Tarefa.class);
	}

	public TarefaRequest toRequest(Tarefa tarefa) {
		return modelMapper.map(tarefa, TarefaRequest.class);
	}

	public void copyToEntiy(TarefaRequest tarefaRequest, Tarefa tarefa) {
		modelMapper.map(tarefaRequest, tarefa);
	}

}

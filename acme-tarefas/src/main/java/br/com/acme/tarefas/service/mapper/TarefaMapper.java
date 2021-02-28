package br.com.acme.tarefas.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.acme.tarefas.model.Tarefa;
import br.com.acme.tarefas.service.to.TarefaEntradaTO;
import br.com.acme.tarefas.service.to.TarefaSaidaTO;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author paiva
 *
 */
@Component
@RequiredArgsConstructor
public class TarefaMapper {
	
	private final ModelMapper modelMapper;
	
	
	public TarefaSaidaTO toOutput(Tarefa tarefa) {
		return modelMapper.map(tarefa, TarefaSaidaTO.class);
	}
	
	public Tarefa toEntity(TarefaEntradaTO entrada) {
		return modelMapper.map(entrada, Tarefa.class);
	}
	
	public TarefaEntradaTO toInput(Tarefa tarefa) {
		return modelMapper.map(tarefa, TarefaEntradaTO.class);
	}
	
	public void copyToEntity(TarefaEntradaTO entrada, Tarefa tarefa) {
		modelMapper.map(entrada, tarefa);
	}
}

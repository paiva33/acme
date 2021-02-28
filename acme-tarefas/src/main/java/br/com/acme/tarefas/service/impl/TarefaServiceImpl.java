package br.com.acme.tarefas.service.impl;

import org.springframework.stereotype.Service;

import br.com.acme.tarefas.repository.TarefaRepository;
import br.com.acme.tarefas.service.TarefaService;
import br.com.acme.tarefas.service.exceptions.ResourceNotFoundException;
import br.com.acme.tarefas.service.mapper.TarefaMapper;
import br.com.acme.tarefas.service.to.TarefaEntradaTO;
import br.com.acme.tarefas.service.to.TarefaSaidaTO;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author paiva
 *
 */
@Service
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {

	private final TarefaRepository repository;
	
	private final TarefaMapper mapper;

	@Override
	public TarefaSaidaTO salvar(TarefaEntradaTO entrada) {
		
		var entity = mapper.toEntity(entrada);
		
		entity = repository.save(entity);
		
		return mapper.toOutput(entity);
		
	}
	

	@Override
	public void excluir(Long id) {
		
		var tarefa = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
		
		repository.delete(tarefa);
		
	}

	@Override
	public TarefaSaidaTO atualizar(TarefaEntradaTO entrada) {
		
		var entity = repository.findById(entrada.getKey()).orElseThrow(() -> new ResourceNotFoundException(""));
		
		entity = repository.save(entity);
		
		return mapper.toOutput(entity);
	}

}

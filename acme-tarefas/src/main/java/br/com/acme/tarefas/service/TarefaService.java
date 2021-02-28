package br.com.acme.tarefas.service;

import br.com.acme.tarefas.service.to.TarefaEntradaTO;
import br.com.acme.tarefas.service.to.TarefaSaidaTO;

/**
 * 
 * @author paiva
 *
 */
public interface TarefaService {
	
	
	/**
	 * 
	 * @param tarefaDTO
	 * @return
	 */
	TarefaSaidaTO salvar(TarefaEntradaTO entrada);
	
	/**
	 * 
	 * @param id
	 */
	void excluir(Long id);
	
	/**
	 * 
	 * @param entrada
	 * @return
	 */
	TarefaSaidaTO atualizar(TarefaEntradaTO entrada);
}

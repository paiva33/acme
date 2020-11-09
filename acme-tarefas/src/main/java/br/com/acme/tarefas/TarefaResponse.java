package br.com.acme.tarefas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaResponse {

	private Long id;
	private String descricao;
}

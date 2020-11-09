package br.com.acme.tarefas;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
	
	@Id
	private Long id;
	private String descricao;
	private String titulo;
}

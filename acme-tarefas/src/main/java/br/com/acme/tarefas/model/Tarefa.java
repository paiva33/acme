package br.com.acme.tarefas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Tarefa {
	
	@Id
	private Long id;
}

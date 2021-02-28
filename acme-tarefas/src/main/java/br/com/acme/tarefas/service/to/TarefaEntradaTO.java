package br.com.acme.tarefas.service.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonPropertyOrder({ "id" })
public class TarefaEntradaTO {
	
	@JsonProperty("id")
	private Long key;

}

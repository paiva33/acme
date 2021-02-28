package br.com.acme.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acme.tarefas.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}

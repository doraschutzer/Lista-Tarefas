package br.edu.ifsp.arq.dw2s6.lista_tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.dw2s6.lista_tarefas.domain.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}

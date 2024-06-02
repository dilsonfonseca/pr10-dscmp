package br.com.projeto.integrado.repository;

import br.com.projeto.integrado.entity.StatusTarefa;
import br.com.projeto.integrado.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    Optional<Tarefa> findByStatusTarefa(StatusTarefa statusTarefa);
}
package br.com.projeto.integrado.repository;

import br.com.projeto.integrado.entity.StatusTarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTarefaRepository extends JpaRepository<StatusTarefa, Integer> {

}
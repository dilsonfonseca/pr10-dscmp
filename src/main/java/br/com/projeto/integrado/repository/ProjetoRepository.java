package br.com.projeto.integrado.repository;


import br.com.projeto.integrado.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    Optional<Projeto> findByProjetoDescricao(String projetoDescricao);
}
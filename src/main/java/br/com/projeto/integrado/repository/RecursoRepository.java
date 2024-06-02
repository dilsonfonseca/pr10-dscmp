package br.com.projeto.integrado.repository;

import br.com.projeto.integrado.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
    Optional<Recurso> findByRecursoNome(String recursoNome);
}
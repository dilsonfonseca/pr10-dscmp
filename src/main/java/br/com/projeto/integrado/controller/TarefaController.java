package br.com.projeto.integrado.controller;


import br.com.projeto.integrado.entity.StatusTarefa;
import br.com.projeto.integrado.entity.Tarefa;
import br.com.projeto.integrado.service.TarefaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@Tag(name = "Tarefas")
public class TarefaController {
    @Autowired
    TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> getAll(){
        List<Tarefa> tarefas = tarefaService.getAll();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getById(@PathVariable Integer id) {
        Tarefa tarefa = tarefaService.getById(id);
        if(tarefa != null)
            return new ResponseEntity<>(tarefa, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Busca pelo status da tarefa
    @GetMapping("/status/{status}")
    public ResponseEntity<Tarefa> getByStatusTarefa(@PathVariable("status") StatusTarefa statusTarefaId) {
        Tarefa tarefa = tarefaService.getByStatusTarefa(statusTarefaId);
        if(tarefa != null)
            return new ResponseEntity<>(tarefa, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefa) {
        return new ResponseEntity<>(tarefaService.saveTarefa(tarefa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Integer id, @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.updateTarefa(id, tarefa);
        if(tarefaAtualizada != null)
            return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTarefa(@PathVariable Integer id) {
        if(tarefaService.deleteTarefa(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
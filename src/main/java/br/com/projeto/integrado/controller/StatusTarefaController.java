package br.com.projeto.integrado.controller;


import br.com.projeto.integrado.entity.StatusTarefa;
import br.com.projeto.integrado.service.StatusTarefaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statusTarefa")
@Tag(name = "StatusTarefas")
public class StatusTarefaController {
    @Autowired
    StatusTarefaService statusTarefaService;

    @GetMapping
    public ResponseEntity<List<StatusTarefa>> getAll(){
        List<StatusTarefa> statusTarefas = statusTarefaService.getAll();
        return ResponseEntity.ok(statusTarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusTarefa> getById(@PathVariable Integer id) {
        StatusTarefa statusTarefa = statusTarefaService.getById(id);
        if(statusTarefa != null)
            return new ResponseEntity<>(statusTarefa, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<StatusTarefa> saveStatusTarefa(@RequestBody StatusTarefa statusTarefa) {
        return new ResponseEntity<>(statusTarefaService.saveStatusTarefa(statusTarefa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusTarefa> updateStatusTarefa(@PathVariable Integer id, @RequestBody StatusTarefa statusTarefa) {
        StatusTarefa statusTarefaAtualizada = statusTarefaService.updateStatusTarefa(id, statusTarefa);
        if(statusTarefaAtualizada != null)
            return new ResponseEntity<>(statusTarefaAtualizada, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStatusTarefa(@PathVariable Integer id) {
        if(statusTarefaService.deleteStatusTarefa(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
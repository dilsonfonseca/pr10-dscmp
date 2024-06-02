package br.com.projeto.integrado.controller;

import br.com.projeto.integrado.entity.Recurso;
import br.com.projeto.integrado.service.RecursoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurso")
@Tag(name = "Recursos")
public class RecursoController {
    @Autowired
    RecursoService recursoService;

    @GetMapping
    public ResponseEntity<List<Recurso>> getAll(){
        List<Recurso> recursos = recursoService.getAll();
        return ResponseEntity.ok(recursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> getById(@PathVariable Integer id) {
        Recurso recurso = recursoService.getById(id);
        if(recurso != null)
            return new ResponseEntity<>(recurso, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Pegando recurso pelo nome
    @GetMapping("/{recursoNome}")
    public ResponseEntity<Recurso> getById(@PathVariable("recursoNome") String nome) {
        Recurso recurso = recursoService.getByRecursoNome(nome);
        if(recurso != null)
            return new ResponseEntity<>(recurso, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Recurso> saveRecurso(@RequestBody Recurso recurso) {
        return new ResponseEntity<>(recursoService.saveRecurso(recurso), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> updateRecurso(@PathVariable Integer id, @RequestBody Recurso recurso) {
        Recurso recursoAtualizada = recursoService.updateRecurso(id, recurso);
        if(recursoAtualizada != null)
            return new ResponseEntity<>(recursoAtualizada, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecurso(@PathVariable Integer id) {
        if(recursoService.deleteRecurso(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
package com.tenway.start.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tenway.start.model.Laboratorio;
import com.tenway.start.repository.LaboratoriosRepository;

import java.util.Optional;

@RestController
@RequestMapping("/laboratorios")
public class LaboratoriosController {

  private final LaboratoriosRepository repository;

  public LaboratoriosController(LaboratoriosRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Iterable<Laboratorio> findAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Laboratorio> obterLaboratorioPorId(@PathVariable Integer id) {
    Optional<Laboratorio> laboratorioOptional = repository.findById(id);
    return laboratorioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Endpoint para criar um novo laboratório
  @PostMapping
  public ResponseEntity<Laboratorio> criarLaboratorio(@RequestBody Laboratorio laboratorio) {
    Laboratorio novoLaboratorio = repository.save(laboratorio);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoLaboratorio);
  }

  // Endpoint para atualizar um laboratório existente
  @PutMapping("/{id}")
  public ResponseEntity<Laboratorio> atualizarLaboratorio(@PathVariable Integer id, @RequestBody Laboratorio laboratorioAtualizado) {
    Optional<Laboratorio> laboratorioOptional = repository.findById(id);
    if (laboratorioOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Laboratorio laboratorioExistente = laboratorioOptional.get();
    laboratorioExistente = new Laboratorio(id, laboratorioAtualizado.nome(), laboratorioAtualizado.status());

    Laboratorio laboratorioSalvo = repository.save(laboratorioExistente);
    return ResponseEntity.ok(laboratorioSalvo);
  }

  // Endpoint para deletar um laboratório
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarLaboratorio(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}

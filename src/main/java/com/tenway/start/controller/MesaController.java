package com.tenway.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.tenway.start.model.Mesa;
import com.tenway.start.repository.MesasRepository;

import java.util.Optional;

@RestController
@RequestMapping("/mesas")
public class MesaController {

  private final MesasRepository repository;
@Autowired
  public MesaController(MesasRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Iterable<Mesa> findAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Mesa> obterMesaPorId(@PathVariable Integer id) {
    Optional<Mesa> mesaOptional = repository.findById(id);
    return mesaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Mesa> criarMesa(@RequestBody Mesa mesa) {
    Mesa novaMesa = repository.save(mesa);
    return ResponseEntity.status(HttpStatus.CREATED).body(novaMesa);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Mesa> atualizarMesa(@PathVariable Integer id, @RequestBody Mesa mesa) {
    Optional<Mesa> mesaOptional = repository.findById(id);
    if (mesaOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Mesa mesaExistente = mesaOptional.get();
    Mesa mesaAtualizado = new Mesa(id, mesa.nome(), mesa.status(), mesa.id_laboratorio());

    Mesa mesaSalvo = repository.save(mesaAtualizado);
    return ResponseEntity.ok(mesaAtualizado);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarMesa(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}

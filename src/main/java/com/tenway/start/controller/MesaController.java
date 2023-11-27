package com.tenway.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.tenway.start.model.Mesa;
import com.tenway.start.repository.MesasRepository;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mesa")
public class MesaController {

  private final MesasRepository repository;

  @Autowired
  public MesaController(MesasRepository repository) {
    this.repository = repository;
  }

  // Endpoint para obter todos os agendamentos
  @GetMapping
  public Iterable<Mesa> findAll() {
    return repository.findAll();
  }

  // Endpoint para obter um agendamento por id
  @GetMapping("/{id}")
  public ResponseEntity<Mesa> obterMesaPorId(@PathVariable Integer id) {
    Optional<Mesa> mesaOptional = repository.findById(id);
    return mesaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Endpoint para criar um novo agendamento
  @PostMapping
  public ResponseEntity<Mesa> criarMesa(@RequestBody Mesa mesa) {
    Mesa novaMesa = repository.save(mesa);
    return ResponseEntity.status(HttpStatus.CREATED).body(novaMesa);
  }

  // Endpoint para atualizar um agendamento existente
  @PutMapping("/{id}")
  public ResponseEntity<Mesa> atualizarMesa(@PathVariable Integer id, @RequestBody Mesa mesa) {
    Optional<Mesa> mesaOptional = repository.findById(id);
    if (mesaOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Mesa mesaAtualizado = new Mesa(id, mesa.nome(), mesa.status(), mesa.idLaboratorio());

    Mesa mesaSalvo = repository.save(mesaAtualizado);
    return ResponseEntity.ok(mesaSalvo);
  }

}

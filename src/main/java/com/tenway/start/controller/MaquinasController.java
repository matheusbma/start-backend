package com.tenway.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tenway.start.model.Maquina;
import com.tenway.start.repository.MaquinasRepository;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/maquina")
public class MaquinasController {

  private final MaquinasRepository repository;

  @Autowired
  public MaquinasController(MaquinasRepository repository) {
    this.repository = repository;
  }

  // Endpoint para obter todos os agendamentos
  @GetMapping
  public Iterable<Maquina> findAll() {
    return repository.findAll();
  }

  // Endpoint para obter um agendamento por id
  @GetMapping("/{id}")
  public ResponseEntity<Maquina> obterMaquinaPorId(@PathVariable Integer id) {
    Optional<Maquina> maquinaOptional = repository.findById(id);
    return maquinaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Endpoint para criar um novo agendamento
  @PostMapping
  public ResponseEntity<Maquina> criarMaquina(@RequestBody Maquina maquina) {
    Maquina novaMaquina = repository.save(maquina);
    return ResponseEntity.status(HttpStatus.CREATED).body(novaMaquina);
  }

  // Endpoint para atualizar um agendamento existente
  @PutMapping("/{id}")
  public ResponseEntity<Maquina> atualizarMaquina(@PathVariable Integer id, @RequestBody Maquina maquinaAtualizada) {
    Optional<Maquina> maquinaOptional = repository.findById(id);
    if (maquinaOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Maquina maquinaExistente = maquinaOptional.get();
    maquinaExistente = new Maquina(id, maquinaAtualizada.nome(), maquinaAtualizada.status(),
        maquinaAtualizada.id_laboratorio());

    Maquina maquinaSalva = repository.save(maquinaExistente);
    return ResponseEntity.ok(maquinaSalva);
  }

}

package com.tenway.start.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tenway.start.model.Agendamento;
import com.tenway.start.repository.AgendamentosRepository;

import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

  private final AgendamentosRepository repository;

  public AgendamentoController(AgendamentosRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Iterable<Agendamento> findAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Agendamento> obterAgendamentoPorId(@PathVariable Integer id) {
    Optional<Agendamento> agendamentoOptional = repository.findById(id);
    return agendamentoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
    Agendamento novoAgendamento = repository.save(agendamento);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
  }

  // Endpoint para atualizar um agendamento existente
  @PutMapping("/{id}")
  public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Integer id, @RequestBody Agendamento agendamentoAtualizado) {
    Optional<Agendamento> agendamentoOptional = repository.findById(id);
    if (agendamentoOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Agendamento agendamentoExistente = agendamentoOptional.get();
    agendamentoExistente = new Agendamento(id, agendamentoAtualizado.data(), agendamentoAtualizado.hora_inicio(), agendamentoAtualizado.hora_fim(), agendamentoAtualizado.id_usuario(), agendamentoAtualizado.reserva(), agendamentoAtualizado.id_reserva());

    Agendamento agendamentoSalvo = repository.save(agendamentoExistente);
    return ResponseEntity.ok(agendamentoSalvo);
  }

  // Endpoint para deletar um agendamento
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarAgendamento(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}

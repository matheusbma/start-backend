package com.tenway.start.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tenway.start.model.Agendamento;
import com.tenway.start.repository.AgendamentosRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

  private final AgendamentosRepository repository;

  public AgendamentoController(AgendamentosRepository repository) {
    this.repository = repository;
  }

  // Endpoint para obter todos os agendamentos
  @GetMapping
  public Iterable<Agendamento> findAll() {
    return repository.findAll();
  }

  // Endpoint para obter um agendamento por id
  @GetMapping("/{id}")
  public ResponseEntity<Agendamento> obterAgendamentoPorId(@PathVariable Integer id) {
    Optional<Agendamento> agendamentoOptional = repository.findById(id);
    return agendamentoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Endpoint para criar um novo agendamento
  @PostMapping
  public ResponseEntity<?> criarAgendamento(@RequestBody Agendamento agendamento) {
    LocalDate data = agendamento.data();
    LocalTime horaInicio = agendamento.horaInicio();
    LocalTime horaFim = agendamento.horaFim();

    // Verifica se já existe algum agendamento para a mesma data
    Optional<Agendamento> agendamentoExistente = repository.findByDataAndHoraInicioAndHoraFim(data, horaInicio,
        horaFim);
    if (agendamentoExistente.isPresent()) {
      if (horarioConflitante(agendamentoExistente.get(), horaInicio, horaFim)) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Já existe um agendamento para esta data e horário!");
      }
    }

    Agendamento novoAgendamento = repository.save(agendamento);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
  }

  private boolean horarioConflitante(Agendamento agendamentoExistente, LocalTime horaInicioNovo,
      LocalTime horaFimNovo) {
    LocalTime horaInicioExistente = agendamentoExistente.horaInicio();
    LocalTime horaFimExistente = agendamentoExistente.horaFim();

    // Verifica se o novo horário começa ou termina dentro do intervalo de um
    // agendamento existente
    boolean novoComecaNoIntervalo = !horaInicioNovo.isBefore(horaInicioExistente)
        && horaInicioNovo.isBefore(horaFimExistente);
    boolean novoTerminaNoIntervalo = horaFimNovo.isAfter(horaInicioExistente) && !horaFimNovo.isAfter(horaFimExistente);

    // Verifica se o novo horário está completamente dentro do intervalo do
    // agendamento existente
    boolean intervaloCompleto = horaInicioNovo.isBefore(horaInicioExistente) && horaFimNovo.isAfter(horaFimExistente);

    return novoComecaNoIntervalo || novoTerminaNoIntervalo || intervaloCompleto;
  }

  // Endpoint para atualizar um agendamento existente
  @PutMapping("/{id}")
  public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Integer id,
      @RequestBody Agendamento agendamentoAtualizado) {
    Optional<Agendamento> agendamentoOptional = repository.findById(id);
    if (agendamentoOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Agendamento agendamentoExistente = agendamentoOptional.get();
    agendamentoExistente = new Agendamento(id, agendamentoAtualizado.data(), agendamentoAtualizado.horaInicio(),
        agendamentoAtualizado.horaFim(), agendamentoAtualizado.idUsuario(), agendamentoAtualizado.reserva(),
        agendamentoAtualizado.idReserva());

    Agendamento agendamentoSalvo = repository.save(agendamentoExistente);
    return ResponseEntity.ok(agendamentoSalvo);
  }

  // Endpoint para deletar um agendamento
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletarAgendamento(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    return ResponseEntity.ok("Agendamento deletado com sucesso!");
  }

}

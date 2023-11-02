package com.tenway.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenway.start.model.Agendamento;
import com.tenway.start.repository.AgendamentosRepository;

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

}

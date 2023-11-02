package com.tenway.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenway.start.model.Laboratorio;
import com.tenway.start.repository.LaboratoriosRepository;

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
}

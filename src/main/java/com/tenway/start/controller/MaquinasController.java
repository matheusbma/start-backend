package com.tenway.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenway.start.model.Maquina;
import com.tenway.start.repository.MaquinasRepository;

@RestController
@RequestMapping("/maquinas")
public class MaquinasController {

  private final MaquinasRepository repository;

  public MaquinasController(MaquinasRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Iterable<Maquina> findAll() {
    return repository.findAll();
  }
}

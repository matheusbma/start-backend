package com.tenway.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenway.start.model.Mesa;
import com.tenway.start.repository.MesasRepository;

@RestController
@RequestMapping("/mesas")
public class MesaController {

  private final MesasRepository repository;

  public MesaController(MesasRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Iterable<Mesa> findAll() {
    return repository.findAll();
  }

}

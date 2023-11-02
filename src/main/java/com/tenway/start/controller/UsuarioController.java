package com.tenway.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenway.start.model.Usuario;
import com.tenway.start.repository.UsuariosRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  private final UsuariosRepository repository;

  public UsuarioController(UsuariosRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Iterable<Usuario> findAll() {
    return repository.findAll();
  }

}

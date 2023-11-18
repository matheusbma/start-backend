package com.tenway.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tenway.start.model.Usuario;
import com.tenway.start.repository.UsuariosRepository;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  private final UsuariosRepository repository;

  @Autowired
  public UsuarioController(UsuariosRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Iterable<Usuario> findAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable Integer id) {
    Optional<Usuario> usuarioOptional = repository.findById(id);
    return usuarioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
    Usuario novoUsuario = repository.save(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
    Optional<Usuario> usuarioOptional = repository.findById(id);
    if (usuarioOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Usuario usuarioExistente = usuarioOptional.get();
    Usuario usuarioAtualizado = new Usuario(id, usuario.matricula(), usuario.nome(), usuario.email(), usuario.senha(),
        usuario.num_de_usos_maquina_1(), usuario.num_de_usos_maquina_2(), usuario.num_de_usos_maquina_3(),
        usuario.acesso());

    Usuario usuarioSalvo = repository.save(usuarioAtualizado);
    return ResponseEntity.ok(usuarioSalvo);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}

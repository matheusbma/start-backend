package com.tenway.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tenway.start.model.Usuario;
import com.tenway.start.repository.UsuariosRepository;

import java.util.Optional;

@CrossOrigin(origins = "*")
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
  public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
    String matricula = usuario.matricula();

    Optional<Usuario> usuarioExistente = repository.findByMatricula(matricula);
    if (usuarioExistente.isPresent()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("Usuário já existe em nosso banco de dados!");
    }

    Usuario novoUsuario = repository.save(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
    Optional<Usuario> usuarioOptional = repository.findById(id);
    if (usuarioOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Usuario usuarioAtualizado = new Usuario(id, usuario.matricula(), usuario.nome(), usuario.email(), usuario.senha(),
        usuario.numDeUsosMaquina1(), usuario.numDeUsosMaquina2(), usuario.numDeUsosMaquina3(),
        usuario.acesso());

    Usuario usuarioSalvo = repository.save(usuarioAtualizado);
    return ResponseEntity.ok(usuarioSalvo);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletarUsuario(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    return ResponseEntity.ok("Usuário deletado com sucesso!");
  }

}

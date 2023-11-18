package com.tenway.start.repository;

import com.tenway.start.model.Usuario;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByMatricula(String matricula);
}

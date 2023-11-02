package com.tenway.start.repository;

import com.tenway.start.model.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {

}

package com.tenway.start.model;

import org.springframework.data.annotation.Id;

public record Usuario(@Id Integer id, String matricula, String nome, String email, String senha, String num_de_usos,
    String acesso) {

}

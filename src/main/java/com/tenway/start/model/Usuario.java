package com.tenway.start.model;

import org.springframework.data.annotation.Id;

public record Usuario(@Id Integer id, String matricula,
        String nome, String email,
        String senha, Integer numDeUsosMaquina1,
        Integer numDeUsosMaquina2, Integer numDeUsosMaquina3,
        String acesso) {

}

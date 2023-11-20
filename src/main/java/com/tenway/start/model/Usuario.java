package com.tenway.start.model;

import org.springframework.data.annotation.Id;

public record Usuario(@Id Integer id, String matricula,
                String nome, String email,
                String senha, Integer num_de_usos_maquina_1,
                Integer num_de_usos_maquina_2, Integer num_de_usos_maquina_3,
                String acesso) {

}

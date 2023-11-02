package com.tenway.start.model;

import org.springframework.data.annotation.Id;

public record Agendamento(@Id Integer id, String data, String hora_inicio, String hora_fim, Integer id_usuario,
    Integer id_recurso) {
}

package com.tenway.start.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

public record Agendamento(@Id Integer id, LocalDate data, LocalTime hora_inicio, LocalTime hora_fim, Integer id_usuario,
                          String reserva, Integer id_reserva) {
}

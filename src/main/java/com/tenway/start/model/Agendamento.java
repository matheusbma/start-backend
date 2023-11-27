package com.tenway.start.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

public record Agendamento(@Id Integer id, LocalDate data, LocalTime horaInicio, LocalTime horaFim, Integer idUsuario,
        String reserva, Integer idReserva) {
}

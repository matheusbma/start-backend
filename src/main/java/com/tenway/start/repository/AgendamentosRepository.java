package com.tenway.start.repository;

import com.tenway.start.model.Agendamento;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface AgendamentosRepository extends CrudRepository<Agendamento, Integer> {
    Optional<Agendamento> findByDataAndHoraInicioAndHoraFim(LocalDate data, LocalTime hora_inicio, LocalTime hora_fim);
}
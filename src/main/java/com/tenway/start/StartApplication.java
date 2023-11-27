package com.tenway.start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tenway.start.repository.AgendamentosRepository;
import com.tenway.start.repository.UsuariosRepository;
import com.tenway.start.repository.LaboratoriosRepository;
import com.tenway.start.repository.MaquinasRepository;
import com.tenway.start.repository.MesasRepository;
import com.tenway.start.model.Agendamento;
import com.tenway.start.model.Usuario;
import com.tenway.start.model.Laboratorio;
import com.tenway.start.model.Maquina;
import com.tenway.start.model.Mesa;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	// Inicializa o mockup do banco de dados
	@Bean
	CommandLineRunner init(UsuariosRepository UsuariosRepository, AgendamentosRepository AgendamentosRepository,
			LaboratoriosRepository LaboratoriosRepository, MaquinasRepository MaquinasRepository,
			MesasRepository MesasRepository) {
		return args -> {
			UsuariosRepository.saveAll(
					java.util.Arrays.asList(
							new Usuario(null, "2023100402", "Matheus Borba Maranhão de Araújo", "mbma@cesar.school", "123456", 5, 2,
									1,
									"aluno"),
							new Usuario(null, "2023100331", "João Bosco da Silva Junior", "jbsj@cesar.school", "123456", 4, 0, 2,
									"aluno"),
							new Usuario(null, "2023100405", "Maria Clara Porfírio de Souza", "mcps2@cesar.school", "123456", 2, 6, 1,
									"monitor"),
							new Usuario(null, "20231100359", "Pedro Henrique de Melo Muniz Raposo", "phmmrr@cesar.school", "123456",
									6, 5, 0, "aluno"),
							new Usuario(null, "2023100313", "Rodrigo Martins Dias Fernandes", "rmdf@cesar.school", "123456", 2, 4, 1,
									"aluno"),
							new Usuario(null, "2023100273", "Elinaldo Henrique Silva de Araújo Filho", "ehsaf@cesar.school", "123456",
									3, 0, 4, "aluno"),
							new Usuario(null, "2023100310", "Lígia Bezerra de Oliveira", "lbo@cesar.school", "123456", 3, 2, 0,
									"professor")));
			AgendamentosRepository.saveAll(
					java.util.Arrays.asList(
							new Agendamento(null, LocalDate.parse("2023-11-26"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 1, "mesa", 3),
							new Agendamento(null, LocalDate.parse("2023-11-28"), LocalTime.parse("14:00:00"),
									LocalTime.parse("15:00:00"), 1, "mesa", 1),
							new Agendamento(null, LocalDate.parse("2023-11-28"), LocalTime.parse("09:00:00"),
									LocalTime.parse("10:00:00"), 2, "maquina", 1),
							new Agendamento(null, LocalDate.parse("2023-11-28"), LocalTime.parse("10:00:00"),
									LocalTime.parse("11:00:00"), 2, "maquina", 3),
							new Agendamento(null, LocalDate.parse("2023-11-28"), LocalTime.parse("14:00:00"),
									LocalTime.parse("16:00:00"), 1, "laboratorio", 2),
							new Agendamento(null, LocalDate.parse("2023-12-01"), LocalTime.parse("17:00:00"),
									LocalTime.parse("18:00:00"), 1, "mesa", 2),
							new Agendamento(null, LocalDate.parse("2023-12-01"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 1, "mesa", 3),
							new Agendamento(null, LocalDate.parse("2023-12-01"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 3, "mesa", 1),
							new Agendamento(null, LocalDate.parse("2023-12-04"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 3, "maquina", 2),
							new Agendamento(null, LocalDate.parse("2023-12-04"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 4, "maquina", 3),
							new Agendamento(null, LocalDate.parse("2023-12-04"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 4, "laboratorio", 1),
							new Agendamento(null, LocalDate.parse("2023-11-28"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 5, "mesa", 2),
							new Agendamento(null, LocalDate.parse("2023-12-08"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 5, "mesa", 3),
							new Agendamento(null, LocalDate.parse("2023-12-09"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 6, "mesa", 1),
							new Agendamento(null, LocalDate.parse("2023-12-10"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 6, "maquina", 2),
							new Agendamento(null, LocalDate.parse("2023-12-11"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 7, "maquina", 3),
							new Agendamento(null, LocalDate.parse("2023-12-12"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 2, "laboratorio", 1),
							new Agendamento(null, LocalDate.parse("2023-12-13"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 6, "mesa", 2),
							new Agendamento(null, LocalDate.parse("2023-12-13"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 2, "mesa", 3),
							new Agendamento(null, LocalDate.parse("2023-12-13"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 4, "mesa", 1),
							new Agendamento(null, LocalDate.parse("2023-12-12"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 5, "maquina", 2),
							new Agendamento(null, LocalDate.parse("2023-12-13"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 1, "maquina", 3),
							new Agendamento(null, LocalDate.parse("2023-12-11"), LocalTime.parse("13:00:00"),
									LocalTime.parse("15:00:00"), 1, "laboratorio", 1)

					));
			LaboratoriosRepository.saveAll(
					java.util.Arrays.asList(
							new Laboratorio(null, "Garagem 1", "livre"),
							new Laboratorio(null, "Garagem 2", "livre")));
			MaquinasRepository.saveAll(
					java.util.Arrays.asList(
							new Maquina(null, "Maquina 1", "livre", 2),
							new Maquina(null, "Maquina 2", "livre", 2),
							new Maquina(null, "Maquina 3", "livre", 2)));
			MesasRepository.saveAll(
					java.util.Arrays.asList(
							new Mesa(null, "Mesa 1", "livre", 1),
							new Mesa(null, "Mesa 2", "livre", 1),
							new Mesa(null, "Mesa 3", "livre", 1),
							new Mesa(null, "Mesa 4", "livre", 1),
							new Mesa(null, "Mesa 5", "livre", 1),
							new Mesa(null, "Mesa 6", "livre", 1),
							new Mesa(null, "Mesa 7", "livre", 1),
							new Mesa(null, "Mesa 8", "livre", 1),
							new Mesa(null, "Mesa 9", "livre", 1),
							new Mesa(null, "Mesa 10", "livre", 1),
							new Mesa(null, "Mesa 11", "livre", 1),
							new Mesa(null, "Mesa 12", "livre", 1),
							new Mesa(null, "Mesa 13", "livre", 1),
							new Mesa(null, "Mesa 14", "livre", 1),
							new Mesa(null, "Mesa 15", "livre", 1),
							new Mesa(null, "Mesa 16", "livre", 1),
							new Mesa(null, "Mesa 1", "livre", 2),
							new Mesa(null, "Mesa 2", "livre", 2),
							new Mesa(null, "Mesa 3", "livre", 2),
							new Mesa(null, "Mesa 4", "livre", 2),
							new Mesa(null, "Mesa 5", "livre", 2),
							new Mesa(null, "Mesa 6", "livre", 2),
							new Mesa(null, "Mesa 7", "livre", 2),
							new Mesa(null, "Mesa 8", "livre", 2),
							new Mesa(null, "Mesa 9", "livre", 2),
							new Mesa(null, "Mesa 10", "livre", 2),
							new Mesa(null, "Mesa 11", "livre", 2),
							new Mesa(null, "Mesa 12", "livre", 2),
							new Mesa(null, "Mesa 13", "livre", 2),
							new Mesa(null, "Mesa 14", "livre", 2)));
		};
	}

}

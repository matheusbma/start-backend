package com.tenway.start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tenway.start.repository.AgendamentosRepository;
import com.tenway.start.repository.UsuariosRepository;
import com.tenway.start.model.Agendamento;
import com.tenway.start.model.Usuario;

@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	// Inicializa o banco de dados com alguns usuários
	@Bean
	CommandLineRunner usuariosCommandLineRunner(UsuariosRepository repository) {
		return args -> {
			repository.saveAll(
					java.util.Arrays.asList(
							new Usuario(null, "2023100402", "Matheus Borba Maranhão de Araújo", "mbma@cesar.school", "123456", 5,
									"aluno"),
							new Usuario(null, "2023100331", "João Bosco da Silva Junior", "jbsj@cesar.school", "123456", 2, "aluno"),
							new Usuario(null, "2023100405", "Maria Clara Porfírio de Souza", "mcps2@cesar.school", "123456", 2,
									"monitor"),
							new Usuario(null, "", "", "", "", 6, "aluno")));
		};
	}

	// Inicializa o banco de dados com alguns agendamentos
	@Bean
	CommandLineRunner agendamentosCommandLineRunner(AgendamentosRepository repository) {
		return args -> {
			repository.saveAll(
					java.util.Arrays.asList(
							new Agendamento(null, "2023-11-23", "13:00:00", "15:30:00", 1, 1),
							new Agendamento(null, "2023-11-24", "13:00:00", "15:30:00", 1, 1),
							new Agendamento(null, "2023-11-25", "13:00:00", "15:30:00", 2, 2)));
		};
	}

}

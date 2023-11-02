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
							new Usuario(null, "2023100402", "Matheus Borba Maranhão de Araújo", "mbma@cesar.school", "123456", 5,
									"aluno"),
							new Usuario(null, "2023100331", "João Bosco da Silva Junior", "jbsj@cesar.school", "123456", 2, "aluno"),
							new Usuario(null, "2023100405", "Maria Clara Porfírio de Souza", "mcps2@cesar.school", "123456", 2,
									"monitor"),
							new Usuario(null, "20231100359", "Pedro Henrique de Melo Muniz Raposo", "phmmrr@cesar.school", "123456",
									6, "aluno"),
							new Usuario(null, "2023100313", "Rodrigo Martins Dias Fernandes", "rmdf@cesar.school", "123456", 2,
									"aluno"),
							new Usuario(null, "2023100273", "Elinaldo Henrique Silva de Araújo Filho", "ehsaf@cesar.school", "123456",
									3, "aluno"),
							new Usuario(null, "2023100310", "Lígia Bezerra de Oliveira", "lbo@cesar.school", "123456", 3,
									"professor")));
			AgendamentosRepository.saveAll(
					java.util.Arrays.asList(
							new Agendamento(null, "2023-11-23", "13:00:00", "15:30:00", 1, "mesa", 3),
							new Agendamento(null, "2023-11-24", "13:00:00", "15:30:00", 1, "mesa", 1),
							new Agendamento(null, "2023-11-25", "13:00:00", "15:30:00", 2, "mesa", 2),
							new Agendamento(null, "2023-11-26", "13:00:00", "15:30:00", 2, "mesa", 3),
							new Agendamento(null, "2023-11-27", "13:00:00", "15:30:00", 3, "mesa", 1),
							new Agendamento(null, "2023-11-28", "13:00:00", "15:30:00", 3, "maquina", 2),
							new Agendamento(null, "2023-11-29", "13:00:00", "15:30:00", 4, "maquina", 3),
							new Agendamento(null, "2023-11-30", "13:00:00", "15:30:00", 4, "laboratorio", 1)));
			LaboratoriosRepository.saveAll(
					java.util.Arrays.asList(
							new Laboratorio(null, "Garagem 1", "livre"),
							new Laboratorio(null, "Garagem 2", "livre")));
			MaquinasRepository.saveAll(
					java.util.Arrays.asList(
							new Maquina(null, "Impressora 3D", "livre", 2),
							new Maquina(null, "Cortadora a Laser", "livre", 2),
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

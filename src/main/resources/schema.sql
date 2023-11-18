create table usuario (
    id int not null auto_increment,
    matricula varchar(255) not null,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null,
    num_de_usos_maquina_1 int not null,
    num_de_usos_maquina_2 int not null,
    num_de_usos_maquina_3 int not null,
    acesso enum ('aluno', 'monitor', 'professor') not null,
    primary key (id)
);

create table agendamento (
    id int not null auto_increment,
    data date not null,
    hora_inicio time not null,
    hora_fim time not null,
    id_usuario int not null,
    reserva enum ('laboratorio', 'mesa', 'maquina') not null,
    id_reserva int not null,
    primary key (id),
    foreign key (id_usuario) references usuario(id)
);

create table laboratorio(
    id int not null auto_increment,
    nome varchar(255) not null,
    status enum ('livre', 'ocupada') not null,
    primary key (id)
);

create table mesa (
    id int not null auto_increment,
    nome varchar(255) not null,
    status enum ('livre', 'ocupada') not null,
    id_laboratorio int not null,
    primary key (id)
);

create table maquina (
    id int not null auto_increment,
    nome varchar(255) not null,
    status enum ('livre', 'ocupada') not null,
    id_laboratorio int not null,
    primary key (id)
);
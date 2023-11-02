create table usuario (
    id int not null auto_increment,
    matricula varchar(255) not null,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null,
    num_de_usos int not null,
    acesso enum ('aluno', 'monitor', 'professor') not null,
    primary key (id)
);

create table agendamento (
    id int not null auto_increment,
    data date not null,
    hora_inicio time not null,
    hora_fim time not null,
    id_usuario int not null,
    id_recurso int not null,
    primary key (id),
    foreign key (id_usuario) references usuario(id)
);

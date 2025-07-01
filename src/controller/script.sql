create table tb_usuario(
	id serial primary key,
	nome varchar(120),
	email varchar(100),
	senha varchar(32)
);

create table tb_aluno(
	id serial,
	nome varchar(120) not null,
	email varchar(100) unique,
	telefone varchar(50),
	data_nascimento date not null,
	constraint pk_aluno_id primary key (id)
);

create table tb_professor(
	id serial,
	nome varchar(120) not null,
	email varchar(100) unique,
	telefone varchar(50),
	especialidade varchar(150),
	constraint pk_professor_id primary key (id)	
);

create table tb_curso(
	id serial,
	nome varchar(120) not null,
	carga_horaria integer not null,
	descricao text,
	constraint pk_curso_id primary key (id)
);

create table tb_nivel(
	id serial,
	nome varchar(50) not null,
	descricao text,
	requisitos varchar(255),
	constraint pk_nivel_id primary key (id)
);

create table tb_turma(
	id serial,
	nome varchar(120) not null,
	curso_id integer,
	nivel_id integer,
	professor_id integer,
	horario varchar(50) not null,
	
	constraint pk_turma_id primary key (id),
	constraint fk_curso_id foreign key (curso_id) references tb_curso(id),
	constraint fk_nivel_id foreign key (nivel_id) references tb_nivel(id),
	constraint fk_professor_id foreign key (professor_id) references tb_professor(id)
);
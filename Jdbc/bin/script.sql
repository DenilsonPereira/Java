--Criar tabela de hoteis

CREATE TABLE hotel (
    codigo_hotel serial,
    nome varchar(100) not null,
    cep char(9),
    logradouro varchar(20),
    cidade varchar(30),
    estado varchar(30),
	PRIMARY KEY(codigo_hotel)
);
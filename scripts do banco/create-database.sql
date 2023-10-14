DROP DATABASE tutorial;

CREATE DATABASE IF NOT EXISTS tutorial;

USE tutorial;

CREATE TABLE municipio(
	id INT AUTO_INCREMENT,
	descricao VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE pessoa(
	id INT AUTO_INCREMENT,
	nome VARCHAR(40) NOT NULL,
	idade INT,
	apelido VARCHAR(20),
	id_municipio INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id_municipio) REFERENCES municipio(id)
);




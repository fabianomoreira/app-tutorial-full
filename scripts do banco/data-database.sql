INSERT INTO municipio(descricao) VALUES('Niterói');
INSERT INTO municipio(descricao) VALUES('Maricá');
INSERT INTO municipio(descricao) VALUES('São Gonçalo');

SELECT * FROM municipio;

INSERT INTO pessoa(nome, idade, apelido, id_municipio)
     VALUES('FABIANA AZEVEDO', 26, 'Banana', 3);

INSERT INTO pessoa(nome, idade, apelido, id_municipio)
     VALUES('SELMA MOREIRA', 72, 'Selmona', 3);
    
SELECT * FROM pessoa;

SELECT * FROM pessoa WHERE id_municipio = 3;

SELECT pessoa.nome, pessoa.idade, pessoa.apelido, municipio.descricao  
  FROM pessoa INNER JOIN municipio ON pessoa.id_municipio = municipio.id;
CREATE TABLE pessoas (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(55) NOT NULL,
	ativo BOOLEAN NOT NULL,
	logradouro VARCHAR(255),
	numero VARCHAR(10),
	complemento VARCHAR(55),
	bairro VARCHAR(55),
	cep VARCHAR(15),
	cidade VARCHAR(60),
	estado VARCHAR(55)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO pessoas (nome, ativo, logradouro, numero, bairro, cidade, estado, cep, complemento) VALUES ('Matheus Oliveira', TRUE, 'Rua Manoel Leonardo Gomes', '272', 'Liberdade', 'Campina Grande', 'Paraíba', '584321324','Recuada');
INSERT INTO pessoas (nome, ativo, logradouro, numero, bairro, cidade, estado, cep, complemento) VALUES ('Thiago Oliveira', TRUE, 'Rua Manoel Leonardo Gomes', '272', 'Liberdade', 'Campina Grande', 'Paraíba', '584321324','Recuada');
INSERT INTO pessoas (nome, ativo, logradouro, numero, bairro, cidade, estado, cep, complemento) VALUES ('Thor Oliveira', TRUE, 'Rua Manoel Leonardo Gomes', '272', 'Liberdade', 'Campina Grande', 'Paraíba', '584321324','Recuada');
INSERT INTO pessoas (nome, ativo, logradouro, numero, bairro, cidade, estado, cep, complemento) VALUES ('Kalyne Oliveira', TRUE, 'Rua Manoel Leonardo Gomes', '272', 'Liberdade', 'Campina Grande', 'Paraíba', '584321324','Recuada');
INSERT INTO pessoas (nome, ativo, logradouro, numero, bairro, cidade, estado, cep, complemento) VALUES ('Marcela Tassyany', TRUE, 'Rua Acre', '343', 'Liberdade', 'Campina Grande', 'Paraíba', '584321324','Parede Pedra');
INSERT INTO pessoas (nome, ativo, logradouro, numero, bairro, cidade, estado, cep, complemento) VALUES ('Miqueas Tassyany', TRUE, 'Rua Acre', '343', 'Liberdade', 'Campina Grande', 'Paraíba', '584321324','Parede Pedra');
INSERT INTO pessoas (nome, ativo, logradouro, numero, bairro, cidade, estado, cep, complemento) VALUES ('Teddy', TRUE, 'Rua Acre', '343', 'Liberdade', 'Campina Grande', 'Paraíba', '584321324','Parede Pedra');
INSERT INTO pessoas (nome, ativo, logradouro, numero, bairro, cidade, estado, cep) VALUES ('Guarda da Rua', FALSE, 'Rua Acre', '343', 'Liberdade', 'Campina Grande', 'Paraíba', '584321324');
INSERT INTO pessoas (nome, ativo, logradouro, numero, bairro, cidade, estado, cep) VALUES ('Guardinha da Rua', FALSE, 'Rua Manoel Leonardo Gomes', '272', 'Liberdade', 'Campina Grande', 'Paraíba', '584321324');

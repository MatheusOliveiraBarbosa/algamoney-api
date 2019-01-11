CREATE TABLE categorias ( 
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(55) NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

INSERT INTO categorias (nome) VALUES ('Lazer');
INSERT INTO categorias (nome) VALUES ('Alimentação');
INSERT INTO categorias (nome) VALUES ('Farmácia');
INSERT INTO categorias (nome) VALUES ('Supermercado');
INSERT INTO categorias (nome) VALUES ('Outros');
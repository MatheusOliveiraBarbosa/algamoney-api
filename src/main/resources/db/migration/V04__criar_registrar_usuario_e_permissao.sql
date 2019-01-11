CREATE TABLE usuarios(
	id BIGINT(20) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(255) NOT NULL,
	senha VARCHAR(255) NOT NULL)  
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissoes (
	id BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao(
	id_usuario BIGINT(20) NOT NULL,
	id_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (id_usuario, id_permissao),
	FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
	FOREIGN KEY (id_permissao) REFERENCES permissoes(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO usuarios (id, nome, email, senha) VALUES (1, "Administrador", "admin@admin.com", "$2a$10$m/kK22PFo0V/vRYJlOJS8utwr3nDflvyQfvDPrLlmE9IDrf63R0Sm");
INSERT INTO usuarios (id, nome, email, senha) VALUES (2, "Visitante", "visitante@visitante.com", "$2a$10$qNRNJk8k5YI0Bh9m76Yrku0VYRGnxylnVdISM7MRuvg4HyVxm2RL6");


INSERT INTO permissoes(id, descricao) VALUES (1, 'ROLE_CADASTRAR_CATEGORIA');
INSERT INTO permissoes(id, descricao) VALUES (2, 'ROLE_PESQUISAR_CATEGORIA');

INSERT INTO permissoes(id, descricao) VALUES (3, 'ROLE_CADASTRAR_PESSOA');
INSERT INTO permissoes(id, descricao) VALUES (4, 'ROLE_REMOVER_PESSOA');
INSERT INTO permissoes(id, descricao) VALUES (5, 'ROLE_PESQUISAR_PESSOA');

INSERT INTO permissoes(id, descricao) VALUES (6, 'ROLE_CADASTRAR_LANCAMENTO');
INSERT INTO permissoes(id, descricao) VALUES (7, 'ROLE_REMOVER_LANCAMENTO');
INSERT INTO permissoes(id, descricao) VALUES (8, 'ROLE_PESQUISAR_LANCAMENTO');


-- admin
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (1,1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (1,2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (1,3);
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (1,4);
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (1,5);
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (1,6);
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (1,7);
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (1,8);

-- visitante

INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (2,2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (2,5);
INSERT INTO usuario_permissao (id_usuario, id_permissao) VALUES (2,8);
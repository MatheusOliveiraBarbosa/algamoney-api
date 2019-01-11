CREATE TABLE lancamentos (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 	descricao VARCHAR(255) NOT NULL,
 	data_vencimento DATE NOT NULL,
 	data_pagamento DATE,
 	valor DECIMAL(10,2) NOT NULL,
 	observacao VARCHAR(100),
 	tipo VARCHAR(20) NOT NULL,
 	id_categoria BIGINT(20) NOT NULL,
 	id_pessoa BIGINT(20) NOT NULL,
 	FOREIGN KEY (id_categoria) REFERENCES categorias(id),
 	FOREIGN KEY (id_pessoa) REFERENCES pessoas(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
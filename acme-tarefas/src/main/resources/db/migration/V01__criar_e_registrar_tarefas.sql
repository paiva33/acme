CREATE TABLE tarefa (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50),
	titulo    VARCHAR(50),
	data_criacao datetime default CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tarefa (titulo, descricao) values ('Realizar Tarefa 1', 'Tarefa 1');
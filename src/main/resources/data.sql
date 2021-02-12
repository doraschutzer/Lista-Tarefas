INSERT INTO usuario (codigo, nome, email, senha) values (1, 'Administrador', 'admin@ifsp.edu.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO usuario (codigo, nome, email, senha) values (2, 'Maria Silva', 'maria@ifsp.edu.br', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO etiqueta (codigo, nome) values (1, 'Etiqueta 1');
INSERT INTO etiqueta (codigo, nome) values (2, 'Etiqueta 2');
INSERT INTO etiqueta (codigo, nome) values (3, 'Etiqueta 3');
INSERT INTO etiqueta (codigo, nome) values (4, 'Etiqueta 4');

INSERT INTO tarefa (codigo, descricao, data_realizacao, observacao, codigo_usuario, codigo_etiqueta) values (1, 'Tarefa 1', CURRENT_DATE, 'Observação 1', 1, 1);
INSERT INTO tarefa (codigo, descricao, data_realizacao, observacao, codigo_usuario, codigo_etiqueta) values (2, 'Tarefa 2', CURRENT_DATE, 'Observação 2', 2, 2);
INSERT INTO tarefa (codigo, descricao, data_realizacao, observacao, codigo_usuario, codigo_etiqueta) values (3, 'Tarefa 3', CURRENT_DATE, 'Observação 3', 1, 3);
INSERT INTO tarefa (codigo, descricao, data_realizacao, observacao, codigo_usuario, codigo_etiqueta) values (4, 'Tarefa 4', CURRENT_DATE, 'Observação 4', 2, 4);

-- ETIQUETA -- 
INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_ETIQUETA');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_LISTAR_ETIQUETA');
INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_PESQUISAR_ETIQUETA');
INSERT INTO permissao (codigo, descricao) values (4, 'ROLE_ATUALIZAR_ETIQUETA');
INSERT INTO permissao (codigo, descricao) values (5, 'ROLE_DELETAR_ETIQUETA');

-- TAREFA -- 
INSERT INTO permissao (codigo, descricao) values (6, 'ROLE_CADASTRAR_TAREFA');
INSERT INTO permissao (codigo, descricao) values (7, 'ROLE_LISTAR_TAREFA');
INSERT INTO permissao (codigo, descricao) values (8, 'ROLE_PESQUISAR_TAREFA');
INSERT INTO permissao (codigo, descricao) values (9, 'ROLE_ATUALIZAR_TAREFA');
INSERT INTO permissao (codigo, descricao) values (10, 'ROLE_DELETAR_TAREFA');

-- TAREFA -- 
INSERT INTO permissao (codigo, descricao) values (11, 'ROLE_CADASTRAR_USUARIO');
INSERT INTO permissao (codigo, descricao) values (12, 'ROLE_LISTAR_USUARIO');
INSERT INTO permissao (codigo, descricao) values (13, 'ROLE_PESQUISAR_USUARIO');
INSERT INTO permissao (codigo, descricao) values (14, 'ROLE_ATUALIZAR_USUARIO');
INSERT INTO permissao (codigo, descricao) values (15, 'ROLE_DELETAR_USUARIO');

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 10);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 11);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 12);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 13);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 14);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 15);

-- maria
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 10);

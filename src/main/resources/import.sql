insert into Usuario (id, nome, login, senha, ativo) values (1, 'Alexandre Afonso', 'alexandre', '$2a$10$ARppQC0FRWaGP4pnZqYbpuVyYOWIp4q1r2ViT3PGYK6BafD5PXFiS', true);

insert into Grupo (id, nome, descricao) values (1, 'ANALISTA', 'Grupo de analistas');

insert into Permissao (id, nome) values (1, 'VISUALIZAR_PAG_GERENTE');
insert into Permissao (id, nome) values (2, 'VISUALIZAR_PAG_DESENVOLVEDOR');

insert into Usuario_Grupo (usuarios_id, grupos_id) values (1, 1);

insert into Grupo_Permissao (grupos_id, permissoes_id) values (1, 1);
insert into Grupo_Permissao (grupos_id, permissoes_id) values (1, 2);
drop table acao;
drop table usuario;
drop table produto;

create table usuario (
	id_usuario serial PRIMARY KEY not null,
    nome varchar (50) not null,
    bairro varchar (50) not null,
    cidade varchar (50) not null,
    uf varchar (2) not null,
    email varchar (50) not null,
    telefone varchar (30) not null,
    usuario varchar (30) not null,
    senha varchar (10) not null
);

insert into usuario (nome,bairro,cidade,uf,email,telefone,usuario,senha)
values('thais','centro','hortolândia','SP','thais@gmail.com','(19)99245-9865','Thais','thais');

create table produto(
	id_produto serial PRIMARY KEY not null,
    nome varchar (50) not null,
    estadoConserv varchar (15),
    preco numeric (10,2) not null,
    descricao varchar (160) not null,
    categoria varchar (30) not null,
    img bytea not null,
    status varchar (30) not null,
    dt_anuncio timestamp not null default current_timestamp
);

CREATE FUNCTION dt_anuncio_prod()
RETURNS TRIGGER AS $$
BEGIN
	NEW.dt_anuncio = now();
	RETURN NEW;
END;
$$ language 'plpgsql';

create table acao (
	id_acao serial PRIMARY KEY not null,
    tipo varchar (20) not null,
    status varchar (30) not null,
    id_usuario integer not null,
    id_produto integer not null,
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
);

select * from  usuario;
select * from acao;
select * from produto;

select prod.*, usuario.*, acao.status, acao.tipo from Acao as acao
inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)
inner join Produto as prod on (acao.Id_produto = prod.id_produto)  
where acao.tipo = 'Venda' and usuario.id_usuario = 3 order by prod.dt_anuncio desc;

select prod.*, usuario.*, acao.status, acao.tipo from Acao as acao
inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)
inner join Produto as prod on (acao.Id_produto = prod.id_produto)  
where prod.status = 'Disponivel' and acao.tipo= 'Venda' order by prod.dt_anuncio desc;

select prod.*, usuario.*, acao.status, acao.tipo from Acao as acao
inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)
inner join Produto as prod on (acao.Id_produto = prod.id_produto)  
where prod.nome LIKE '%te%' and prod.status = 'Disponivel' order by prod.dt_anuncio desc;

select prod.*, usuario.*, acao.status, acao.tipo from Acao as acao
inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)
inner join Produto as prod on (acao.Id_produto = prod.id_produto)  
where usuario.id_usuario = 2 and acao.tipo = 'Reserva' or acao.tipo = 'Compra' order by prod.dt_anuncio desc;

select usuario.nome, usuario.bairro, usuario.cidade, usuario.uf, usuario.telefone, acao.status, acao.tipo 
from Acao as acao inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)
inner join Produto as prod on (acao.Id_produto = prod.id_produto)
where prod.status = 'Disponivel' and acao.tipo= 'Reserva' and prod.id_produto = 5 order by prod.dt_anuncio desc;

SELECT * from usuario;

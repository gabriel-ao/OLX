drop table usuario;
drop table produto;
drop table acao;

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

select * from  produto;
select * from  usuario;

select prod.*, usuario.*, acao.status from Acao as acao
inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)
inner join Produto as prod on (acao.Id_produto = prod.id_produto);
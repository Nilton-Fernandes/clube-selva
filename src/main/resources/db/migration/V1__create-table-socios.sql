create table socios(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    telefone varchar(20) not null,
    email varchar(100) not null unique,
    carteirinha varchar(6) not null unique,
    categoria varchar(40) not null,
    logradouro varchar(100) not null,
     numero varchar(10) not null,
     bairro varchar(100) not null,
     cidade varchar(100) not null,
     uf char(2) not null,

     primary key(id)

    );
drop database if exists CONCESSIONARIA;
CREATE DATABASE CONCESSIONARIA;
USE CONCESSIONARIA;

/*Tabela que seria o banco dos carros*/

CREATE TABLE CARRO(
codcarro int primary key auto_increment,
modelo varchar (16),
ano varchar (4),
fornecedor varchar (16),
valor VARCHAR (300),
quantidade int
);
insert into CARRO  values 
(1,'ONIX',2018,'CHEVROLET', 'R$42.198,00', 12),
(2,'KA',2017,'FORD','R$77.800,00', 7),
(3,'HB20',2019,'HYUNDAI','R$88.200,00', 3),
(4,'SANDERO',2015,'RENAULT','R$59.600,00', 1),
(5,'HB20',2016,'HYUNDAI','R$88.200,00', 7),
(6,'MOBI',2017,'FIAT','R$44.000,00', 10),
(7,'VOYAGE',2019,'VOLKSWAGEN','R$33.000,00', 4),
(8,'UNO',2013,'FIAT','R$22.200,00', 15),
(9,'RENEGADE',2017,'JEEP','R$70.200,00', 7),
(10,'PRIMSMA',2017,'VOLKSWAGEN','R$57.500,00', 9);


CREATE TABLE CLIENTE(
codcliente int primary key auto_increment,
nome varchar (32),
cpf varchar (11) unique,
telefone varchar (12) unique
);

/*tabela que seria inserida no programa*/
CREATE TABLE VENDA(
codvenda int primary key auto_increment,
codatendente int,
forma_de_pagamento varchar (12),
codcliente int,
codcarro int
);

CREATE TABLE ATENDENTE(
codatendente int primary key auto_increment,
nome varchar (32),
comissao double (10,2)
);

CREATE TABLE historico_CARRO(
id_carro int primary key auto_increment,
quantidade_anterior int,
quantidade_novo int,
data datetime,
FOREIGN KEY (id_carro) REFERENCES `codcarro`
);

CREATE TABLE AUDITORIA_VENDAS(
id int(11) not null auto_increment,
codVendaA int not null,
codAtendenteA int not null,
data datetime default null,
codClienteA int not null,
codCarroA int not null,
acao varchar(50) default null,
Primary key (id));


DELIMITER $$
CREATE TRIGGER apos_inserir
AFTER INSERT ON VENDA
FOR EACH ROW BEGIN
UPDATE CARRO SET QUANTIDADE = QUANTIDADE - 1
WHERE NEW.CODCARRO = OLD.CODCARRO;
END $$



DELIMITER $$
CREATE TRIGGER ALTERA_QUANTIDADE
AFTER UPDATE ON CARRO
FOR EACH ROW begin
iNSERT INTO historico_carro values (null,OLD.quantidade,NEW.quantidade,now());

END $$
DELIMITER ;




alter table venda
add foreign key(codcarro)
references carro(codcarro);

alter table venda
add foreign key(codcliente)
references cliente(codcliente);

alter table venda
add foreign key(codatendente)
references atendente(codatendente);

desc carro;
desc cliente;
desc venda;
desc atendente;


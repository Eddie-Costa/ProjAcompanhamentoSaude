create database AcompanhamentoSaude1;
use AcompanhamentoSaude1;

create table Usuario(
	Id_User int Primary key auto_increment not null,
    Nome varchar(60) not null,
    Idade int not null,
    Peso double not null,
    Altura double not null,
    PA double not null,
    Glicemia double not null,
    Colesterol double not null,
	Creatinina double not null,
    FrequenciaAcad int not null,
    Imc double not null,
    RemediosDiarios varchar(60) not null
);

create table Academia(
	Id_Acad int primary key not null auto_increment,
	Dia varchar(10) not null,
    DiaDaSemana varchar(20),
    TipoDeTreino varchar(20)
);

create table Saude(
	Id_Saude int primary key auto_increment not null,
    Doenca varchar(60) not null,
    Atual varchar(30) not null,
    dores int not null
);
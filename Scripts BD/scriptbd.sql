--DROP DATABASE  IF EXISTS  mftdb;
CREATE DATABASE "mftdb"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;
      
COMMENT ON DATABASE "mftdb"
  IS 'Banco de dados MFT';

CREATE TABLE d13_empresa(
d13_cdempresa BIGSERIAL NOT NULL PRIMARY KEY,
d13_nmempresa VARCHAR(100),
d13_nmabreviado VARCHAR(20),
d13_nrtelefone varchar(100),
d13_enderecocompleto VARCHAR(100),
d13_txpessoacontato VARCHAR(100),
d13_cnpjempresa VARCHAR(50),
d13_diretorioarquivos VARCHAR(255));

insert into d13_empresa (d13_nmempresa, d13_nmabreviado) values ('EMPRESA MODELO', 'MODELO');

CREATE TABLE menu_empresa(
id_menu_empresa BIGSERIAL NOT NULL PRIMARY KEY,
cdempresa BIGSERIAL);

insert into menu_empresa (cdempresa) values (1);



create table d05_lista_especie( 
d05_cdlistaesp bigserial not null primary key,
d05_cdempresa bigserial,
d05_nmlistaesp varchar(100)
);

insert into d05_lista_especie(d05_cdempresa, d05_nmlistaesp) values (1, 'LISTA REVISADA JULHO');

CREATE  TABLE d20_area(
d20_cdarea BIGSERIAL NOT NULL PRIMARY KEY,
d20_cdempresa bigserial,
d20_cdequacaoareabasalpadrao BIGSERIAL,
d20_cdequacaovolumeinvtemp BIGSERIAL,
d20_cdlistaesp BIGSERIAL,
d20_nmarea VARCHAR(100),
d20_nmestado VARCHAR(100),
d20_nmmunicipio VARCHAR(100),
d20_latitude1grau Integer,
d20_latitude1minuto Integer,
d20_latitude1orientacao varchar(1),
d20_latitude2grau Integer,
d20_latitude2minuto  Integer,
d20_latitude2orientacao varchar(1),
d20_longitude1grau Integer,
d20_longitude1minuto Integer,
d20_longitude1orientacao varchar(1),
d20_longitude2grau Integer,
d20_longitude2minuto Integer,
d20_longitude2orientacao varchar(1),
d20_precipmediaanualmm Integer,
d20_precipmediamensalchuvamm Integer,
d20_precipmediamensalsecamm Integer,
d20_mesesseca VARCHAR(100),
d20_meseschuva VARCHAR(100),
d20_tipologiaflorestal VARCHAR(100),
d20_tiposolo VARCHAR(100),
d20_relevo VARCHAR(100),
d20_nmresponsavel VARCHAR(100),
d20_enderecoresponsavel VARCHAR(100),
d20_nrtelefoneresponsavel VARCHAR(100),
d20_emailresponsavel VARCHAR(100),
d20_txhistoricoarea VARCHAR(4000),
d20_txobservacaoarea VARCHAR(4000),
d20_lgmudacontada boolean,
d20_lgpalmeiracontada boolean);



ALTER TABLE d20_area
ADD CONSTRAINT FK_d20_cdempresa
FOREIGN KEY (d20_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE;

ALTER TABLE d20_area
ADD CONSTRAINT FK_d20_cdlistaesp
FOREIGN KEY (d20_cdlistaesp)
REFERENCES d05_lista_especie(d05_cdlistaesp)
ON DELETE CASCADE;

CREATE TABLE d01_familia (
d01_cdfamilia BIGSERIAL NOT NULL PRIMARY KEY,
d01_nmfamilia VARCHAR(50));

 insert into d01_familia (d01_nmfamilia) values 
('Acanthaceae'),
('Anacardiaceae'),
('Anisophylleaceae'),
('Annonaceae'),
('Apocynaceae') ,
('Aquifoliaceae') ,
('Araceae') ,
('Araliaceae') ,
('Arecaceae') ,
('Asteraceae') ,
('Avicenniaceae') ,
('Bignoniaceae') ,
('Bixaceae'),
('Bombacaceae'),
('Boraginaceae'),
('Bromeliaceae'),
('Burseraceae'),
('Cactaceae') ,
('Capparaceae'),
('Caricaceae') ,
('Caryocaraceae') ,
('Cecropiaceae') ,
('Celastraceae') ,
('Chrysobalanaceae') ,
('Clethraceae') ,
('Clusiaceae') ,
('Cochlospermaceae'),
('Combretaceae'),
('Connaraceae'),
('Costaceae'),
('Cunoniaceae'),
('Cupressaceae'),
('Cyatheaceae'),
('Cyperaceae'),
('Dialypetalanthaceae'),
('Dichapetalaceae'),
('Dilleniaceae'),
('Duckeodendraceae'),
('Ebenaceae') ,
('Elaeocarpaceae'),
('Ericaceae'),
('Erythroxylaceae'),
('Euphorbiaceae') ,
('Fagaceae') ,
('Flacourtiaceae'),
('Gentianaceae'),
('Heliconiaceae') ,
('Hernandiaceae') ,
('Hippocrateaceae'),
('Hugoniaceae'),
('Humiriaceae'),
('Icacinaceae'),
('Lacistemaceae'),
('Lauraceae'),
('Lecythidaceae'),
('Leguminosae'),
('Leguminosae-caesalpinioideae'),
('Leguminosae-mimosoideae'),
('Leguminosae-papilionoideae'),
('Loganiaceae'),
('Lythraceae'),
('Magnoliaceae') ,
('Malpighiaceae'),
('Malvaceae'),
('Marantaceae'),
('Marcgraviaceae'),
('Melastomataceae'),
('Meliaceae'),
('Mendonciaceae'),
('Menispermaceae'),
('Monimiaceae'),
('Moraceae'),
('Moringaceae'),
('Myristicaceae'),
('Myrsinaceae'),
('Myrtaceae'),
('Nyctaginaceae'),
('Ochnaceae'),
('Olacaceae'),
('Opiliaceae'),
('Passifloraceae'),
('Phytolaccaceae'),
('Pinaceae'),
('Piperaceae'),
('Poaceae'),
('Polygonaceae'),
('Proteaceae'),
('Quiinaceae'),
('Rhabdodendraceae'),
('Rhamnaceae'),
('Rhizophoraceae'),
('Rosaceae'),
('Rubiaceae'),
('Rutaceae'),
('Salicaceae'),
('Sapindaceae'),
('Sapotaceae'),
('Selaginellaceae'),
('Simaroubaceae'),
('Siparunaceae'),
('Smilacaceae'),
('Solanaceae'),
('Sterculiaceae'),
('Styracaceae'),
('Symplocaceae'),
('Tecophilaeaceae'),
('Theaceae'),
('Theophrastaceae'),
('Thymelaeaceae'),
('Tiliaceae'),
('Ulmaceae'),
('Verbenaceae'),
('Violaceae'),
('Vochysiaceae'),
('Ochanaceae'),
('Quinaceae'),
('Curcubitaceae');

create table d06_grupo_ecologico(
d06_cdgrupoecologico bigserial not null primary key,
d06_cdempresa bigserial,
d06_nmgrupoecologico varchar(100)
);

insert into d06_grupo_ecologico(d06_cdempresa, d06_nmgrupoecologico) values(1, 'PIONEIRAS');
insert into d06_grupo_ecologico(d06_cdempresa, d06_nmgrupoecologico) values(1, 'DEMANDANTES DE LUZ');
insert into d06_grupo_ecologico(d06_cdempresa, d06_nmgrupoecologico) values(1, 'TOLERANTES À SOMBRA');


create table d02_genero(
d02_cdgenero bigserial not null primary key,
d02_nmgenero varchar(50),
d02_cdfamilia bigserial
);

ALTER TABLE d02_genero
ADD CONSTRAINT FK_d02_genero_d01_familia
FOREIGN KEY (d02_cdfamilia)
REFERENCES d01_familia(d01_cdfamilia)
ON DELETE CASCADE;

insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Abarema',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aberemoa',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Abuta',70);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Acacia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Acanthococos',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Acca',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Achrouteria',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Acioa',24);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aciotis',67);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Acosmium',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Acrocarpus',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Acrocomia',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Acrodiclidium',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Actinostemon',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Adenostephanus',87);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aegiphila',112);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aeschynomene',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aescrion',99);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Agarista',41);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Agonandra',80);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aiouea',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Albizia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Alchornea',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Alchorneopsis',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aldina',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aleurites',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Alexa',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Alibertia',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Allantoma',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Allophylus',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aloysia',112);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Alsophila',33);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Amaioua',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Amanoa',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ambelania',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Amburana',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ampelocera',111);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Amygdalus',92);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Anacardium',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Anadenanthera',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ananas',16);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Anaxagorea',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Andira',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Anemopaegma',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Angostura',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aniba',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Anisomeris',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Annona',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Anthodiscus',21);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Antonia',60);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Antrocaryon',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aparasthmium',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Apeiba',110);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aptandra',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Apuleia',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Arecastrum',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Arrabidaea',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aspidosperma',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Asterolepidium',52);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Astrocaryum',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Astronium',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Attalea',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aulomyrcia',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Auxemma',15);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Avicennia',11);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Aydendron',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bactris',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bagassa',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Balizia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Banara',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Barbosa',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Basiloxylon',103);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Batesia',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bauhinia',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Beilschmiedia',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Belangera',31);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bellucia',67);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bernardinia',29);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bertholletia',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bixa',13);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Blastemanthus',78);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Blepharocalyx',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bocageopsis',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bocoa',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bombacopsis',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bombax',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Borassus',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Borojoa',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Boswellia',17);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bowdichia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bracteanthus',71);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Britoa',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Brosimopsis',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Brosimum',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Brownea',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Buchenavia',28);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bucida',28);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bumelia',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Burdachia',63);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Bursera',17);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Butia',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Byrsonima',63);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cabralea',68);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cacalia',10);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Caesalpinia',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Calanthea',65);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Calliandra',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Callisthene',114);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Calophyllum',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Calycolpus',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Calycophyllum',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Calyptranthes',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Campomanesia',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Campsiandra',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Capirona',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Capparis',19);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Caraipa',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Carapa',68);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Carica',20);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cariniana',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Carpotroche',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Caryocar',21);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Caryodendron',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Caryophyllus',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cascarilla',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Casearia',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cassia',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cassipourea',91);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Castanea',44);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Castilla',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Catappa',28);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cathedra',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Catostemma',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cecropia',22);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cedrela',68);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cedrelinga',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cedrus',83);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ceiba',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cenostigma',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Centrodiscus',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Centrolobium',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cereus',18);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cestrum',102);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chaetocarpus',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chamaecrista',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chaunochiton',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cheiloclinidium',49);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chimarrhis',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chlorocardium',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chloroleucon',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chlorophora',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chomelia',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chorisia',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chromolucuma',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chrysobalanus',24);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chrysophyllum',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chuquiraga',10);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chytroma',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cinnamomum',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Citharexylum',112);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Citronella',52);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Citrus',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Clarisia',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Clathrotropis',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Clausena',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Clavija',108);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Clethra',25);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Clidemia',67);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Climostemon',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Clitoria',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Clusia',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Coccoloba',86);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cochlospermum',27);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Colubrina',90);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Combretum',28);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Conceveiba',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Connarus',29);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Conocarpus',28);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Copaifera',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Copernicia',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cordia',15);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cordiera',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cormonema',90);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Corymbia',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Corythophora',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Costus',30);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cotinus',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Couepia',24);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Couma',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Coumarouna',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Couralia',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Couratari',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Couroupita',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Coussapoa',22);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Coussarea',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Coutarea',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Crateva',19);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Crepidospermum',17);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Crescentia',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Croton',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Crudia',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cryosophila',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cryptocarya',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cunuria',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cupania',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cupressus',32);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Curatella',37);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Curupira',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cusparia',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cyathea',33);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cybistax',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cyclolobium',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cynometra',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Cyphomandra',102);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dacryodes',17);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dalbergia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Daphnopsis',109);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Davillia',37);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Delostoma',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dendrobangia',52);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dendropanax',8);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Derris',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Desmodium',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dialium',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dialyanthera',74);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dialypetalanthus',35);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Diatenopteryx',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Diclinanona',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dicorynia',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dictyoloma',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dicypellium',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Didymopanax',8);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dillenia',37);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dimorphandra',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dinizia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Diospyros',39);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Diploon',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Diplothemium',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Diplotropis',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dipteryx',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Diptychandra',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Discophora',52);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dodecastignma',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Douradoa',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dourodoa',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Drypetes',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Duckeodendron',38);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Duckesia',51);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Duguetia',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dulacia',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Duranta',112);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Duroia',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dussia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Dyssochroma',102);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ecclinusa',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Echyrospermum',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ekmanianthe',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Elaeis',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Elaeoluma',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Elizabetha',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Emmotum',52);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Endlicheria',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Endopleura',51);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Enterolobium',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Eperua',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Eremoluma',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Eriodendron',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Eriotheca',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Erisma',114);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Erythrina',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Erythroxylum',42);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Eschweilera',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Esenbeckia',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Etaballia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Eucalyptus',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Eugenia',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Eupatorium',10);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Euplassa',87);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Euterpe',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Euxylophora',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Evodia',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Excellodendron',24);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Exostyles',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Fagara',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Faramea',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Feijoa',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Felicianea',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ferdinandusa',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ferreirea',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ficus',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Franchetella',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Fusaea',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Galipea',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gallesia',82);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Garcinia',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gardenia',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Geissospermum',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Genipa',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Geoffroea',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Geonoma',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gilibertia',68);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gliricidia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Glycoxylon',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Glycydendron',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gmelina',112);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gochnatia',10);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gomidesia',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gomphia',78);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gossypiospermum',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gouania',90);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Goupia',23);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Grias',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Guarea',68);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Guatteria',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Guatteriopsis',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Guazuma',103);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Guettarda',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Guibourtia',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Guilielma',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Gustavia',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Haploclathra',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hasseltia',110);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hebepetalum',50);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hecatostemon',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Heisteria',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Heliconia',47);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Helicostylis',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Helietta',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hemicrepidospermum',17);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hemitelia',33);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Henriquezia',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hernandia',48);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Herrania',103);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Heterostemon',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hevea',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hieronima',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hieronyma',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Himatanthus',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hippocratea',23);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hirtella',24);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Holopyxidium',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Homalium',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hortia',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Huberodendron',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Humiria',51);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Humiriastrum',51);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hura',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hydrochorea',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hymenaea',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Hymenolobium',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ilex',6);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Inga',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Iriartea',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Iryanthera',74);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ischnosiphon',65);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Isertia',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ixora',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Jacaranda',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Jacaratia',20);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Jambosa',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Jatropha',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Jessenia',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Joannesia',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Kielmeyera',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Labatia',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lacistema',53);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lacmellea',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lacunaria',88);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Laetia',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lafoensia',61);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Laguncularia',28);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lamanonia',31);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Laplacea',107);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lauro-cerasus',92);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lecointea',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lecythis',55);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Leonia',113);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Leopoldina',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lepidagathis',1);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lepidocaryum',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Leptolobium',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Leucastrus',77);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Leucochloron',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Licania',24);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Licaria',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lindackeria',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Liriosma',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lithrea',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lonchocarpus',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Loxopterygium',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lucuma',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Luehea',110);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lueheopsis',110);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Luetzelburgia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Lysiloma',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mabea',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Macairea',67);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Machaerium',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Maclura',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Macoubea',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Macrolobium',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Macrosamanea',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Magnolia',62);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Magonia',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Malouetia',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Malpighia',63);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mammea',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mangifera',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Manilkara',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Maprounea',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Maquira',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Marlierea',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Martiodendron',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mastichodendron',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Matayba',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mauritia',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mauritiella',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mayna',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Maytenus',23);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mendoncia',69);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mespilodaphne',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mezilaurus',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Michelia',62);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Miconia',67);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Micrandra',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Micrandropsis',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Micropholis',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mimosa',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mimusops',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Minquartia',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Moldenhawera',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mollia',110);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Molongum',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Monopteryx',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Moquilea',24);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mora',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Moringa',73);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Moronobea',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mouriri',67);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mouriria',67);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Mucoa',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Muntingia',40);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Murraya',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myracrodruon',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myrceugenia',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myrcia',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myrciaria',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myrcine',75);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myristica',74);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myrocarpus',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myroxylon',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myrrhinium',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Myrsine',75);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Naucleopsis',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Nectandra',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Neea',77);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Nemaluma',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Neomitranthes',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Neoraputia',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Neoxythece',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Nephelea',33);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Niopa',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Norantea',66);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Noyera',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ochroma',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ocotea',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Oenocarpus',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Olmedia',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Olmedioperebea',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Olyra',85);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Onychopetalum',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Oreodaphne',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ormosia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ormosiopsis',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Osteophloeum',74);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Otoba',74);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ottonia',84);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ouratea',78);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Oxandra',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pachira',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pachystroma',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Paivaea',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Palicourea',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Panopsis',87);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Parahancornia',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Parapiptadenia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Parinari',24);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Parinarium',24);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pariniana',85);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Parkia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Paspalum',85);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Passiflora',81);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Patagonula',15);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Patinoa',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pausandra',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pavonia',64);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Paypayrola',113);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Peltogyne',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Peltophorum',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pentaclethra',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pera',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Perebea',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Persea',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Peschiera',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pharmacosycea',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Philodendron',7);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Phoebe',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Phyllanthus',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Phyllocalyx',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Phyllocarpus',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Physocalymma',61);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Picramnia',99);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Picrasma',99);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pilocarpus',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pimenta',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pindarea',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Piper',84);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Piptadenia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Piranhea',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Piratinera',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pisonia',77);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pithecellobium',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pityrocarpa',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Planchonella',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Plathymenia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Platonia',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Platycyamus',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Platymiscium',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Platysmicium',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pleurothyrium',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pochota',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Poecilanthe',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Poeppigia',106);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pogonophora',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Poinciana',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Polyandrococos',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Polygala',86);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Polygonanthus',3);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Populus',95);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Poraqueiba',52);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Porocystis',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Posoqueria',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pourouma',22);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pouteria',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pouteria (nemaluma)',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pouteria (neoxythece)',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pradosia',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Prieurella',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Prosopis',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Protium',17);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Prunus',92);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pseudima',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pseudobombax',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pseudocaryophyllus',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pseudocopaiva',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pseudolmedia',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pseudopiptadenia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pseudoptadenia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Psidium',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Psychotria',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pterandra',63);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pterocarpus',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pterodon',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pterygota',103);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ptychopetalum',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pyrenoglyphis',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Pyrus',92);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Qualea',114);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Quararibea',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Quercus',44);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Quiina',88);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Radlkoferella',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ragala',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Randia',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rapanea',75);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Raputia',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rauvolfia',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rauwolfia',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Recordoxylon',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rhabdodenrdon',89);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rhamnidium',90);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rheedia',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rhus',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Richardella',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rinorea',113);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rollinia',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Roucheria',50);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Roupala',87);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Rourea',29);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ruizterania',114);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ruprechtia',86);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ryania',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sacoglottis',51);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sagotia',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sahagunia',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Salix',95);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Salvertia',114);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Samanea',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sandwithiodoxa',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sapindus',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sapium',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sapota',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sarcaulus',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Schefflera',8);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Schinopsis',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Schinus',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Schizolobium',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Schoepfia',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Scleria',34);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sclerolobium',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Scleronema',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sebastiania',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Selaginella',98);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Senna',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Serjanea',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sextonia',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sickingia',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Siderodendrum',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sideroxylon',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Silvia',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Simaba',99);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Simarouba',99);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Simira',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Siparuna',100);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sloanea',40);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Smilax',101);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Socratea',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Solanum',102);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sorocea',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sparattosperma',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Spathelia',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sphinctanthus',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Spirotheca',14);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Spondias',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Spongiosperma',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sprucella',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Stenocalyx',76);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sterculia',103);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sterigmapetalum',91);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Strychnos',60);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Stryphnodendron',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Styrax',104);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Swartzia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Sweetia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Swietenia',68);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Syagrus',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Symmeria',86);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Symphonia',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Symplocos',105);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Syzygiopsis',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tabebuia',12);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tabernaemontana',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tachigali',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Talauma',62);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Talisia',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tamarindus',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tapirira',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tapura',36);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Taralea',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Terminalia',28);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Ternstroemia',107);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tessaria',10);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tetragastris',17);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tetrorchidium',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Theobroma',103);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Thespesia',64);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Thieleodoxa',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Thuja',32);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Thyrsodium',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tibouchina',67);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tipuana',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tocoyena',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Torresea',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Toulicia',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Touroulia',88);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tovomita',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Tovomitopsis',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Toxicodendron',2);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Trattinnickia',17);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Trema',111);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Trichanthera',1);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Trichilia',68);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Triphasia',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Triplaris',86);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Trithrinax',9);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Trymatococcus',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Umbellunaria',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Unonopsis',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Uragoga',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Urbanella',97);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Urostigma',72);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Vallesia',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Vantanea',51);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Vatairea',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Vataireopsis',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Villaresia',52);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Virola',74);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Vismia',26);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Vitex',112);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Vochysia',114);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Vouacapoua',57);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Vouarana',96);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Warszewiczia',93);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Weinmannia',31);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Xanoquito',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Xylopia',4);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Xylosma',45);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Zanthoxylum',94);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Zizyphus',90);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Zollernia',59);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Zschokkea',5);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Zygia',58);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Conceiba',43);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Alouea',54);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Chaumochytum',79);
insert into d02_genero (d02_nmgenero, d02_cdfamilia) values ('Metrodoria',94);

create table d07_uso_especie(
d07_cduso bigserial not null primary key,
d07_cdempresa bigserial,
d07_nmuso varchar(100),
d07_lgmadeira varchar(15));

insert into d07_uso_especie (d07_cdempresa, d07_nmuso, d07_lgmadeira) values  (1, 'MADEIRA PARA SERRARIA', 'Comercial');
insert into d07_uso_especie (d07_cdempresa, d07_nmuso, d07_lgmadeira) values  (1, 'MADEIRA PARA LÂMINA', 'Comercial');
insert into d07_uso_especie (d07_cdempresa, d07_nmuso, d07_lgmadeira) values  (1, 'MADEIRA PARA ENERGIA', 'Comercial');
insert into d07_uso_especie (d07_cdempresa, d07_nmuso, d07_lgmadeira) values  (1, 'MADEIRA PARA POSTES', 'Comercial');
insert into d07_uso_especie (d07_cdempresa, d07_nmuso, d07_lgmadeira) values  (1, 'MADEIRA PARA MOIRÕES E ESTACAS' ,'Comercial');
insert into d07_uso_especie (d07_cdempresa, d07_nmuso, d07_lgmadeira) values  (1, 'MADEIRA PARA OUTROS USOS INSTRUMENTOS MUSICAIS ARTESANATO E OUTROS', 'Comercial');
insert into d07_uso_especie (d07_cdempresa, d07_nmuso, d07_lgmadeira) values  (1, 'NÃO MADEIREIRO MEDICINAL ALIMENTÍCIO E OUTROS', 'Comercial');
insert into d07_uso_especie (d07_cdempresa, d07_nmuso, d07_lgmadeira) values  (1, 'MADEIRA SEM USO ATUAL', 'Não Comercial');
insert into d07_uso_especie (d07_cdempresa, d07_nmuso, d07_lgmadeira) values  (1, 'MADEIRA POTENCIALMENTE COMERCIAL', 'Comercial');

create table d03_especie(
d03_cdespecie   bigserial not null primary key,
d03_cdempresa	bigserial,
d03_cdlistaesp	bigserial,
d03_cdgenero	bigserial,
d03_cdfamilia	bigserial,
d03_cdespeciemestra	bigserial,
d03_cdgrupoecologico bigserial,	
d03_cdcategoriaprotecao	bigserial,
d03_nmespecie	varchar(100),
d03_nmautor	varchar(100),
d03_lgidentificada	integer
);

ALTER TABLE d03_especie
ADD CONSTRAINT FK_d03_especie_d01_familia1
FOREIGN KEY (d03_cdfamilia)
REFERENCES d01_familia(d01_cdfamilia)
ON DELETE CASCADE;

ALTER TABLE d03_especie
ADD CONSTRAINT FK_d03_especie_d02_genero
FOREIGN KEY (d03_cdgenero)
REFERENCES d02_genero(d02_cdgenero)
ON DELETE CASCADE;

ALTER TABLE d03_especie
ADD CONSTRAINT FK_d03_especie_d06_grupo_ecologico1
FOREIGN KEY (d03_cdgrupoecologico)
REFERENCES d06_grupo_ecologico(d06_cdgrupoecologico)
ON DELETE CASCADE;

ALTER TABLE d03_especie
ADD CONSTRAINT FK_r37_especie_uso_d03_especie
FOREIGN KEY (d03_cdgrupoecologico)
REFERENCES d07_uso_especie(d07_cduso)
ON DELETE CASCADE;

create table r37_especie_uso(
r37_cduso bigserial not null primary key,
r37_cdlistaesp bigserial,
r37_cdempresa bigserial,
r37_cdespecie bigserial);



ALTER TABLE r37_especie_uso
ADD CONSTRAINT FK_r37_especie_uso_d03_especie
FOREIGN KEY (r37_cdespecie)
REFERENCES d03_especie(d03_cdespecie)
ON DELETE CASCADE; 

create table r38_especie_classe_tamanho(
r38_cdclassetamanho bigserial not null primary key,
r38_cdempresa bigserial,
r38_cdlistaesp bigserial,
r38_cdespecie bigserial,
r38_cdequacaovolume bigserial,
r38_crescimentoanualminimomm Integer,
r38_crescimentoanualmaximomm Integer);


create table d08_equacao (
d08_cdequacao bigserial not null primary key,
d08_cdempresa bigserial, 
d08_nmequacao varchar(50),
d08_equacao varchar(3000),
d08_txobservacaoequacao varchar(100),
d08_imequacao oid
);

create table d10_classe_tamanho_individuo ( 
d10_cdclassetamanho bigserial not null primary key,
d10_nmclassetamanho varchar(50)
);

insert into d10_classe_tamanho_individuo (d10_nmclassetamanho) values ('ÁRVORE');
insert into d10_classe_tamanho_individuo (d10_nmclassetamanho) values ('ARVORETA');
insert into d10_classe_tamanho_individuo (d10_nmclassetamanho) values ('VARA');
insert into d10_classe_tamanho_individuo (d10_nmclassetamanho) values ('MUDA NUMERADA');
insert into d10_classe_tamanho_individuo (d10_nmclassetamanho) values ('MUDA CONTADA');
insert into d10_classe_tamanho_individuo (d10_nmclassetamanho) values ('PALMEIRA NUMERADA');
insert into d10_classe_tamanho_individuo (d10_nmclassetamanho) values ('PALMEIRA CONTADA');




create table d18_medicao(
d18_cdmedicao bigserial not null primary key, 
d18_cdempresa bigserial,
d18_cdarea bigserial,
d18_dtiniciomedicao timestamp,
d18_txobservacao varchar(4000));


ALTER TABLE d18_medicao
ADD CONSTRAINT FK_d18_cdempresa
FOREIGN KEY (d18_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE; 

ALTER TABLE d18_medicao
ADD CONSTRAINT FK_d18_cdarea
FOREIGN KEY (d18_cdarea)
REFERENCES d20_area(d20_cdarea)
ON DELETE CASCADE; 


create table r33_area_classe_tamanho(
r33_cdclassetamanho bigserial not null primary key,
r33_cdempresa bigserial,
r33_cdarea bigserial,
r33_cdequacaovolumepadrao bigserial,
r33_cdformatosubparcela bigserial,
r33_dapminimocomfustemm int,
r33_dapmaximocomfustemm int,
r33_dapminimosemfustemm int,
r33_dapmaximosemfustemm int,
r33_alturaminimam numeric(10, 2),
r33_alturamaximam numeric(10, 2),
r33_comprimentoparcelam numeric(10, 2),
r33_larguraparcelam numeric(10, 2),
r33_dimensao1subparcelam numeric(10, 2),
r33_dimensao2subparcelam numeric(10, 2),
r33_dimensao3subparcelam numeric(10, 2),
r33_padraocrescanualminimomm int,
r33_padraocrescanualmaximomm int,
r33_dapmaximoingmedicao2mm int,
r33_nrsubparcelasporparcela int);


ALTER TABLE r33_area_classe_tamanho
ADD CONSTRAINT FK_r33_area_classe_tamanho
FOREIGN KEY (r33_cdclassetamanho)
REFERENCES d10_classe_tamanho_individuo(d10_cdclassetamanho)
ON DELETE CASCADE; 


CREATE TABLE d22_tipo_parcela(
d22_cdtipoparcela bigserial NOT NULL PRIMARY KEY,
d22_cdempresa	bigserial, 
d22_nmtipoparcela	VARCHAR(100),	
d22_lgestudocrescimento	boolean);	

ALTER TABLE d22_tipo_parcela
ADD CONSTRAINT FK_d22_cdempresa
FOREIGN KEY (d22_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE;

insert into d22_tipo_parcela(d22_cdempresa, d22_nmtipoparcela, d22_lgestudocrescimento) values (1, 'PERMANENTE', 'true');
insert into d22_tipo_parcela(d22_cdempresa, d22_nmtipoparcela, d22_lgestudocrescimento) values (1, 'REPETIÇÃO PARCIAL', 'false');
insert into d22_tipo_parcela(d22_cdempresa, d22_nmtipoparcela, d22_lgestudocrescimento) values (1, 'TEMPORÁRIA', 'true');






CREATE TABLE d21_parcela(
d21_cdparcela	bigserial NOT NULL PRIMARY KEY,
d21_cdempresa	bigserial,
d21_cdarea	bigserial, 
d21_cdtipoparcela	bigserial,	
d21_txobservacaoparcela	VARCHAR(4000),
d21_latitudeponto1grau	Integer,	
d21_latitudeponto1minuto	Integer,	
d21_latitudeponto1orientacao	VARCHAR(10),
d21_longitudeponto1grau	Integer,	
d21_longitudeponto1minuto	Integer,	
d21_longitudeponto1orientacao	VARCHAR(10),	
d21_latitudeponto2grau	Integer,	
d21_latitudeponto2minuto	Integer,	
d21_latitudeponto2orientacao	VARCHAR(10),	
d21_longitudeponto2grau	Integer,	
d21_longitudeponto2minuto	Integer	,
d21_longitudeponto2orientacao	VARCHAR(10),	
d21_latitudeponto3grau	Integer,	
d21_latitudeponto3minuto	Integer,	
d21_latitudeponto3orientacao	VARCHAR(10),	
d21_longitudeponto3grau	Integer,	
d21_longitudeponto3minuto	Integer,	
d21_longitudeponto3orientacao	VARCHAR(10),	
d21_latitudeponto4grau	Integer,	
d21_latitudeponto4minuto	Integer,	
d21_latitudeponto4orientacao VARCHAR(10),	
d21_longitudeponto4grau	Integer,	
d21_longitudeponto4minuto	Integer,	
d21_longitudeponto4orientacao	VARCHAR(10),	
d21_lgtestemunha	boolean);	


	
ALTER TABLE d21_parcela
ADD CONSTRAINT FK_d21_cdempresa
FOREIGN KEY (d21_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE;

ALTER TABLE d21_parcela 
ADD CONSTRAINT FK_d21_cdtipoparcela
FOREIGN KEY (d21_cdtipoparcela)
REFERENCES d22_tipo_parcela(d22_cdtipoparcela)
ON DELETE CASCADE;


ALTER TABLE d21_parcela
ADD CONSTRAINT FK_d21_cdarea
FOREIGN KEY (d21_cdarea)
REFERENCES d20_area(d20_cdarea)
ON DELETE CASCADE;



create table r47_medicao_subparcela(
r47_cdsubparcela bigserial not null primary key,
r47_cdempresa bigserial,
r47_cdarea bigserial,
r47_cdparcela bigserial,
r47_cdmedicao bigint,
r47_cdclassefloresta bigserial,
r47_cdclassetamanho bigserial,
r47_nmresponsavel varchar(100),
r47_nmidentificador varchar(100));

ALTER TABLE r47_medicao_subparcela
ADD CONSTRAINT FK_r47_cdempresa
FOREIGN KEY (r47_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE; 

ALTER TABLE r47_medicao_subparcela
ADD CONSTRAINT FK_r47_cdarea
FOREIGN KEY (r47_cdarea)
REFERENCES d20_area(d20_cdarea)
ON DELETE CASCADE; 


ALTER TABLE r47_medicao_subparcela
ADD CONSTRAINT FK_r47_cdparcela
FOREIGN KEY (r47_cdparcela)
REFERENCES d21_parcela(d21_cdparcela)        
ON DELETE CASCADE; 


ALTER TABLE r47_medicao_subparcela
ADD CONSTRAINT FK_r47_cdmedicao
FOREIGN KEY (r47_cdmedicao)
REFERENCES d18_medicao(d18_cdmedicao)
ON DELETE CASCADE; 


CREATE TABLE d29_subparcela(
d29_cdsubparcela  bigserial NOT NULL PRIMARY key,
d29_cdempresa	bigserial,	
d29_cdarea	  bigserial,
d29_cdparcela	bigserial);
		


ALTER TABLE d29_subparcela
ADD CONSTRAINT FK_d29_cdempresa
FOREIGN KEY (d29_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE;

ALTER TABLE d29_subparcela
ADD CONSTRAINT FK_d29_cdparcela
FOREIGN KEY (d29_cdparcela)
REFERENCES d21_parcela(d21_cdparcela)
ON DELETE CASCADE;

ALTER TABLE d29_subparcela
ADD CONSTRAINT FK_d29_cdarea
FOREIGN KEY (d29_cdarea)
REFERENCES d20_area(d20_cdarea)
ON DELETE CASCADE;


CREATE TABLE p23_arvore(
   p23_cdarvore bigserial not null primary key,
	p23_cdempresa bigserial,
	p23_cdarea bigserial,
	p23_cdmedicao bigserial,
	p23_cdparcela bigserial,
	p23_cdsubparcela bigserial,
	p23_cdespecie bigserial,
	p23_cdclassetamanho bigserial,
	p23_cdcif bigserial,
	p23_cddano bigserial,
	p23_cdpodridao bigserial, 
	p23_cdiluminacao bigserial,
	p23_cdforma bigserial,
	p23_cdcipo bigserial,
	p23_cdtratamento bigserial,  
	p23_nrindividuo integer,
	p23_nrfuste integer,
	diametromm integer,
	p23_coordx integer,
	p23_coordy integer,
	p23_lgmudancapdm integer,
	p23_volumetmp float,
	p23_areabasaltmp float);
	
ALTER TABLE p23_arvore
ADD CONSTRAINT FK_p23_cdempresa_d13_cdempresa
FOREIGN KEY (p23_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE;
	
create table d09_categoria_protecao(
d09_cdcategoriaprotecao bigserial not null primary key,
d09_cdempresa bigserial,
d09_nmcategoriaprotecao varchar(100));

insert into d09_categoria_protecao (d09_cdempresa, d09_nmcategoriaprotecao) values (1, 'NÃO CATEGORIZADA');
insert into d09_categoria_protecao (d09_cdempresa, d09_nmcategoriaprotecao) values (1, 'PROTEGIDA');
insert into d09_categoria_protecao (d09_cdempresa, d09_nmcategoriaprotecao) values (1, 'AMEAÇADA DE EXTINÇÃO');
insert into d09_categoria_protecao (d09_cdempresa, d09_nmcategoriaprotecao) values (1, 'EM EXTINÇÃO');
insert into d09_categoria_protecao (d09_cdempresa, d09_nmcategoriaprotecao) values (1, 'VULNERÁVEL');

ALTER TABLE d03_especie
ADD CONSTRAINT FK_d03_especie_d09_categoria_protecao
FOREIGN KEY (d03_cdcategoriaprotecao)
REFERENCES d09_categoria_protecao(d09_cdcategoriaprotecao)
ON DELETE CASCADE; 
		

ALTER TABLE d09_categoria_protecao
ADD CONSTRAINT FK_d13_cdempresa_d09_categoria_protecao
FOREIGN KEY (d09_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE; 

create table d36_tratamento_silvicultural(
d36_cdtratamento bigserial not null primary key,
d36_cdempresa bigserial,
d36_nmtratamento varchar(100));

ALTER TABLE d36_tratamento_silvicultural
ADD CONSTRAINT FK_d36_tratamento_silvicultural_d13_cdempresa
FOREIGN KEY (d36_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE; 
 
insert into d36_tratamento_silvicultural (d36_cdempresa, d36_nmtratamento) values (1, 'ÁRVORE ANELADA');
insert into d36_tratamento_silvicultural (d36_cdempresa, d36_nmtratamento) values (1, 'ÁRVORE ANELADA E TRATADA COM APLICAÇÃO DE ARBORICIDA');
insert into d36_tratamento_silvicultural (d36_cdempresa, d36_nmtratamento) values (1, 'ÁRVORE BENEFICIADA POR TRATAMENTO SILVICULTURAL');
insert into d36_tratamento_silvicultural (d36_cdempresa, d36_nmtratamento) values (1, 'ÁRVORE NÃO RESERVADA NEM TRATADA');
insert into d36_tratamento_silvicultural (d36_cdempresa, d36_nmtratamento) values (1, 'ÁRVORE RESERVADA PARA FUTURA COLHEITA');



create table r35_ts_atual_ts_anterior(
r35_cdtratamentoanteriorPK bigserial not null primary key,
r35_cdtratamentoanterior bigserial,
r35_cdempresa bigserial,
r35_cdtratamentoatual bigserial);

ALTER TABLE r35_ts_atual_ts_anterior
ADD constraint FK_r35_ts_atual_ts_anterior_d36_tratamento_silvicultural
FOREIGN KEY (r35_cdtratamentoanterior)
REFERENCES d36_tratamento_silvicultural(d36_cdtratamento)
ON DELETE CASCADE; 

ALTER TABLE r35_ts_atual_ts_anterior
ADD CONSTRAINT FK_r35_ts_atual_ts_anterior_d13_cdempresa
FOREIGN KEY (r35_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE; 

ALTER TABLE r35_ts_atual_ts_anterior
ADD constraint FK_r35_ts_atual_ts_anterior_d36_tratamento_silvicultural01
FOREIGN KEY (r35_cdtratamentoatual)
REFERENCES d36_tratamento_silvicultural(d36_cdtratamento)
ON DELETE CASCADE; 

create table d30_classe_floresta(
d30_cdclassefloresta bigserial not null primary key,
d30_cdempresa bigserial,
d30_nmclassefloresta varchar(50),
d30_imfigura varchar(150)
);

ALTER TABLE d30_classe_floresta
ADD CONSTRAINT FK_d02_genero_d01_familia
FOREIGN KEY (d30_cdempresa)
REFERENCES d13_empresa(d13_cdempresa)
ON DELETE CASCADE;

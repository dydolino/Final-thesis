insert into pacjent(Imie,Nazwisko,PESEL)values
('Aleksander','Dytko','96012508418'),
('Alina','Dabrowska','94082308418');

insert into choroby(nazwa, Waga_choroby, Dlugosc_operacji) values
('Rak nieborak','9','2.6'),
('Uszkodzona tetnica','5','2.5'),
('Gruzlica','4','2');


insert into egz_choroby(data_rozpoznania, choroby_id_choroby,pacjent_id_pacjent) values
("2019-03-19", 1,1),
("2018-04-13",2,1),
("2017-09-28",2,2);

insert into Specjalizacja(Nazwa,Opis)values
('Internista','Zajmuje sie pierwszym kontaktem z pacjentem'),
('Laryngolog','Specjalista od uszu');

insert into Lekarz(Imie, Nazwisko, Numer_licencji, specjalizacja_id_specjalizacja) values
('Aplonary','Kowalski','1211211212',1),
('Bartmlomiej','Koch','1549866585',1);

insert into sala(numer_sali, numer_pietra) values
(1,5),
(2,5),
(3,5);

insert into dzien(numer_dnia,sala_id_sala) values
(1,1),
(2,2),
(3,3);

insert into operacja(egz_choroby_id_egz_choroby,lekarz_id_lekarz,pacjent_id_pacjent,sala_id_sala) values
(1,1,1,1),
(2,2,2,2);

insert into wydarzenia(godzina_od,godzina_do,dzien_id_dzien)values
('12','14',1),
('14','16',2),
('17','19',3);

insert into user(username,password,enabled)values
('admin','{noop}admin',true),
('user','{noop}user',true);

insert into user_role(username,role)values
('admin','role_ADMIN'),
('user','role_USER');
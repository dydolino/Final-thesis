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
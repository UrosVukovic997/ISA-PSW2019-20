
INSERT INTO klinika (naziv, grad, ocena)
VALUES ('NS_KLINIKA', 'Novi Sad', '7');

INSERT INTO klinika (naziv, grad, ocena)
VALUES ('KBC', 'Beograd', '9');


INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description)
VALUES ('Jovan', 'Jovanovic', 'marko@gmail.com', 'hirurg', 'lekar', '123456', 1, 'Maksima Gorkog',
'Specijalista za kario hirurgiju. Hiruski staz od 24 godine rada. Kao hirurg prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji');

INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description)
VALUES ('Borislav', 'Borovic', 'bokimajstor@gmail.com', 'infektolog', 'infektologlekar', '123456', 1, 'Maksima Gorkog',
'Specijalista za infektologiju. Infektoloski staz od 24 godine rada. Kao infektolog prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji');

INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description)
VALUES ('Djordje', 'Djordjevic', 'djoka@gmail.com', 'urolog', 'urologlekar', '123456', 2, 'Maksima Gorkog',
'Specijalista za urologiju. Uroloski staz od 24 godine rada. Kao urolog prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji');

INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description)
VALUES ('Igor', 'Igorevic', 'igy@gmail.com', 'otorinolaringolog', 'otorinolaringolog', '123456', 2, 'Maksima Gorkog',
'Specijalista za otorinolaringologiju. Otorinolaringolog staz od 24 godine rada. Kao otorinolaringolog prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji');


INSERT INTO sestra (ime, prezime, email, username, lozinka, klinika, adresa)
VALUES ('Marina', 'Savic', 'ms@gmail.com', 'msavic', '1234', 'KBC', 'Cirpanova 10, Novi Sad');

INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo,deleted, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 6.', '066543189', 'Srbija', 'gara.nikola@gmail.com', 'Novi Sad', 'Marko', '7766890',0, 1, '123456', 1, 'Markovic', 'pacijent', 1, '1988-10-06');

INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo,deleted, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 21.', '066543189', 'Srbija', 'gara@gmail.com', 'Novi Sad', 'Zarko', '226220',0,  1, '$2a$10$e.g6dKlg/9jbUZFp4IcdnOAFJZbydpsge2ODaRY4b3uvDN9eNsjZK', 1, 'Zarkovic', 'Sipanza', 1, '1991-10-06');

INSERT INTO klinika_pacijents (klinika_id, pacijents_id)
VALUES (2,1);

INSERT INTO karton (broj, pacijent_id)
VALUES (1549,1);

INSERT INTO dijagnoza (id, naziv_dijagnoze, opis_dijagnoze)
VALUES (1, 'Tahikardija', 'Nepravilan rad srca');

INSERT INTO dijagnoza (id, naziv_dijagnoze, opis_dijagnoze)
VALUES (4, 'Konjuktivitis', 'Bolest ociju');

INSERT INTO karton_dijagnoze (karton_id, dijagnoze_id)
VALUES (1,1);



INSERT INTO tip_pregleda (name, deleted, price)
VALUES ('Pregled Glave', 0, 1650);

INSERT INTO tip_pregleda (name, deleted, price)
VALUES ('ORL', 0, 842);

INSERT INTO tip_pregleda (name, deleted, price)
VALUES ('Ginekologija', 0, 2600);

INSERT INTO tip_pregleda (name, deleted, price)
VALUES ('Urologija', 0, 1400);

INSERT INTO tip_pregleda (name, deleted, price)
VALUES ('Zubar', 0, 650);

INSERT INTO tip_pregleda (name, deleted, price)
VALUES ('Plucni', 0, 805);

INSERT INTO karton_dijagnoze (karton_id, dijagnoze_id)
VALUES (1,4);

INSERT INTO administrator (email, ime, klinika, lozinka, prezime, username)
VALUES ('pera@uns.ac.rs', 'Pera', 'Kamenica', '123456', 'Garava', 'admin');

INSERT INTO adminkc (email, ime, lozinka, prezime, prvo_prijavljivanje, username)
VALUES ('perakc@uns.ac.rs', 'Pera', '123456', 'Gargarin', 1, 'adminkc');


INSERT INTO klinika_lekari (klinika_id, lekari_id)
VALUES (1,1);

INSERT INTO klinika_lekari (klinika_id, lekari_id)
VALUES (1,2);

INSERT INTO klinika_lekari (klinika_id, lekari_id)
VALUES (2,3);

INSERT INTO klinika_lekari (klinika_id, lekari_id)
VALUES (2,4);

INSERT INTO klinika_tip_pregleda (klinika_id, tip_pregleda_id)
VALUES (1,1);
INSERT INTO klinika_tip_pregleda (klinika_id, tip_pregleda_id)
VALUES (1,2);
INSERT INTO klinika_tip_pregleda (klinika_id, tip_pregleda_id)
VALUES (1,3);
INSERT INTO klinika_tip_pregleda (klinika_id, tip_pregleda_id)
VALUES (2,4);
INSERT INTO klinika_tip_pregleda (klinika_id, tip_pregleda_id)
VALUES (2,5);
INSERT INTO klinika_tip_pregleda (klinika_id, tip_pregleda_id)
VALUES (2,6);


INSERT INTO tip_pregleda_lekari (tip_pregleda_id, lekari_id)
VALUES (1,1);
INSERT INTO tip_pregleda_lekari (tip_pregleda_id, lekari_id)
VALUES (1,2);
INSERT INTO tip_pregleda_lekari (tip_pregleda_id, lekari_id)
VALUES (2,3);
INSERT INTO tip_pregleda_lekari (tip_pregleda_id, lekari_id)
VALUES (3,4);

INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id)
VALUES ('2020-02-13','2020-02-13','2020-02-13 07:00:00',1,1);

INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id)
VALUES ('2020-02-13','2020-02-13','2020-02-13 08:00:00',1,1);

INSERT INTO lekar_termin (lekar_id, termin_id)
VALUES (1,1);

INSERT INTO lekar_termin (lekar_id, termin_id)
VALUES (1,2);


INSERT INTO pregled (nationality, email,town,emergency, first_name,jbo,kraj,done,deleted,operation,pocetak,visit,last_name,lekar_id,pacijent_id,termin_id,tip_pregleda_id)
VALUES ('','intelidzeja','intelidzeja','intelidzeja','intelidzeja',123,'2020-03-13 07:00:00',0,0,0,'2020-03-13 07:00:00',0,'intelidzeja',1,1,1,1);


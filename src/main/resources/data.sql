
INSERT INTO klinika (naziv, grad, ocena)
VALUES ('NS_KLINIKA', 'Novi Sad', '7');

INSERT INTO klinika (naziv, grad, ocena)
VALUES ('KBC', 'Beograd', '9');


INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description)
VALUES ('Jovan', 'Jovanovic', 'marko@gmail.com', 'hirurg', 'lekar', '123456', 1, 'Maksima Gorkog',
'Specijalista za kario hirurgiju. Hiruski staz od 24 godine rada. Kao hirurg prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji');

INSERT INTO sestra (ime, prezime, email, username, lozinka, klinika, adresa)
VALUES ('Marina', 'Savic', 'ms@gmail.com', 'msavic', '1234', 'KBC', 'Cirpanova 10, Novi Sad');

INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 6.', '066543189', 'Srbija', 'gara.nikola@gmail.com', 'Novi Sad', 'Marko', '7766890', 1, '123456', 1, 'Markovic', 'pacijent', 1, '1988-10-06');

INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 21.', '066543189', 'Srbija', 'gara@gmail.com', 'Novi Sad', 'Zarko', '226220',  1, '$2a$10$e.g6dKlg/9jbUZFp4IcdnOAFJZbydpsge2ODaRY4b3uvDN9eNsjZK', 1, 'Zarkovic', 'Sipanza', 1, '1991-10-06');

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

INSERT INTO karton_dijagnoze (karton_id, dijagnoze_id)
VALUES (1,4);

INSERT INTO administrator (email, ime, klinika, lozinka, prezime, username)
VALUES ('pera@uns.ac.rs', 'Pera', 'Kamenica', '123456', 'Garava', 'admin');

INSERT INTO adminkc (email, ime, lozinka, prezime, prvo_prijavljivanje, username)
VALUES ('perakc@uns.ac.rs', 'Pera', '123456', 'Gargarin', 1, 'adminkc');

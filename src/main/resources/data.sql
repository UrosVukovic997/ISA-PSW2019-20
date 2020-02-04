
INSERT INTO klinika (naziv, grad, ocena)
VALUES ('NS_KLINIKA', 'Novi Sas', '7');



INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description)
VALUES ('Jovan', 'Jovanovic', 'marko@gmail.com', 'hirurg', 'Jovo93', '$2a$10$e.g6dKlg/9jbUZFp4IcdnOAFJZbydpsge2ODaRY4b3uvDN9eNsjZK', 1, 'Maksima Gorkog',
'Specijalista za kario hirurgiju. Hiruski staz od 24 godine rada. Kao hirurg prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji');



INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 6.', '066543189', 'Srbija', 'gara.nikola@gmail.com', 'Novi Sad', 'Marko', '7766890', 1, '$2a$10$e.g6dKlg/9jbUZFp4IcdnOAFJZbydpsge2ODaRY4b3uvDN9eNsjZK', 1, 'Markovic', 'Majmunce', 1, '1988-10-06');

INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 21.', '066543189', 'Srbija', 'gara@gmail.com', 'Novi Sad', 'Zarko', '226220',  1, '$2a$10$e.g6dKlg/9jbUZFp4IcdnOAFJZbydpsge2ODaRY4b3uvDN9eNsjZK', 1, 'Zarkovic', 'Sipanza', 1, '1991-10-06');


INSERT INTO klinika (naziv, grad, ocena)
VALUES ('NS_KLINIKA', 'Novi Sad', '7');

INSERT INTO klinika (naziv, grad, ocena)
VALUES ('KBC', 'Beograd', '9');


INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description,prosecna_ocena)
VALUES ('Jovan', 'Jovanovic', 'marko@gmail.com', 'hirurg', 'lekar', '123456', 1, 'Maksima Gorkog',
'Specijalista za kario hirurgiju. Hiruski staz od 24 godine rada. Kao hirurg prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji',5.6);

INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description,prosecna_ocena)
VALUES ('Borislav', 'Borovic', 'bokimajstor@gmail.com', 'infektolog', 'infektologlekar', '123456', 1, 'Maksima Gorkog',
'Specijalista za infektologiju. Infektoloski staz od 24 godine rada. Kao infektolog prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji',7.7);

INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description,prosecna_ocena)
VALUES ('Djordje', 'Djordjevic', 'djoka@gmail.com', 'urolog', 'urologlekar', '123456', 2, 'Maksima Gorkog',
'Specijalista za urologiju. Uroloski staz od 24 godine rada. Kao urolog prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji',6.6);

INSERT INTO lekar (first_name, last_name, email, spec, username, password, klinika_id, home_adress, description,prosecna_ocena)
VALUES ('Igor', 'Igorevic', 'igy@gmail.com', 'otorinolaringolog', 'otorinolaringolog', '123456', 2, 'Maksima Gorkog',
'Specijalista za otorinolaringologiju. Otorinolaringolog staz od 24 godine rada. Kao otorinolaringolog prosao sam ratista 90-tih. Diplomirao i specijalizirao na Vojno medicinskoj akademiji',10.0);


INSERT INTO sestra (ime, prezime, email, username, lozinka, klinika, adresa)
VALUES ('Marina', 'Savic', 'ms@gmail.com', 'msavic', '1234', 'KBC', 'Cirpanova 10, Novi Sad');

INSERT INTO sestra (ime, prezime, email, username, lozinka, klinika, adresa)
VALUES ('Petra', 'Savic', 'ps@gmail.com', 'pssavic', '1234', 'NS_KLINIKA', 'Cirpanova 20, Novi Sad');

INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo,deleted, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 6.', '066543189', 'Srbija', 'gara.nikola@gmail.com', 'Novi Sad', 'Marko', '7766890',0, 1, '123456', 1, 'Markovic', 'pacijent', 1, '1988-10-06');

INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo,deleted, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 21.', '066543189', 'Srbija', 'gara.ne.vara@gmail.com', 'Novi Sad', 'Zarko', '226220',0,  1, '123456', 1, 'Zarkovic', 'Sipanza', 1, '1991-10-06');

INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo,deleted, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 21.', '066543189', 'Srbija', 'gara@gmail.com', 'Novi Sad', 'Zarko', '226220',0,  1, '123456', 1, 'Zarkovic', 'Lepota', 1, '1991-10-06');

INSERT INTO pacijent (adresa_prebivalista, broj_telefona, drzava, email, grad, ime, jbo,deleted, odobren, password, potvrdio, prezime, username, lekar_id, datum_rodj )
VALUES ('Bulevar Evrope 21.', '066543189', 'Srbija', 'gara@gmail.com', 'Novi Sad', 'Darko', '226220',0,  1, '123456', 1, 'Darkovic', 'daky', 1, '1991-10-06');

/*INSERT INTO klinika_pacijents (klinika_id, pacijents_id)
VALUES (2,1);*/

INSERT INTO karton (broj,krvna_grupa,dioptrija, pacijent_id)
VALUES (1549,'AB+','-0.5',1);

INSERT INTO karton (broj,krvna_grupa,dioptrija, pacijent_id)
VALUES (1550,'A+','+2.5',2);

INSERT INTO karton (broj,krvna_grupa,dioptrija, pacijent_id)
VALUES (1551,'B+','+1.5',3);

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



INSERT INTO sala (name, number)
VALUES ("operaciona1", 1);
INSERT INTO sala (name, number)
VALUES ("pregled1",2);
INSERT INTO sala (name, number)
VALUES ('pregled2',3);

/*
INSERT INTO termin (start_time, end_time, sala_id,datum,odsustvo,slobodan)
VALUES ('2020-10-05','2020-10-06', 1,'2020-10-05',0,1);

INSERT INTO termin (start_time, end_time, sala_id,datum,odsustvo,slobodan)
VALUES ('2020-10-07','2020-10-08', 2,'2020-10-07',0,1);

INSERT INTO termin (start_time, end_time, sala_id,datum,odsustvo,slobodan)
VALUES ('2020-10-08','2020-10-09', 3,'2020-10-08',0,1);



INSERT INTO termin (datum, start_time, end_time, slobodan, pregled_id, odsustvo, sala_id, odsustvo_odmor_id)
VALUES ('2020-10-05','2020-10-05','2020-10-06',1,2,0,1,null);

INSERT INTO termin (datum, start_time, end_time, slobodan, pregled_id, odsustvo, sala_id, odsustvo_odmor_id)
VALUES ('2020-10-05','2020-10-07','2020-10-08',0,1,0,2,null);

INSERT INTO termin (datum, start_time, end_time, slobodan, pregled_id, odsustvo, sala_id, odsustvo_odmor_id)
VALUES ('2020-10-05','2020-10-08','2020-10-09',1,2,0,3,null);

INSERT INTO termin (datum, start_time, end_time, slobodan, pregled_id, odsustvo,sala_id, odsustvo_odmor_id)
VALUES ('2020-10-05','2021-10-07','2021-10-08',1,2,0,2,null);

INSERT INTO termin (datum, start_time, end_time, slobodan, pregled_id, odsustvo, sala_id, odsustvo_odmor_id)
VALUES ('2020-10-07','2021-10-08','2021-10-09',1,2,0,2,null);

INSERT INTO termin (datum, start_time, end_time, slobodan, pregled_id, odsustvo, sala_id, odsustvo_odmor_id)
VALUES ('2020-10-05','2021-10-07','2021-10-08',1,2,0,3,null);

INSERT INTO termin (start_time, end_time, sala_id,datum,odsustvo,slobodan)
VALUES ('2021-10-07','2021-10-08', 3,'2021-10-07',0,1);

INSERT INTO termin (start_time, end_time, sala_id,datum,odsustvo,slobodan)
VALUES ('2021-10-08','2021-10-09', 2 ,'2021-10-08',0 ,1);

INSERT INTO termin (start_time, end_time, sala_id,datum,odsustvo,slobodan)
VALUES ('2021-10-07','2021-10-08', 1 ,'2021-10-07',0,1);
*/

INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id,odsustvo,sala_id)
VALUES ('2020-02-13','2020-02-13 16:00:00','2020-02-13 07:00:00',0,1,0,null);

INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id,odsustvo,sala_id)
VALUES ('2020-02-13','2020-02-13 13:00:00','2020-02-13 08:00:00',1,1,0,null);


INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id,odsustvo,sala_id)
VALUES ('2020-02-08','2020-02-08 19:00:00','2020-02-08 17:30:00',1,2,0,null);


/*
INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id, odsustvo,sala_id)
VALUES ('2020-02-13','2020-02-13 07:40:00','2020-02-13 07:00:00',0,1,0,null);

INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id, odsustvo,sala_id)
VALUES ('2020-02-13','2020-02-13 08:20:00','2020-02-13 08:00:00',0,1,0,null);


INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id,odsustvo,sala_id)
VALUES ('2020-02-08','2020-02-08 19:00:00','2020-02-08 17:30:00',1,2,0,null);
*/


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

/*
INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id, odsustvo, sala_id, odsustvo_odmor_id)
VALUES ('2020-02-13','2020-02-13 16:00:00','2020-02-13 07:00:00',0,1,0,null,1);



INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id, odsustvo, sala_id, odsustvo_odmor_id)
VALUES ('2020-02-13','2020-02-13 13:00:00','2020-02-13 08:00:00',1,1,0,null,1);


INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id,odsustvo, sala_id, odsustvo_odmor_id)
VALUES ('2020-02-08','2020-02-08 19:00:00','2020-02-08 17:30:00',1,2,0,null,1);
*/

INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id, odsustvo)
VALUES ('2020-02-13','2020-02-13 07:40:00','2020-02-13 07:00:00',0,1,0);

INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id, odsustvo)
VALUES ('2020-02-13','2020-02-13 08:20:00','2020-02-13 09:00:00',0,1,0);


INSERT INTO termin (datum, end_time, start_time, slobodan, pregled_id,odsustvo)
VALUES ('2020-02-08','2020-02-08 19:00:00','2020-02-08 17:30:00',1,2,0);



INSERT INTO lekar_termin (lekar_id, termin_id)
VALUES (1,1);

INSERT INTO lekar_termin (lekar_id, termin_id)
VALUES (1,2);

INSERT INTO lekar_termin (lekar_id, termin_id)
VALUES (1,3);
/*
INSERT INTO izvestaj (id, text, recept_id)
VALUES (1,'',1);
*/
INSERT INTO pregled (nationality, email,town,emergency, first_name,jbo,kraj,done,deleted,operation,pocetak,visit,last_name,lekar_id,pacijent_id,termin_id,tip_pregleda_id)
VALUES ('Srb','nekimail@gmail.com','Novi Sad','hitno','Marko',7766890,'2020-02-08 12:20:00',0,0,0,'2020-02-08 13:21:00',0,'Markovic',1,1,1,1);

INSERT INTO pregled (nationality, email,town,emergency, first_name,jbo,kraj,done,deleted,operation,pocetak,visit,last_name,lekar_id,pacijent_id,termin_id,tip_pregleda_id)
VALUES ('Srb','nekimail@gmail.com','Novi Sad','hitno','Marko',7766890,'2020-03-08 17:55:00',0,0,0,'2020-03-08 18:55:00',0,'Markovic',1,1,1,1);



/*
INSERT INTO recept (ime_pacijenta, jbo_pacijenta, ime_lekara, klinika, overen)
VALUES ('Marko Markovic', '7766890', 'Jovan Jovanovic', 'KBC', 0);

INSERT INTO recept (ime_pacijenta, jbo_pacijenta, ime_lekara, klinika, overen)
VALUES ('Neki Drugi', '226220', 'Jovan Jovanovic', 'KBC', 0);
*/
INSERT INTO lek (naziv_leka, opis_leka)
VALUES ('Brufen 600mg', 'Lek za glavobolju');

INSERT INTO lek (naziv_leka, opis_leka)
VALUES ('Bromazemap 400mg', 'Lek za smirenje');
/*
INSERT INTO recept_lekovi (recept_id, lekovi_id)
VALUES (1, 1);

INSERT INTO recept_lekovi (recept_id, lekovi_id)
VALUES (1, 2);
*/


/*
INSERT INTO odsustvo_odmor (begin, end, vacation, absence, reason, lekar_id, sestra_id, termin_id)
VALUES ('2020-01-02','2020-01-03', 1, 0, 'HGGhasjd', 1, null, 1);

INSERT INTO odsustvo_odmor (begin, end, vacation, absence, reason, lekar_id, sestra_id, termin_id)
VALUES ('2020-01-02','2020-01-03', 0, 1, 'HGGhasjd', null, 1, 2);

INSERT INTO odsustvo_odmor (begin, end, vacation, absence, reason, lekar_id, sestra_id, termin_id)
VALUES ('2020-01-02','2020-01-03', 1, 0, 'HGGhasjd', null, 1, 3);

INSERT INTO odsustvo_odmor (begin, end, vacation, absence, reason, lekar_id, sestra_id, termin_id)
VALUES ('2020-01-02','2020-01-03', 1, 0, 'HGGhasjd', 2, null, 4);
*/


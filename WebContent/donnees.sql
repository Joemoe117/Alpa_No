INSERT INTO administrator (name, password) VALUES ('ballanb', 'admin');
INSERT INTO administrator (name, password) VALUES ('camenenj', 'admin');
INSERT INTO administrator (name, password) VALUES ('giboireg', 'admin');
INSERT INTO administrator (name, password) VALUES ('kerarvranl', 'admin');

INSERT INTO hotel (name) VALUES ('Le Palais des Émirats - Abu Dhabi - Émirats Arabes Unis');
INSERT INTO hotel (name) VALUES ('Hôtel Mardan Palace - Antalya - Turquie');
INSERT INTO hotel (name) VALUES ('Hôtel Westin Excelsior - Rome - Italie');
INSERT INTO hotel (name) VALUES ('Hôtel Burj Al Arab - Dubai - Émirats Arabes Unis');
INSERT INTO hotel (name) VALUES ('Hôtel Plaza - New York - États Unis');
INSERT INTO hotel (name) VALUES ('Atlantis Paradise Island - Paradise Island - Bahamas');
INSERT INTO hotel (name) VALUES ('Hôtel Palms - Las Vegas - États Unis');
INSERT INTO hotel (name) VALUES ('Hôtel The Boulders - Arizona - États Unis');
INSERT INTO hotel (name) VALUES ('Hôtel CuisinArt Golf Resort & Spa - Anguilla - Royaume Uni');
INSERT INTO hotel (name) VALUES ('Hôtel Secrets Marquis - Los Cabos - Mexique');

INSERT INTO plane (name) VALUES ('Airbus A318-111-F-GUGA ');
INSERT INTO plane (name) VALUES ('Airbus A330-203-F-GZCB ');
INSERT INTO plane (name) VALUES ('Airbus A340-311-F-GLZC ');
INSERT INTO plane (name) VALUES ('Airbus A340-313-F-GLZM ');
INSERT INTO plane (name) VALUES ('Airbus A320-211-F-GHQM ');
INSERT INTO plane (name) VALUES ('Airbus A380-861-MSN049 ');
INSERT INTO plane (name) VALUES ('Boeing 777-228/ER-F-GSPG ');
INSERT INTO plane (name) VALUES ('Boeing B747-428-F-GITF ');
INSERT INTO plane (name) VALUES ('Boeing B747-428ERF-F-GIUA ');

INSERT INTO flight (id_plane, description) VALUES (5, 'Paris-France -> Phoenix-États Unis (Air France)');
INSERT INTO flight (id_plane, description) VALUES (2, 'Nantes-France -> Londre-Royaume Uni (Corsaire)');
INSERT INTO flight (id_plane, description) VALUES (2, 'Londre-Royaume Uni -> Dubai-Émirats Arabes Unis (Corsaire)');
INSERT INTO flight (id_plane, description) VALUES (6, 'Ankara-Turquie -> Rome-Italie (Ryanair)');
INSERT INTO flight (id_plane, description) VALUES (7, 'Munich-Allemagne -> New York-États Unis (Lufthansa)');
INSERT INTO flight (id_plane, description) VALUES (1, 'Los Angeles-États Unis -> Cancun-Mexique (American Arilines)');
INSERT INTO flight (id_plane, description) VALUES (3, 'Londre-Royaume Uni -> Paris-France (British Airways)');
INSERT INTO flight (id_plane, description) VALUES (8, 'Marseille-France -> Paradise Island-Bahamas (KLM)');
INSERT INTO flight (id_plane, description) VALUES (4, 'Phoenix-États Unis -> New York-États Unis Unis (Sky Arilines)');
INSERT INTO flight (id_plane, description) VALUES (9, 'Madrid-Espagne -> Rome-Italie (Easyjet)');

INSERT INTO panel (id_flight, date_begin, date_end) VALUES (1, '2015-04-03 10:00:00', '2015-04-04 15:00:00');
INSERT INTO panel (id_flight, date_begin, date_end) VALUES (2, '2015-04-03 06:00:00', '2015-04-03 12:00:00');
INSERT INTO panel (id_flight, date_begin, date_end) VALUES (3, '2015-04-03 13:00:00', '2015-04-03 14:00:00');
INSERT INTO panel (id_flight, date_begin, date_end) VALUES (4, '2015-04-03 07:00:00', '2015-04-03 13:00:00');
INSERT INTO panel (id_flight, date_begin, date_end) VALUES (5, '2015-04-03 06:00:00', '2015-04-03 17:00:00');
INSERT INTO panel (id_flight, date_begin, date_end) VALUES (6, '2015-04-03 15:30:00', '2015-04-03 17:00:00');
INSERT INTO panel (id_flight, date_begin, date_end) VALUES (7, '2015-04-03 20:05:00', '2015-04-03 23:35:00');
INSERT INTO panel (id_flight, date_begin, date_end) VALUES (8, '2015-04-03 10:30:00', '2015-04-03 12:30:00');
INSERT INTO panel (id_flight, date_begin, date_end) VALUES (9, '2015-04-03 08:15:00', '2015-04-03 12:15:00');

INSERT INTO link_panel_hotel (id_panel, id_hotel) VALUES (1, 8);
INSERT INTO link_panel_hotel (id_panel, id_hotel) VALUES (2, 9);
INSERT INTO link_panel_hotel (id_panel, id_hotel) VALUES (3, 4);
INSERT INTO link_panel_hotel (id_panel, id_hotel) VALUES (4, 3);
INSERT INTO link_panel_hotel (id_panel, id_hotel) VALUES (5, 5);
INSERT INTO link_panel_hotel (id_panel, id_hotel) VALUES (6, 10);
INSERT INTO link_panel_hotel (id_panel, id_hotel) VALUES (7, 3);
INSERT INTO link_panel_hotel (id_panel, id_hotel) VALUES (8, 6);
INSERT INTO link_panel_hotel (id_panel, id_hotel) VALUES (9, 5);











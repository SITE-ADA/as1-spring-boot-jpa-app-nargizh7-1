INSERT INTO DIRECTORS(first_name, last_name) VALUES('Christopher', 'Nolan');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Quentin', 'Tarantino');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Steven', 'Spielberg');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Martin', 'Scorsese');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Alfred', 'Hitchcock');

INSERT INTO MOVIES(name, country, wins) VALUES('Inception', 'USA', 8.8);
INSERT INTO MOVIES(name, country, wins) VALUES('The Dark Knight', 'USA', 9.0);
INSERT INTO MOVIES(name, country, wins) VALUES('Interstellar', 'USA', 8.6);

INSERT INTO MOVIES(name, country, wins) VALUES('Pulp Fiction', 'USA', 8.9);
INSERT INTO MOVIES(name, country, wins) VALUES('Django Unchained', 'USA', 8.4);

INSERT INTO MOVIES(name, country, wins) VALUES('Jurassic Park', 'USA', 8.2);
INSERT INTO MOVIES(name, country, wins) VALUES('Schindlers List', 'USA', 9.0);

INSERT INTO MOVIES(name, country, wins) VALUES('The Departed', 'USA', 8.5);
INSERT INTO MOVIES(name, country, wins) VALUES('Goodfellas', 'USA', 8.7);

INSERT INTO MOVIES(name, country, wins) VALUES('Psycho', 'USA', 8.5);
INSERT INTO MOVIES(name, country, wins) VALUES('Rear Window', 'USA', 8.5);

-- Mapping directors to movies
INSERT INTO director_movie VALUES(1, 1);
INSERT INTO director_movie VALUES(1, 2);
INSERT INTO director_movie VALUES(1, 3);

INSERT INTO director_movie VALUES(2, 4);
INSERT INTO director_movie VALUES(2, 5);

INSERT INTO director_movie VALUES(3, 6);
INSERT INTO director_movie VALUES(3, 7);

INSERT INTO director_movie VALUES(4, 8);
INSERT INTO director_movie VALUES(4, 9);

INSERT INTO director_movie VALUES(5, 10);
INSERT INTO director_movie VALUES(5, 11);

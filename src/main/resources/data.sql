--INSERT INTO STUDENTS(first_name, last_name) VALUES('Sabrina-Maria', 'Sakka')
--INSERT INTO STUDENTS(first_name, last_name) VALUES('Ilaha', 'Behbudova')
--INSERT INTO STUDENTS(first_name, last_name) VALUES('Nuraddin', 'Sadili')
--INSERT INTO STUDENTS(first_name, last_name) VALUES('Emil', 'Huseynov')
--INSERT INTO STUDENTS(first_name, last_name) VALUES('Huseyn', 'Jabbarov')
--INSERT INTO STUDENTS(first_name, last_name) VALUES('Kanan', 'Gafarov')

-- to avoid duplicate of values (data folder)
--DELETE from MOVIES;

--INSERT INTO MOVIES(name, description, credits) VALUES('Inception', 'Sci-fi thriller', 6)
--INSERT INTO MOVIES(name, description, credits) VALUES('The Matrix', 'Cyberpunk action', 6)
--INSERT INTO MOVIES(name, description, credits) VALUES('Interstellar', 'Space exploration', 6)
--INSERT INTO MOVIES(name, description, credits) VALUES('The Dark Knight', 'Superhero drama', 6)
--INSERT INTO MOVIES(name, description, credits) VALUES('Avatar', 'Epic sci-fi', 6)

--INSERT INTO student_course VALUES(2, 2)
--INSERT INTO student_course VALUES(2, 5)
--INSERT INTO student_course VALUES(1, 1)
--INSERT INTO student_course VALUES(1, 3)
--INSERT INTO student_course VALUES(1, 4)
--INSERT INTO student_course VALUES(4, 2)
--INSERT INTO student_course VALUES(4, 3)
--INSERT INTO student_course VALUES(4, 5)

INSERT INTO DIRECTORS(first_name, last_name) VALUES('Christopher', 'Nolan');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Quentin', 'Tarantino');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Steven', 'Spielberg');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Martin', 'Scorsese');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Alfred', 'Hitchcock');

INSERT INTO MOVIES(name, country, wins) VALUES('Inception', 'USA', 8.8);
INSERT INTO MOVIES(name, country, wins) VALUES('Pulp Fiction', 'USA', 8.9);
INSERT INTO MOVIES(name, country, wins) VALUES('Jurassic Park', 'USA', 8.2);
INSERT INTO MOVIES(name, country, wins) VALUES('The Departed', 'USA', 8.5);
INSERT INTO MOVIES(name, country, wins) VALUES('Psycho', 'USA', 8.5);

INSERT INTO director_movie VALUES(1, 1);
INSERT INTO director_movie VALUES(2, 2);
INSERT INTO director_movie VALUES(3, 3);
INSERT INTO director_movie VALUES(4, 4);
INSERT INTO director_movie VALUES(5, 5);

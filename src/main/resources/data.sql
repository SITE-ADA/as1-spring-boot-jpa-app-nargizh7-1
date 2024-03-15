-- Inserting directors
INSERT INTO DIRECTORS(first_name, last_name) VALUES('John', 'Smith');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Jane', 'Doe');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Alice', 'Johnson');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Bob', 'Brown');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('Carol', 'Davis');
INSERT INTO DIRECTORS(first_name, last_name) VALUES('David', 'Wilson');

-- Inserting movies
INSERT INTO MOVIES(title, description, director_id) VALUES('Epic Adventure', 'An epic adventure of discovery', 1);
INSERT INTO MOVIES(title, description, director_id) VALUES('Space Odyssey', 'A journey through space', 2);
INSERT INTO MOVIES(title, description, director_id) VALUES('Romantic Escape', 'A tale of love and escapism', 3);
INSERT INTO MOVIES(title, description, director_id) VALUES('Comedy Nights', 'A comedic journey through life', 4);
INSERT INTO MOVIES(title, description, director_id) VALUES('Horror Thriller', 'A spine-chilling horror movie', 5);

-- Assuming a relationship table between movies and directors is needed, similar to student_course
--INSERT INTO movie_director VALUES(movie_id, director_id);
-- The values for movie_id and director_id would need to be updated to match the actual IDs in your database.

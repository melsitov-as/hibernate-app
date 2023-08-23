CREATE TABLE Actor (
    id int AUTO_INCREMENT,
    name varchar(128) NOT NULL UNIQUE,
    age int CHECK (age > 0),
    PRIMARY KEY (id)
);

CREATE TABLE Movie (
    id int AUTO_INCREMENT,
    name varchar(128) NOT NULL UNIQUE,
    year_of_production int CHECK (year_of_production > 1900),
    PRIMARY KEY (id)
);

CREATE TABLE Actor_Movie (
	actor_id int,
    movie_id int,
    PRIMARY KEY(actor_id, movie_id),
    FOREIGN KEY (actor_id) REFERENCES Actor(id),
    FOREIGN KEY (movie_id) REFERENCES Movie(id)
);
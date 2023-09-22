CREATE DATABASE human_friends;
USE human_friends;

DROP TABLE IF EXISTS typeanimals;
CREATE TABLE typeanimals (
id INT PRIMARY KEY AUTO_INCREMENT,
typename VARCHAR(20) NOT NULL
);
INSERT INTO typeanimals
(typename)
VALUES
	("homeanimals"), ("packanimals");
 
DROP TABLE IF EXISTS vidanimals;
CREATE TABLE vidanimals (
id INT PRIMARY KEY AUTO_INCREMENT,
vidname VARCHAR(20) NOT NULL,
type_id INT,
FOREIGN KEY (type_id) REFERENCES typeanimals (id) ON DELETE CASCADE);
INSERT INTO vidanimals
(vidname, type_id)
VALUES
	("cats", 1), ("dogs", 1), ("horses", 2), ("camels", 2), ("donkeys", 2), ("hamsters", 1);
    
DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
id INT PRIMARY KEY AUTO_INCREMENT,
nickname VARCHAR(20) NOT NULL,
date_birth DATE NOT NULL,
command VARCHAR(10) NOT NULL,
vid_id INT,
FOREIGN KEY (vid_id) REFERENCES vidanimals (id) ON DELETE CASCADE);
INSERT INTO animals
(nickname, date_birth, command, vid_id)
VALUES
	("Murka", "2001-06-30", "walk", 1),
    ("Belka", "200-05-09", "voice", 2),
    ("Mushka", "2002-07-05", "sit", 3),
    ("Grisha", "2000-04-05", "go", 4),
    ("Boris", "2003-10-29", "chew", 6),
    ("Stepan", "2004-01-01", "gogo", 5),
    ("Strelka", "2002-08-31", "go", 4);

DROP TABLE IF EXISTS all_animals;
CREATE TABLE all_animals SELECT nickname, date_birth, command, vidname, typename  FROM animals JOIN vidanimals ON (animals.vid_id=vidanimals.id)
JOIN typeanimals ON (vidanimals.type_id=typeanimals.id);
SELECT * FROM all_animals;

DROP TABLE IF EXISTS no_camel;
CREATE TABLE no_camel SELECT * FROM all_animals WHERE vidname!="camels";
ALTER TABLE no_camel CHANGE nickname nickname1 VARCHAR(20),
					 CHANGE date_birth date_birth1 DATE, 
                     CHANGE command command1 VARCHAR(20), 
                     CHANGE vidname vidname1 VARCHAR(20),
                     CHANGE typename typename1 VARCHAR(20);
SELECT * FROM no_camel;

DROP VIEW IF EXISTS horse_donkey;
CREATE VIEW horse_donkey AS WITH all_1 AS (SELECT * FROM no_camel)
SELECT * FROM all_1 WHERE vidname1 IN ("horses", "donkeys");
SELECT * FROM horse_donkey;

DROP TABLE IF EXISTS youngall; 
CREATE TABLE youngall AS WITH age_1 AS (SELECT * FROM no_camel WHERE date_birth1 BETWEEN "2001-12-30" AND "2003-12-30"), age_2 AS
(SELECT *, TIMESTAMPDIFF(YEAR, date_birth1, "2004-12-30") AS year1, TIMESTAMPDIFF(MONTH, date_birth1, "2004-12-30") AS month1
FROM age_1)
SELECT *, IF(year1!=0, month1-(year1*12), month1) AS month FROM age_2;
ALTER TABLE youngall CHANGE nickname1 nickname2 VARCHAR(20),
					 CHANGE date_birth1 date_birth2 DATE, 
                     CHANGE command1 command2 VARCHAR(20), 
                     CHANGE vidname1 vidname2 VARCHAR(20),
					 CHANGE typename1 typename2 VARCHAR(20);
ALTER TABLE youngall DROP COLUMN month1;      
SELECT * FROM youngall;

DROP TABLE IF EXISTS all_history; 
CREATE TABLE all_history SELECT nickname, date_birth, command, vidname, typename, year1, month FROM youngall RIGHT JOIN no_camel ON (youngall.nickname2=no_camel.nickname1) 
RIGHT JOIN all_animals ON (no_camel.nickname1=all_animals.nickname);
SELECT * FROM all_history;
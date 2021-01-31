--Debug point: Resetting everything
drop TABLE Course CASCADE CONSTRAINTS;
drop TABLE Instructor CASCADE CONSTRAINTS;
drop TABLE Teaches CASCADE CONSTRAINTS;

-- Created empty tables
CREATE TABLE Course (
       dept VARCHAR(6),
       Num INTEGER,
       title VARCHAR(75),
       PRIMARY KEY (dept, num));

CREATE TABLE Instructor (
       username VARCHAR(8),
       fname VARCHAR(50),
       lname VARCHAR(50),
       started_on CHAR(10),
       PRIMARY KEY (username));

CREATE TABLE Teaches (
       username VARCHAR(8),
       dept VARCHAR(6),
       num INTEGER,
       PRIMARY KEY (username, dept, num),
       FOREIGN KEY (username) REFERENCES Instructor(username),
       FOREIGN KEY (dept, num) REFERENCES Course(dept, num));


-- Debug Point: Verifying that the empty tables are created correctly 
SELECT *
FROM Course;
SELECT *
FROM Instructor;
SELECT *
FROM Teaches;


-- Populating tables (inserting data)
INSERT INTO Course VALUES('SEIS', 601, 'Introduction to Java');
INSERT INTO Course VALUES('SEIS', 602, 'Intermediate Java');
INSERT INTO Course VALUES('SEIS', 630, 'Introduction to DBMS');

INSERT INTO Instructor VALUES('level', 'Eric', 'Level', '1985-01-01');
INSERT INTO Instructor VALUES('ali', 'Ali', 'Naqvi', '1999-07-01');
INSERT INTO Instructor VALUES('michael', 'Michael', 'Dorin','1997-10-01');
INSERT INTO Instructor VALUES('jeff', 'Jeff', 'Skochil','1988-04-01');
INSERT INTO Instructor VALUES('ron', 'Ron', 'Chiang','1980-04-01');

INSERT INTO Teaches VALUES('level', 'SEIS', 601);
INSERT INTO Teaches VALUES('ali', 'SEIS', 602);
INSERT INTO Teaches VALUES('michael', 'SEIS', 602);
INSERT INTO Teaches VALUES('jeff', 'SEIS', 630);
INSERT INTO Teaches VALUES('ron', 'SEIS', 630);


-- Debug Point: Verifying that the table are populated correctly 
SELECT *
FROM Course;
SELECT *
FROM Instructor;
SELECT *
FROM Teaches;

-------------------Analysis ----------------------------------------------
-- What courses are offered?
SELECT a.title
FROM Course a;

-- Top two class by instructor name sorted (a first)
SELECT *
FROM Teaches 
ORDER BY username ASC
FETCH FIRST 2 ROWS ONLY;

-- Top two classes by instructor name sorted in reverse (z first)
SELECT *
FROM Teaches 
ORDER BY username DESC
FETCH FIRST 2 ROWS ONLY;

-- What's the first name of the instructor with username 'zahorjan'?
SELECT a.fname
FROM Instructor a
WHERE a.username = 'zahorjan';

-- What's the first name of the instructor with username 'zahorjan'? 
-- Using as keyword to give Instructor table name an alias -> inst
SELECT inst.fname
FROM Instructor inst
WHERE inst.username = 'zahorjan';

-- What 620+ level SEIS classes are offered?
SELECT *
FROM Course
WHERE dept = 'SEIS' 
AND num >= '620';

-- What classes are taught by levy or djw
SELECT *
FROM Teaches
WHERE username = 'levy' OR username = 'djw';

-- What classes have titles starting with Introduction?
SELECT *
FROM Course
WHERE title LIKE 'Introduction%'; -- LIKE operator does pattern matching 


-- Show the class titles and their lengths.
SELECT a.title, LENGTH(title)AS StringLength
FROM Course a;

-- Truncate all class titles to 12 characters.
SELECT a.title AS OriginalTitle, SUBSTR(title, 1, 12) AS ShortenedTitle
FROM Course a;

-- Which instructors started before 1990?
SELECT *
FROM Instructor
WHERE started_on < '1990-01-01';

-- Which instructors started before now?
SELECT *
FROM Instructor
WHERE started_on < 'now';




-- Creating the database
CREATE DATABASE MyDatabaseModel -- Syntax:CREATE DATABASE DatabaseName;

-----------------------1st; we write SQL codes for creating the tables 
-----------------------for all entities found on the ERD Rev5
--From Page1
CREATE TABLE AllAttributes(
-- first; we define all the columns of the table; each column requires both a name & datatype
AttributeName VARCHAR(20),
DataType VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (AttributeName));
--ON DELETE CASCADE));

CREATE TABLE EntityAttributes(
-- first; we define all the columns of the table; each column requires both a name & datatype
AttributeName VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (AttributeName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName));

CREATE TABLE RelationshipAttributes(
-- first; we define all the columns of the table; each column requires both a name & datatype
AttributeName VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (AttributeName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName));

--From Page2
CREATE TABLE AllKeys(
-- first; we define all the columns of the table; each column requires both a name & datatype 
KeyType VARCHAR(20),
AttributeName VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (AttributeName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName));

--From Page4
CREATE TABLE AllEntities (
-- first; we define all the columns of the table; each column requires both a name & datatype
EntityName VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (EntityName));

--From Page5
CREATE TABLE Inheritance (
-- first; we define all the columns of the table; each column requires both a name & datatype
SuperClass_EntityName VARCHAR(20),
SubClass_EntityName VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (SuperClass_EntityName, SubClass EntityName),
FOREIGN KEY (SuperClass_EntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (SubClass_EntityName) REFERENCES AllEntities(EntityName));

--From Pages 6&7

CREATE TABLE AllRelationships(
-- first; we define all the columns of the table; each column requires both a name & datatype
RelationshipName VARCHAR(20),
LSideEntityName VARCHAR(20),
RSideEntityName VARCHAR(20),
LSideEntityCardinality VARCHAR(1),
RSideEntityCardinality VARCHAR(1),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (RelationshipName),
FOREIGN KEY (LSideEntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (RSideEntityName) REFERENCES AllEntities(EntityName));

----------------- 2nd; we write SQL codes for creating the tables for all the relationships
----------------- found on the ERD Rev 5
-- From Page3
CREATE TABLE AllAttributesAttributeTypes(
-- first; we define all the columns of the table; each column requires both a name & datatype
Pkey INTEGER,
AttributeName VARCHAR(20),
DataType VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (Pkey),
FOREIGN KEY(AttributeName) REFERENCES AllAttributes(AttributeName));

--From Page8
CREATE TABLE AllRelationships_Has_RelationshipAttributes(
-- first; we define all the columns of the table; each column requires both a name & datatype
RelationshipName VARCHAR(20),
AttributeName VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (RelationshipName, AttributeName),
FOREIGN KEY (RelationshipName) REFERENCES AllRelationships(RelationshipName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName)); 
-- From: FOREIGN KEY (AttributeName) REFERENCES RelationshipAttributes(AttributeName)); 
---To: FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName)); 
-- Reason:Part 6's query for (8.) made me recorrect part 3's code. FK cannot refer to another FK; FK must always refer only to PK 

--From Page9
CREATE TABLE AllEntities_Has_AllKeys(
-- first; we define all the columns of the table; each column requires both a name & datatype
EntityName VARCHAR(20),
AttributeName VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (EntityName, AttributeName),
FOREIGN KEY (EntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (AttributeName) REFERENCES AllKeys(AttributeName));

--From Page10
CREATE TABLE AllEntities_Has_AllRelationships(
-- first; we define all the columns of the table; each column requires both a name & datatype
EntityName VARCHAR(20),
RelationshipName VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (EntityName,RelationshipName),
FOREIGN KEY (EntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (RelationshipName) REFERENCES AllRelationships(RelationshipName));

--From Page11
CREATE TABLE AllEntities_Has_AllAttributes
-- first; we define all the columns of the table; each column requires both a name & datatype
EntityName VARCHAR(20),
AttributeName VARCHAR(20),
--last; we define all the key constraints (pk & fk's) for all the columns of the table
PRIMARY KEY (EntityName, AttributeName),
FOREIGN KEY (EntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName));

-- From: FOREIGN KEY (AttributeName) REFERENCES EntityAttributes(AttributeName));
---To: FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName));
-- Reason:Part 6's query for (17.) made me recorrect part 3's code. FK cannot refer to another FK; FK must always refer only to PK 

-- Part 6's query for (25. Print the name of all composite attributes and the attributes they contain in the ABC Diagram.)
-- caused Part 3 to include a new table to handle composite attributes
-- New Table was created in part 6 to handle composite attributes
CREATE TABLE AllCompositeAttributes_Has_AllEntities(
EntityName VARCHAR (20),
CompositeAttributeName VARCHAR (20),
PRIMARY KEY(CompositeAttributeName),
FOREIGN KEY (EntityName) REFERENCES AllEntities(EntityName));

INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Employee','Name');
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Employee','Address');








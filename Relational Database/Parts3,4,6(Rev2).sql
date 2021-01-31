-- debug point; restarting everything
DROP TABLE AllAttributes CASCADE CONSTRAINTS; 
DROP TABLE EntityAttributes CASCADE CONSTRAINTS; 
DROP TABLE RelationshipAttributes CASCADE CONSTRAINTS; 
DROP TABLE AllKeys CASCADE CONSTRAINTS; 
DROP TABLE AllEntities CASCADE CONSTRAINTS; 
DROP TABLE Inheritance CASCADE CONSTRAINTS; 
DROP TABLE AllRelationships CASCADE CONSTRAINTS;
DROP TABLE AllAttributesAttributeTypes CASCADE CONSTRAINTS;
DROP TABLE AllRelationships_Has_RelationshipAttributes CASCADE CONSTRAINTS; 
DROP TABLE AllEntities_Has_AllRelationships CASCADE CONSTRAINTS;
DROP TABLE AllEntities_Has_AllKeys CASCADE CONSTRAINTS;
DROP TABLE AllEntities_Has_AllAttributes CASCADE CONSTRAINTS;
DROP TABLE AllCompositeAttributes_Has_AllEntities CASCADE CONSTRAINTS;





-- From Part3; Creating table
CREATE TABLE AllEntities (
EntityName VARCHAR(20),
PRIMARY KEY (EntityName));

CREATE TABLE AllAttributes(
AttributeName VARCHAR(20),
DataType VARCHAR(20),
PRIMARY KEY (AttributeName));

CREATE TABLE EntityAttributes(
AttributeName VARCHAR(20),
PRIMARY KEY (AttributeName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName));

CREATE TABLE RelationshipAttributes(
AttributeName VARCHAR(20),
PRIMARY KEY (AttributeName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName));

CREATE TABLE AllKeys(
KeyType VARCHAR(20),
AttributeName VARCHAR(20),
PRIMARY KEY (AttributeName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName));

CREATE TABLE Inheritance (
SuperClass_EntityName VARCHAR(20),
SubClass_EntityName VARCHAR(20),
PRIMARY KEY (SuperClass_EntityName, SubClass_EntityName),
FOREIGN KEY (SuperClass_EntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (SubClass_EntityName) REFERENCES AllEntities(EntityName));

CREATE TABLE AllRelationships(
RelationshipName VARCHAR(20),
LSideEntityName VARCHAR(20),
RSideEntityName VARCHAR(20),
LSideEntityCardinality VARCHAR(1),
RSideEntityCardinality VARCHAR(1),
PRIMARY KEY (RelationshipName),
FOREIGN KEY (LSideEntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (RSideEntityName) REFERENCES AllEntities(EntityName));

CREATE TABLE AllAttributesAttributeTypes(
Pkey INTEGER,
AttributeName VARCHAR(20),
DataType VARCHAR(20),
PRIMARY KEY (Pkey),
FOREIGN KEY(AttributeName) REFERENCES AllAttributes(AttributeName));

CREATE TABLE AllRelationships_Has_RelationshipAttributes(
RelationshipName VARCHAR(20),
AttributeName VARCHAR(20),
PRIMARY KEY (RelationshipName, AttributeName),
FOREIGN KEY (RelationshipName) REFERENCES AllRelationships(RelationshipName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName)); 

/* Rows were inserted but table was blank so the code was updated
FOREIGN KEY (AttributeName) REFERENCES RelationshipAttributes(AttributeName)); 
*/

CREATE TABLE AllEntities_Has_AllKeys(
EntityName VARCHAR(20),
AttributeName VARCHAR(20),
PRIMARY KEY (EntityName, AttributeName),
FOREIGN KEY (EntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (AttributeName) REFERENCES AllKeys(AttributeName));

CREATE TABLE AllEntities_Has_AllRelationships(
EntityName VARCHAR(20),
RelationshipName VARCHAR(20),
PRIMARY KEY (EntityName,RelationshipName),
FOREIGN KEY (EntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (RelationshipName) REFERENCES AllRelationships(RelationshipName));

CREATE TABLE AllEntities_Has_AllAttributes(
EntityName VARCHAR(20),
AttributeName VARCHAR(20),
PRIMARY KEY (EntityName, AttributeName),
FOREIGN KEY (EntityName) REFERENCES AllEntities(EntityName),
FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName));
/* Rows were inserted but table was blank so the code was updated
/*
FOREIGN KEY (AttributeName) REFERENCES EntityAttributes(AttributeName));
*/


--Consider 011 (Track Changes From Rev1 to Rev2) -- MADE STRUCTURAL CHANGES TO THE TABLE
-- New Table was created in part 6 to handle composite attributes
/*
CREATE TABLE AllCompositeAttributes_Has_AllEntities(
EntityName VARCHAR (20),
CompositeAttributeName VARCHAR (20),
PRIMARY KEY(CompositeAttributeName),
FOREIGN KEY (EntityName) REFERENCES AllEntities(EntityName));
*/
CREATE TABLE AllCompositeAttributes_Has_AllEntities(
CompositeEntityName VARCHAR (20),
CompositeAttributeName VARCHAR (20),
PRIMARY KEY(CompositeEntityName,CompositeAttributeName));



--MyReview Consider 014 (Track Changes From Rev1 to Rev2) -- MADE TABLE STRUCTURE CHANGES (Added new table to handle Query #15)
CREATE TABLE Derived_Attributes(
DerivedAttributeName VARCHAR(20),
DerivedFromAttributeName VARCHAR(20),
PRIMARY KEY(DerivedAttributeName,DerivedFromAttributeName VARCHAR(20));

--MyReview Consider 017 (Track Changes From Rev1 to Rev2) -- MADE TABLE STRUCTURE CHANGES to make the query results display correctly
CREATE TABLE Table_For_Query27 (
Id INTEGER,
TableName VARCHAR(50),
ColumnName VARCHAR(50),
PRIMARY KEY (Id));
-------------------------------------------------------------------------------------





-- debug point; verifying that all the tables are created & also empty
-- Data was inserted into these tables using Insert Statements
SELECT *
FROM AllEntities;
SELECT *
FROM AllAttributes;
SELECT *
FROM AllRelationships;
SELECT *
FROM AllRelationships_Has_RelationshipAttributes;
SELECT *
FROM AllEntities_Has_AllAttributes;
SELECT *
FROM Inheritance;
SELECT *
FROM AllEntities_Has_AllKeys;
SELECT *
FROM AllCompositeAttributes_Has_AllEntities;
SELECT *
FROM AllEntities_Has_AllAttributes;
-- Data wasnt inserted into these tables using Insert Statements
SELECT *
FROM EntityAttributes;
SELECT *
FROM AllAttributesAttributeTypes;
SELECT *
FROM AllKeys;
SELECT *
FROM AllEntities_Has_AllRelationships;










--Prom Part4:Loading Data into the created tables
INSERT INTO AllEntities VALUES('Employee');
INSERT INTO AllEntities VALUES('Associate') ;
INSERT INTO AllEntities VALUES('TempHourly');
INSERT INTO AllEntities VALUES('Contractor');
INSERT INTO AllEntities VALUES('Promotion');
INSERT INTO AllEntities VALUES('Display');
INSERT INTO AllEntities VALUES('Store');
INSERT INTO AllEntities VALUES('Region');
INSERT INTO AllEntities VALUES('Product');





--Consider 001,007(Track Changes From Rev1 to Rev2)
INSERT INTO AllAttributes VALUES('Name','String');

--Consider 008 (Track Changes From Rev1 to Rev2)
INSERT INTO AllAttributes VALUES('Address','String');

INSERT INTO AllAttributes VALUES ('Date','Date');

--My Review Consider 015 (Added StartDate, EndDate and DOB) are they are date related attributes)-----
-- Changed the datatype for all the date related attributes to Date
/*
INSERT INTO AllAttributes VALUES('DOB','String');
INSERT INTO AllAttributes VALUES('StartDate','String');
INSERT INTO AllAttributes VALUES('EndDate','String');
*/
INSERT INTO AllAttributes VALUES('DOB','Date');
INSERT INTO AllAttributes VALUES('StartDate','Date');
INSERT INTO AllAttributes VALUES('EndDate','Date');
------------------------------------------------------------------------------------------------------------


INSERT INTO AllAttributes VALUES('Fname','String');
INSERT INTO AllAttributes VALUES('Minit','String');
INSERT INTO AllAttributes VALUES('Lname','String');
INSERT INTO AllAttributes VALUES('SSN','String');
INSERT INTO AllAttributes VALUES('Age','Integer');
INSERT INTO AllAttributes VALUES('Sex','String');
INSERT INTO AllAttributes VALUES('Address','String');
INSERT INTO AllAttributes VALUES('Street','String');
INSERT INTO AllAttributes VALUES('City','String');
INSERT INTO AllAttributes VALUES('State','String');
INSERT INTO AllAttributes VALUES('Zip','String');
INSERT INTO AllAttributes VALUES('Aphone','String');
INSERT INTO AllAttributes VALUES('Title','String');
INSERT INTO AllAttributes VALUES('AEmail','String');
INSERT INTO AllAttributes VALUES('Salary','Integer');
INSERT INTO AllAttributes VALUES('ProName','String');
INSERT INTO AllAttributes VALUES('Specialty','String');
INSERT INTO AllAttributes VALUES('JobTitle','String');
INSERT INTO AllAttributes VALUES('Aisle','Integer');
INSERT INTO AllAttributes VALUES('Row','Integer');
INSERT INTO AllAttributes VALUES('Section','Integer');
INSERT INTO AllAttributes VALUES('SKU#','Integer');
INSERT INTO AllAttributes VALUES('PGroup','Integer');
INSERT INTO AllAttributes VALUES('PrdName','String');
INSERT INTO AllAttributes VALUES('Size','String');
INSERT INTO AllAttributes VALUES('SAddress','String');
INSERT INTO AllAttributes VALUES('Store#','Integer');
INSERT INTO AllAttributes VALUES('RName','String');
INSERT INTO AllAttributes VALUES('RId#','Integer');

--Consider 002,003,009 (Track Changes From Rev1 to Rev2)
-- My Review COnsider 012  (Track Changes From Rev1 to Rev2)
INSERT INTO AllRelationships VALUES('Disjoint-OR','Employee','Associate','1','1'); 
INSERT INTO AllRelationships VALUES('Disjoint-OR1','Employee','TempHourly','1','1');
INSERT INTO AllRelationships VALUES('Disjoint-OR2','Contractor','TempHourly','1','1');

INSERT INTO AllRelationships VALUES('WorksIn','Associate','Store','M','1');
INSERT INTO AllRelationships VALUES('Manages','Associate','Store','1','1');


INSERT INTO AllRelationships VALUES('Owns','Associate','Promotion','M','N'); 
INSERT INTO AllRelationships VALUES('Hires','Associate','Contractor','1','M');
INSERT INTO AllRelationships VALUES('WorksOn','Promotion','Contractor','M','N');
INSERT INTO AllRelationships VALUES('Schedules','Associate','Display','1','M');
INSERT INTO AllRelationships VALUES('AssignedTo','Store','TempHourly','1','M'); 
INSERT INTO AllRelationships VALUES('Designs','Contractor','Display','M','N'); 
INSERT INTO AllRelationships VALUES('Builds','TempHourly','Display','N','M'); 
INSERT INTO AllRelationships VALUES('Stock','TempHourly','Display','N','M'); 
INSERT INTO AllRelationships VALUES('Contains','Display','Product','1','M');
INSERT INTO AllRelationships VALUES('Offers','Store','Product','1','M');
INSERT INTO AllRelationships VALUES('IsWithin','Region','Store','1','M'); 

INSERT INTO AllRelationships_Has_RelationshipAttributes VALUES('Builds','Date');


-- Consider 008 (Track Changes From Rev1 to Rev2)
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','Name'); -- composite attribute
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','Address'); -- composite attribute


INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','Fname');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','Minit');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','Lname');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','SSN');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','Age');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','DOB');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','Sex');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','Street');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','City');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','State');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Employee','Zip');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Associate','Aphone');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Associate','Title');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Associate','AEmail');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Associate','Salary');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Promotion','ProName');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Promotion','StartDate');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Promotion','EndDate');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Contractor','Specialty');
INSERT INTO AllEntities_Has_AllAttributes VALUES('TempHourly','JobTitle');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Display','Section');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Display','Row');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Display','Aisle');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Product','SKU#');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Product','PrdName');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Product','PGroup');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Store','Store#');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Store','SAddress');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Store','Size');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Region','RName');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Region','RId#');



----------MyReview Consider 016 (Track Changes From Rev1 to Rev2)-----------
--This is correct; Employee(Superclass) ISA Associate (Subclass)
INSERT INTO Inheritance VALUES('Employee', 'Associate'); 

--This is wrong; Employee (Superclass) ISA Contractor (Subclass)
/*
INSERT INTO Inheritance VALUES('Employee', 'TempHourly');
*/
INSERT INTO Inheritance VALUES('Employee', 'Contractor');

--This is wrong; Contractor (Superclass) ISA TempHourly (Subclass)
/*
INSERT INTO Inheritance VALUES('TempHourly', 'Contractor');
*/
INSERT INTO Inheritance VALUES('Contractor', 'TempHourly');

-------------------------------------------------------------------------------------



-- First "All Entities" was inserted
-- Second "AllRelationships_Has_RelationshipAttributes" was inserted; generated
-- ORA-02291 which means that integrity constraint violated-parent key aka 
-- (AllRelationships_Has_RelationshipAttributes ) Tables foreign keys are
-- FOREIGN KEY (RelationshipName) REFERENCES AllRelationships(RelationshipName),
-- FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName)); 
-- which means we must insert data into the (AllRelationships & All Attributes Tables) first
-- and then insert data into the (AllRelationships_Has_RelationshipAttributes) last to 
-- avoid ORA-02291  error code

INSERT INTO AllKeys VALUES('Primary','SSN');
INSERT INTO AllKeys VALUES('Primary','ProName');  
INSERT INTO AllKeys VALUES('Primary','Aisle'); 
INSERT INTO AllKeys VALUES('Primary','Row');  
INSERT INTO AllKeys VALUES('Primary','Section'); 
INSERT INTO AllKeys VALUES('Primary','SKU#');  
INSERT INTO AllKeys VALUES('Primary','Store#'); 
INSERT INTO AllKeys VALUES('Primary','RName'); 

INSERT INTO AllEntities_Has_AllKeys VALUES('Employee','SSN');
INSERT INTO AllEntities_Has_AllKeys VALUES('Promotion','ProName'); 
INSERT INTO AllEntities_Has_AllKeys VALUES('Display','Section'); 
INSERT INTO AllEntities_Has_AllKeys VALUES('Display','Row');  
INSERT INTO AllEntities_Has_AllKeys VALUES('Display','Aisle');  
INSERT INTO AllEntities_Has_AllKeys VALUES('Product','SKU#');  
INSERT INTO AllEntities_Has_AllKeys VALUES('Store','Store#');  
INSERT INTO AllEntities_Has_AllKeys VALUES('Region','RName');  

--Consider 011 (Track Changes From Rev1 to Rev2)
-- Deleted these incorrect insert statements as it didnt reflect what query #25 was asking
/*
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Employee','Name');
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Employee','Address');
*/
--Consider 011 (Track Changes From Rev1 to Rev2)
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Name','Fname');
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Name','Minit');
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Name','Lname');
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Address','Street');
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Address','City');
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Address','State');
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Address','Zip');




--MyReview Consider 014 (Track Changes From Rev1 to Rev2) -- MADE TABLE STRUCTURE CHANGES (Added new table to handle Query #15)
INSERT INTO  Derived_Attributes VALUES('Age','DOB');



--MyReview Consider 017 (Track Changes From Rev1 to Rev2) -- MADE TABLE STRUCTURE CHANGES to make the query results display correctly
INSERT INTO Table_For_Query27 VALUES(0,'ALLENTITIES','EntityName');

INSERT INTO Table_For_Query27 VALUES(1,'ALLATTRIBUTES','AttributeName');
INSERT INTO Table_For_Query27 VALUES(2,'','DataType');

INSERT INTO Table_For_Query27 VALUES(3,'ALLRELATIONSHIPS','RelationshipName');
INSERT INTO Table_For_Query27 VALUES(4,'','LSideEntityname');
INSERT INTO Table_For_Query27 VALUES(5,'','RSideEntityname');
INSERT INTO Table_For_Query27 VALUES(6,'','LSideEntityCardinality');
INSERT INTO Table_For_Query27 VALUES(7,'','RSideEntityCardinality');


INSERT INTO Table_For_Query27 VALUES(8,'ALLENTITIES_HAS_ALLATTRIBUTES','EntityName');
INSERT INTO Table_For_Query27 VALUES(9,'','RelationshipName');

INSERT INTO Table_For_Query27 VALUES(10,'INHERITANCE','SuperClass_EntityName');
INSERT INTO Table_For_Query27 VALUES(11,'' ,'SubClass_EntityName');

INSERT INTO Table_For_Query27 VALUES(12,'ALLKEYS','KeyType');
INSERT INTO Table_For_Query27 VALUES(13,'' ,'AttributeName');

INSERT INTO Table_For_Query27 VALUES(14,'ALLENTITIES_HAS_ALLKEYS','EntityName');
INSERT INTO Table_For_Query27 VALUES(15,'','AttributeName');

INSERT INTO Table_For_Query27 VALUES(16,'ALLLCOMPOSITEATTRIBUTES_HAS_ALLENTITIES','CompositeEntityName');
INSERT INTO Table_For_Query27 VALUES(17,'','CompositeAttributeName');

INSERT INTO Table_For_Query27 VALUES(18,'DERIVEDATTRIBUTES','DerivedAttributeName');
INSERT INTO Table_For_Query27 VALUES(19,'','DerivedFromAttributeName');
-------------------------------------------------------------------------------------





-- debug point; verifying that all the created tables are populated
-- Data was inserted into these tables using Insert Statements
SELECT *
FROM AllEntities;
SELECT *
FROM AllAttributes;
SELECT *
FROM AllRelationships;
SELECT *
FROM AllRelationships_Has_RelationshipAttributes;
SELECT *
FROM AllEntities_Has_AllAttributes;
SELECT *
FROM Inheritance;
SELECT *
FROM AllEntities_Has_AllKeys;
SELECT *
FROM AllCompositeAttributes_Has_AllEntities;
SELECT *
FROM AllEntities_Has_AllAttributes;
-- Data wasnt inserted into these tables using Insert Statements
SELECT *
FROM EntityAttributes;
SELECT *
FROM AllAttributesAttributeTypes;
SELECT *
FROM AllKeys;
SELECT *
FROM AllEntities_Has_AllRelationships;












--Part6: Creating Queries
--1. Print the name of all entities in the picture.
SELECT  A.EntityName
FROM AllEntities A;

--2. Print the name of all attributes in the ABC Diagram.
SELECT a.AttributeName
FROM AllAttributes a;

--3. Print the name of all relationships and the two entities they relate in the ABC Diagram.
SELECT a.RelationshipName, a.LSideEntityName, a.RSideEntityName
FROM AllRelationships a;

--4. Print the name of all relationships and the two entities they relate and the cardinality 
--for each side of the relationship in the ABC Diagram.
SELECT a.RelationshipName, a.LSideEntityName, a.LSideEntityCardinality, a.RSideEntityName, a.RSideEntityCardinality
FROM AllRelationships a;
-- My Review COnsider 012  (Track Changes From Rev1 to Rev2)


--5. Print the name of all relationships that have a cardinality of 1-to-1 in the ABC Diagram.
-- ONLY MODIFIED SELECT SO THIS IS A CASE OF REFACTORING (CHANGES THAT DONT AFFECT THE UNDERLYING BEHAVIOUR OF THE QUERY)
/*SELECT a.RelationshipName, a.LSideEntityCardinality, a.RSideEntityCardinality */
SELECT a.RelationshipName, a.LSideEntityName, a.RSideEntityName 
FROM AllRelationships a
WHERE a.LSideEntityCardinality = '1' AND a.RSideEntityCardinality = '1';

--6. Print the name of all relationships that have a cardinality of 1-to-M in the ABC Diagram.
SELECT a.RelationshipName, a.LSideEntityCardinality, a.RSideEntityCardinality
FROM AllRelationships a
WHERE a.LSideEntityCardinality = '1' AND a.RSideEntityCardinality = 'M'
-- Consider 004 (Track Changes From Rev1 to Rev2)
OR a.LSideEntityCardinality = 'M' AND a.RSideEntityCardinality = '1';

--7. Print the name of all relationships that have a cardinality of M-to-N in the ABC Diagram.
SELECT a.RelationshipName, a.LSideEntityCardinality, a.RSideEntityCardinality
FROM AllRelationships a
WHERE a.LSideEntityCardinality = 'M' AND a.RSideEntityCardinality = 'N'
-- Consider 005 (Track Changes From Rev1 to Rev2)
OR a.LSideEntityCardinality = 'N' AND a.RSideEntityCardinality = 'M';


--8. Print the name of all relationships that have attribute(s) as well as the name(s) of the 
--attribute(s) in the ABC Diagram.
SELECT *
FROM AllRelationships_Has_RelationshipAttributes;

--9. Print the name of all relationships that do not have attribute(s) in the ABC Diagram.
SELECT a.RelationshipName
FROM AllRelationships a
WHERE a.RelationshipName != 'Builds'; --does not equal to 

--10. Print the name of all entities that have a super-type and the 
--name of the super-type entity in the ABC Diagram.
-- ONLY MODIFIED SELECT SO THIS IS A CASE OF REFACTORING (CHANGES THAT DONT AFFECT THE UNDERLYING BEHAVIOUR OF THE QUERY)
/* SELECT DISTINCT a.SuperClass_EntityName  --DISTINCT = repeated rows arent allowed */
SELECT *
FROM Inheritance a; 

--11. Print the name of all entities that have sub-type(s) and the name of the 
--sub-type entities in the ABC Diagram.
SELECT DISTINCT a.SubClass_EntityName  --DISTINCT = repeated rows arent allowed
FROM Inheritance a; 

--12. Print the name of each entity that has a Pkey including the name(s) of the
-- attribute(s) that form the Pkey in the ABC Diagram.
SELECT *
FROM AllEntities_Has_AllKeys;

--13. Print the name of each entity that does not have a Pkey in the ABC Diagram.
SELECT DISTINCT EntityName
FROM AllEntities
MINUS                              -- MINUS means All Entities(EntityName) - AllEntities_Has_AllKeys(EntityName)
SELECT DISTINCT EntityName         -- MINUS returns all the EntityNames that are in the AllEntities Table but, not 
FROM AllEntities_Has_AllKeys;      -- in the AllEntities_Has_AllKeys table


--14. Print the names of all attributes in the picture and the attribute data 
--types in the ABC Diagram.
SELECT * 
FROM AllAttributes;

--15. Print the names of all derived attributes and the attributes they 
--derive from in the ABC Diagram.
/*
SELECT a.AttributeName                                      -- Age(Sink Attribute) = Todays Data - DOB(Source Attrubutes)
FROM AllAttributes a                                        -- Age is the derived attribute
WHERE a.AttributeName = 'DOB' OR a.ATTRIBUTENAME = 'Age';   -- DOB is used to calculate Age
*/
--MyReview Consider 014 (Track Changes From Rev1 to Rev2) -- MADE TABLE STRUCTURE CHANGES (Added new table to handle Query #15)
SELECT *
FROM Derived_Attributes;



--16. Print the names of all attributes in the picture that have a date data 
--type in the ABC Diagram.
--My Review Consider 015 (Added StartDate, EndDate and DOB) are they are date related attributes)
-- REFACTORED QUERY; WHERE clause didnt change only the SELECT clause was changed
SELECT a.AttributeName,A.DataType
FROM AllAttributes a
WHERE a.DataType = 'Date';


--17. Print entity Employee's attributes names in the ABC Diagram.
SELECT *
FROM AllEntities_Has_AllAttributes a
WHERE a.EntityName = 'Employee';

--18. Print relationship Builds attributes names in the ABC Diagram.
SELECT a.AttributeName
FROM AllRelationships_Has_RelationshipAttributes a
WHERE a.RelationshipName = 'Builds';

--19. Print the names of all entities that are directly related to entity 
--TempHourly (directly means via only one relationship) in the ABC Diagram.
SELECT DISTINCT a.LSideEntityName
FROM AllRelationships a
--Consider 009 (Track Changes From Rev1 to Rev2)
WHERE a.RSideEntityName != 'TempHourly'; -- dont need to show the TempHourly entity
AND a.LSideEntityName != 'Associate' -- dont need to show the indirectly linked entity
AND a.LSideEntityName != 'Region' -- dont need to show the indirectly linked entity
AND a.LSideEntityName != 'Promotion' -- dont need to show the indirectly linked entity








--20. Print the names of all entities that are indirectly related to the 
--entity TempHourly (related via two relationships) in the ABC Diagram.
--Consider 010 (Track Changes From Rev1 to Rev2)
SELECT a.RSideEntityName
FROM AllRelationships a
WHERE a.LSideEntityName = 'Employee' AND a.RSideEntityName = 'Associate'
UNION
SELECT a.LSideEntityName
FROM AllRelationships a
WHERE a.LSideEntityName = 'Region' AND a.RSideEntityName = 'Store'
UNION
SELECT a.LSideEntityName
FROM AllRelationships a
WHERE a.LSideEntityName = 'Promotion' AND a.RSideEntityName = 'Contractor'
UNION
SELECT a.RSideEntityName
FROM AllRelationships a
WHERE a.LSideEntityName = 'Store' AND a.RSideEntityName = 'Product'; 

--21. Print the names of attributes for entities Store and Region 
--(just the attribute names) in the ABC Diagram.
SELECT a.AttributeName
FROM AllEntities_Has_AllAttributes a
WHERE a.EntityName='Store' 
OR a.EntityName='Region';

--22. Print the names of all entities that are participating in any 
--relationship that Product participates in in the ABC Diagram.
SELECT a.LSideEntityName
FROM AllRelationships a
WHERE a.RSideEntityName = 'Product';

--23. Print the name of all sub-types of entity Employee in the ABC Diagram.

------------MyReview Consider 016 (Track Changes From Rev1 to Rev2)--------------
/*
SELECT *
FROM Inheritance a
WHERE a.SuperClass_EntityName='Employee' 
AND a.SubClass_EntityName= 'Contractor';
*/

SELECT a.Subclass_EntityName
FROM Inheritance a
WHERE a.SuperClass_EntityName='Employee' 
UNION
SELECT a.Subclass_EntityName
FROM Inheritance a
WHERE a.SuperClass_EntityName='Contractor';

-------------------------------------------------------------------------------------





--24. Print the name of all entities that have exactly three attributes in the ABC Diagram.
SELECT a.EntityName 
FROM AllEntities_Has_AllAttributes a
GROUP BY a.EntityName 
HAVING COUNT(AttributeName)=3; 

--25. Print the name of all composite attributes and the attributes they contain in the ABC Diagram.
-- New table was created (Part3 update) and inserted data (Part 4 update )to make this query work
SELECT *
FROM AllCompositeAttributes_Has_AllEntities;

--26. Print label ‘Parent’ followed by the name of the parent entity and the label ‘Child’ 
--followed by the name of the child entities for each disjoint type-sub-type relationship in the 
--ABC Diagram.
SELECT SuperClass_EntityName AS Parent, SubClass_EntityName AS Child
FROM Inheritance;

--27. Print the name of each table and the columns within that table- by printing the table 
-- name once followed by each column within that table on a separate line in the ABC Diagram.
-- finding the Oracle Databasename from inside the SQL Session

--MyReview Consider 017 (Track Changes From Rev1 to Rev2) -- MADE TABLE STRUCTURE CHANGES to make the query results display correctly

/*
Select a.TABLE_NAME,a.COLUMN_NAME
FROM USER_TAB_COLUMNS a
WHERE a.TABLE_NAME = 'ALLATTRIBUTES' 
OR a.TABLE_NAME = 'ENTITYATTRIBUTES'
OR a.TABLE_NAME = 'RLATIONSHIPATTRIBUTES'
OR a.TABLE_NAME = 'ALLKEYS'
OR a.TABLE_NAME = 'ALLENTITIES'
OR a.TABLE_NAME = 'INHERITANCE'
OR a.TABLE_NAME = 'ALLRELATIONSHIPS'
OR a.TABLE_NAME = 'ALLATTRIBUTESATTRIBUTETYPES'
OR a.TABLE_NAME = 'ALLRELATIONSHIPS_HAS_RELATIONSHIPATTRIBUTES'
OR a.TABLE_NAME = 'ALLENTITIES_HAS_ALLRELATIONSHIPS'
OR a.TABLE_NAME = 'ALLENTITIES_HAS_ALLKEYS'
OR a.TABLE_NAME = 'ALLENTITIES_HAS_ALLATTRIBUTES'
OR a.TABLE_NAME = 'ALLCOMPOSITEATTRIBUTES_HAS_ALLENTITIES';
*/

SELECT TableName,ColumnName -- column filter
FROM Table_For_Query27;

-------------------------------------------------------------------------------------








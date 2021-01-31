
--Use the Create View statement to create the following views:
--Note1: 1st create the tables, 2nd load data into the tables, last execute the SQL View Queries 
--Note2: Errors that occur during the runtime execution of the SQL View Queries means redesigning PK/FK Constraints from Part3 


----------1.All_Ents: This view returns the name of all entities in the ABC Diagram.-----
CREATE VIEW All_Ents -- Creating the view
AS
SELECT A.EntityName 
FROM AllEntities A; 

SELECT * -- displaying the view
FROM All_Ents

----------2.All_Atts: This view returns the name of all attributes in the ABC Diagram.-----
CREATE VIEW All_Atts -- Creating the view
AS
SELECT A.AttributeName 
FROM AllAttributes A; 

SELECT * -- displaying the view
FROM All_Atts

----------3.All_Keys: This view returns the name of all TABLE and Entity primary keys in the ABC Diagram..-----
-- This view displays all the PK & fFK relationship from a database
CREATE VIEW All_Keys -- creating the view
AS
select tc.table_schema, tc.table_name, kc.column_name 
from  
    information_schema.table_constraints tc,  
    information_schema.key_column_usage kc  
where 
    tc.constraint_type = 'PRIMARY KEY' 
    and kc.table_name = tc.table_name and kc.table_schema = tc.table_schema
    and kc.constraint_name = tc.constraint_name
order by 1, 2;

SELECT * --displaying the view
FROM All_Keys;

----------4.All_Rels: This view returns the name of all relationships in the ABC Diagram..-----
CREATE VIEW All_Rels -- Creating the view
AS
SELECT A.RelationshipName 
FROM AllRelationships A; 

SELECT * -- displaying the view
FROM All_Rels

----------5.EntAtt: This view returns the name of every entity and the name of all attributes it contains in the ABC Diagram.
----------(for each entity, print each attribute on a separate line).
CREATE VIEW EntAtt -- Creating the view
AS
SELECT DISTINCT C.EntityName, C.AttributeName 
FROM AllEntities A, AllAttributes B, AllEntities_Has_AllAttributes C
WHERE A.EntityName = C.EntityName
AND   B.AttributeName = C.AttributeName; 

SELECT * -- displaying the view
FROM EntAtt;

----------6.RelEnt: This view returns the name of each relationship and the names of two entities it connects in the ABC Diagram.
----------(for each entity, print each attribute on a separate line).
CREATE VIEW RelEnt -- Creating the view
AS
SELECT A.RelationshipName, A.LSideEntityName, A.RSideEntityName
FROM AllRelationships A; 

SELECT * -- displaying the view
FROM RelEnt

----------7.RelAtt: This view returns the name of every relationship and the name of all attributes it contains in the ABC Diagram.
----------(for each entity, print each attribute on a separate line).
CREATE VIEW RelAtt -- Creating the view
AS
SELECT A.RelationshipName, A.AttributeName
FROM AllRelationships_Has_RelationshipAttributes A; 

SELECT * -- displaying the view
FROM RelAtt

----------8.AttDatatype: This view returns the name of each attribute from the ABC Diagram and the name of the data type for each attribute.
CREATE VIEW AttDatatype -- Creating the view
AS
SELECT A.AttributeName,A.DataType
FROM AllAttributes A; 

SELECT * -- displaying the view
FROM AttDatatype

----------9.EntKey: This view returns the name of Pkeys for each entity in the ABC Diagram.. One line per entity.
CREATE VIEW EntKey -- Creating the view
AS
SELECT DISTINCT C.AttributeName 
FROM AllAttributes A, AllKeys B, AllEntities_has_AllKeys C
WHERE A.AttributeName= B.AttributeName 
AND   B.AttributeName= C.AttributeName; 

SELECT * -- displaying the view
FROM EntKey

----------10.KeyAttr: This view returns the entity key names and the entity attributes that form the key in the ABC Diagram.
----------(for each entity, print each attribute on a separate line).
CREATE VIEW KeyAttr -- Creating the view
AS
SELECT DISTINCT C.EntityName,C.AttributeName 
FROM AllAttributes A, AllKeys B, AllEntities_has_AllKeys C
WHERE A.AttributeName= B.AttributeName 
AND   B.AttributeName= C.AttributeName; 

SELECT * -- displaying the view
FROM KeyAttr









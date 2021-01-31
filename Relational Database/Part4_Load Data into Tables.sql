
-- First, we extracted entities & attributes from the ABC Diagram
-- Next we used INSERT statements to load the entities and attributes
-- into their database tables


-- Loading all the entities from tbe ABC Diagram in the All Entities Table
INSERT INTO AllEntities VALUES('Employee');
INSERT INTO AllEntities VALUES('Associate') ;
INSERT INTO AllEntities VALUES('TempHourly');
INSERT INTO AllEntities VALUES('Contractor');
INSERT INTO AllEntities VALUES('Promotion');
INSERT INTO AllEntities VALUES('Display');
INSERT INTO AllEntities VALUES('Store');
INSERT INTO AllEntities VALUES('Region');
INSERT INTO AllEntities VALUES('Product');

-- Loading the entity attribute into the AllAttributes Table
-- Extracting relationships attribute datatype from the ABC DIagrams Builds Relationship -------------------
INSERT INTO AllAttributes VALUES ('Date','Date');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Employee Table --------------
INSERT INTO AllAttributes VALUES('Fname','String');
INSERT INTO AllAttributes VALUES('Minit','String');
INSERT INTO AllAttributes VALUES('Lname','String');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Employee Table --------------
INSERT INTO AllAttributes VALUES('SSN','String');
INSERT INTO AllAttributes VALUES('Age','Integer');
INSERT INTO AllAttributes VALUES('DOB','String');
INSERT INTO AllAttributes VALUES('Sex','String');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Employee Table --------------
INSERT INTO AllAttributes VALUES('Address','String'); -- composite attribute
INSERT INTO AllAttributes VALUES('Street','String');
INSERT INTO AllAttributes VALUES('City','String');
INSERT INTO AllAttributes VALUES('State','String');
INSERT INTO AllAttributes VALUES('Zip','String');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Associate Table --------------
INSERT INTO AllAttributes VALUES('Aphone','String');
INSERT INTO AllAttributes VALUES('Title','String');
INSERT INTO AllAttributes VALUES('AEmail','String');
INSERT INTO AllAttributes VALUES('Salary','Integer');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Promotion Table --------------
INSERT INTO AllAttributes VALUES('ProName','String');
INSERT INTO AllAttributes VALUES('StartDate','String');
INSERT INTO AllAttributes VALUES('EndDate','String');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Contractor Table --------------
INSERT INTO AllAttributes VALUES('Specialty','String');
------------------ Extracted entity attributes datatypes from the ABC Diagrams TempHourly Table --------------
INSERT INTO AllAttributes VALUES('JobTitle','String');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Build Relationship --------------
INSERT INTO AllAttributes VALUES('Date','String');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Display Table --------------
INSERT INTO AllAttributes VALUES('Aisle','Integer');
INSERT INTO AllAttributes VALUES('Row','Integer');
INSERT INTO AllAttributes VALUES('Section','Integer');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Product Table ---------------
INSERT INTO AllAttributes VALUES('SKU#','Integer');
INSERT INTO AllAttributes VALUES('PGroup','Integer');
INSERT INTO AllAttributes VALUES('PrdName','String');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Store Table ---------------
INSERT INTO AllAttributes VALUES('Size','String');
INSERT INTO AllAttributes VALUES('SAddress','String');
INSERT INTO AllAttributes VALUES('Store#','Integer');
------------------ Extracted entity attributes datatypes from the ABC Diagrams Region Table ---------------
INSERT INTO AllAttributes VALUES('RName','String');
INSERT INTO AllAttributes VALUES('RId#','Integer');

--Loading (relationships with cardinalities)data into the AllRelationship table
-- Definining all the cardinality based relationships in the ABC Diagram
INSERT INTO AllRelationships VALUES('WorksIn','Associate','Store','M','1'); --- #1 from the ABC Diagram
INSERT INTO AllRelationships VALUES('Manages','Associate','Store','1','1'); --- #2 from the ABC Diagram
INSERT INTO AllRelationships VALUES('Owns','Associate','Promotion','M','N'); --- #3 from the ABC Example
INSERT INTO AllRelationships VALUES('Hires','Associate','Contractor','1','M'); --- #4 from the ABC Example
INSERT INTO AllRelationships VALUES('WorksOn','Promotion','Contractor','M','N'); --- #5 from the ABC Example
INSERT INTO AllRelationships VALUES('Schedules','Associate','Display','1','M'); --- #6 from the ABC Example
INSERT INTO AllRelationships VALUES('AssignedTo','Store','TempHourly','1','M'); --- #7 from the ABC Example
INSERT INTO AllRelationships VALUES('Designs','Contractor','Display','M','N'); --- #8 from the ABC Example
INSERT INTO AllRelationships VALUES('Builds','TempHourly','Display','N','M'); --- #9 from the ABC Example
INSERT INTO AllRelationships VALUES('Stock','TempHourly','Display','N','M'); --- #10 from the ABC Example
INSERT INTO AllRelationships VALUES('Contains','Display','Product','1','M'); --- #11 from the ABC Example
INSERT INTO AllRelationships VALUES('Offers','Store','Product','1','M'); --- #12 from the ABC Example
INSERT INTO AllRelationships VALUES('IsWithin','Region','Store','1','M'); --- #13 from the ABC Example

-- Error Code ORA-02291 was triggered for "AllRelationships_Has_RelationshipAttributes"  table
-- First, we inserted data into "All Relationships" table
-- Second, we inserted data into "AllRelationships_Has_RelationshipAttributes"  table
-- Third, we inserted data into "All Attributes" Table


--Troubleshooting Error Code ORA-02291
-- ORA-02291 which means that integrity constraint violated-parent key aka 
-- (AllRelationships_Has_RelationshipAttributes ) Tables foreign keys are
-- FOREIGN KEY (RelationshipName) REFERENCES AllRelationships(RelationshipName),
-- FOREIGN KEY (AttributeName) REFERENCES AllAttributes(AttributeName)); 

--  Error Code ORA-02291 was resolved
-- First, we inserted data into "All Relationships" table
-- Second, we inserted data into "All Attributes" Table
-- Third, we inserted data into "AllRelationships_Has_RelationshipAttributes"  table
--Due to part 6 changed part 3's code from RelationshipAttributes to AllAttributes in 
-- order to make the query for (8. Print the name of all relationships that have attribute(s) as well as the name(s) of the attribute(s) in the ABC Diagram.)

-- Loading the relationship attribute into the AllRelationships_Has_AllRelationshipAttributes Table
INSERT INTO AllRelationships_Has_RelationshipAttributes VALUES('Builds','Date');


-- Linking the entities to their correct entity attributes
------------------ For the ABC Diagrams; linking entity attributes to the Employee Table --------------
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
------------------ For the ABC Diagrams; linking entity attributes to the Associate Table --------------
INSERT INTO AllEntities_Has_AllAttributes VALUES('Associate','Aphone');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Associate','Title');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Associate','AEmail');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Associate','Salary');
------------------ For the ABC Diagrams; linking entity attributes to the Promotion Table --------------
INSERT INTO AllEntities_Has_AllAttributes VALUES('Promotion','ProName');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Promotion','StartDate');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Promotion','EndDate');
------------------ For the ABC Diagrams; linking entity attributes to the Contractor Table --------------
INSERT INTO AllEntities_Has_AllAttributes VALUES('Contractor','Specialty');
------------------ For the ABC Diagrams; linking entity attributes to the TempHourly Table --------------
INSERT INTO AllEntities_Has_AllAttributes VALUES('TempHourly','JobTitle');
------------------ For the ABC Diagrams Display Table --------------
INSERT INTO AllEntities_Has_AllAttributes VALUES('Display','Section');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Display','Row');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Display','Aisle');
------------------ For the ABC Diagrams; linking entity attributes to the Product Table --------------
INSERT INTO AllEntities_Has_AllAttributes VALUES('Product','SKU#');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Product','PrdName');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Product','PGroup');
------------------ For the ABC Diagrams; linking entity attributes to the Store Table --------------
INSERT INTO AllEntities_Has_AllAttributes VALUES('Store','Store#');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Store','SAddress');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Store','Size');
------------------ For the ABC Diagrams; linking entity attributes to the Region Table --------------
INSERT INTO AllEntities_Has_AllAttributes VALUES('Region','RName');
INSERT INTO AllEntities_Has_AllAttributes VALUES('Region','RId#');

-- Loading the (inheritance relationship)data into the Inheritance Table
INSERT INTO Inheritance VALUES('Employee', 'Associate'); -- Associate Entity(Subclass) inherits from Employee (SuperClass)
INSERT INTO Inheritance VALUES('Employee', 'TempHourly'); -- TempHourly Entity(Subclass) inherits from Employee (SuperClass)
INSERT INTO Inheritance VALUES('TempHourly', 'Contractor'); -- Contractor(Subclass) inherits from TempHourly (SuperClass)

--Loading (relationships with cardinalities)data into the AllRelationship table
-- Definining all the cardinality based relationships in the ABC Diagram
INSERT INTO AllRelationships VALUES('WorksIn','Associate','Store','M','1'); --- #1 from the ABC Diagram
INSERT INTO AllRelationships VALUES('Manages','Associate','Store','1','1'); --- #2 from the ABC Diagram
INSERT INTO AllRelationships VALUES('Owns','Associate','Promotion','M','N'); --- #3 from the ABC Example
INSERT INTO AllRelationships VALUES('Hires','Associate','Contractor','1','M'); --- #4 from the ABC Example
INSERT INTO AllRelationships VALUES('WorksOn','Promotion','Contractor','M','N'); --- #5 from the ABC Example
INSERT INTO AllRelationships VALUES('Schedules','Associate','Display','1','M'); --- #6 from the ABC Example
INSERT INTO AllRelationships VALUES('AssignedTo','Store','TempHourly','1','M'); --- #7 from the ABC Example
INSERT INTO AllRelationships VALUES('Designs','Contractor','Display','M','N'); --- #8 from the ABC Example
INSERT INTO AllRelationships VALUES('Builds','TempHourly','Display','N','M'); --- #9 from the ABC Example
INSERT INTO AllRelationships VALUES('Stock','TempHourly','Display','N','M'); --- #10 from the ABC Example
INSERT INTO AllRelationships VALUES('Contains','Display','Product','1','M'); --- #11 from the ABC Example
INSERT INTO AllRelationships VALUES('Offers','Store','Product','1','M'); --- #12 from the ABC Example
INSERT INTO AllRelationships VALUES('IsWithin','Region','Store','1','M'); --- #13 from the ABC Example

-- Loading (Key type, keyname) data into the AllKeys Table
-- Definining all the primary keys in the ABC Diagram
INSERT INTO AllKeys VALUES('Primary','SSN'); --- #1 from the ABC Diagram
INSERT INTO AllKeys VALUES('Primary','ProName');  --- #2 from the ABC Diagram
INSERT INTO AllKeys VALUES('Primary','Aisle');  --- #3 from the ABC Diagram
INSERT INTO AllKeys VALUES('Primary','Row');  --- #4 from the ABC Diagram
INSERT INTO AllKeys VALUES('Primary','Section');  --- #5 from the ABC Diagram
INSERT INTO AllKeys VALUES('Primary','SKU#');  --- #6 from the ABC Diagram
INSERT INTO AllKeys VALUES('Primary','Store#');  --- #7 from the ABC Diagram
INSERT INTO AllKeys VALUES('Primary','RName');  --- #8 from the ABC Diagram

-- Loading (EntityName, AttributeName) data into the AllEntities_Has_AllKeys Table
INSERT INTO AllEntities_Has_AllKeys VALUES('Employee','SSN'); --- #1 from the ABC Diagram
INSERT INTO AllEntities_Has_AllKeys VALUES('Promotion','ProName');  --- #2 from the ABC Diagram
INSERT INTO AllEntities_Has_AllKeys VALUES('Display','Section');  --- #3 from the ABC Diagram
INSERT INTO AllEntities_Has_AllKeys VALUES('Display','Row');  --- #4 from the ABC Diagram
INSERT INTO AllEntities_Has_AllKeys VALUES('Display','Aisle');  --- #5 from the ABC Diagram
INSERT INTO AllEntities_Has_AllKeys VALUES('Product','SKU#');  --- #6 from the ABC Diagram
INSERT INTO AllEntities_Has_AllKeys VALUES('Store','Store#');  --- #7 from the ABC Diagram
INSERT INTO AllEntities_Has_AllKeys VALUES('Region','RName');  --- #8 from the ABC Diagram


-- Part 6's query for (25. Print the name of all composite attributes and the attributes they contain in the ABC Diagram.)
-- caused Part 3 to include a new table to handle composite attributes
-- New Table was created in part 6 to handle composite attributes
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Employee','Name');
INSERT INTO AllCompositeAttributes_Has_AllEntities VALUES('Employee','Address');
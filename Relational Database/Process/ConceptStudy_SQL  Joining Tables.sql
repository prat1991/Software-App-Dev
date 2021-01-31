
--Creating Tables
CREATE TABLE customers
(
    customer_id VARCHAR(20),
    last_name VARCHAR(20),
    first_name VARCHAR(20),
    favorite_website VARCHAR(20),
    PRIMARY KEY(customer_id)
);


CREATE TABLE orders
(
    order_id VARCHAR(20),
    customer_id VARCHAR(20),
    order_date VARCHAR(20),
    PRIMARY KEY(order_id)
);

-- Populating the created tables
INSERT INTO customers VALUES ('4000','Jackson','Joe','techonthenet.com');
INSERT INTO customers VALUES ('5000','Smith','Jane','digminecraft.com');
INSERT INTO customers VALUES ('6000','Ferguson','Samantha','bigactivities.com');
INSERT INTO customers VALUES ('7000','Reynolds','Allen','checkyourmath.com');
INSERT INTO customers VALUES ('8000','Anderson','Paige',NULL);
INSERT INTO customers VALUES ('9000','Johnson','Derek','techonthenet.com');

INSERT INTO orders VALUES ('1','7000','2016/04/18');
INSERT INTO orders VALUES ('2','5000','2016/04/18');
INSERT INTO orders VALUES ('3','8000','2016/04/19');
INSERT INTO orders VALUES ('4','4000','2016/04/20');
INSERT INTO orders VALUES ('5',NULL,'2016/05/01');

-- Performing Join Calculations

--Performing Inner Join Calculation
--SQL Syntax for the INNER JOIN:
/*
SELECT columns
FROM table1 
INNER JOIN table2
ON table1.column = table2.column;
*/
SELECT *
FROM customers A
INNER JOIN orders B
ON A.customer_id = B.customer_id;

--Performing Left Join Calculation
--SQL Syntax for the Left JOIN:
/*
SELECT columns
FROM table1
LEFT [OUTER] JOIN table2
ON table1.column = table2.column;
*/
SELECT *
FROM customers A
LEFT OUTER JOIN orders B
ON A.customer_id = B.customer_id;

--Performing Right Join Calculation
--SQL Syntax for the Right JOIN:
/*
SELECT columns
FROM table1
RIGHT [OUTER] JOIN table2
ON table1.column = table2.column;
*/
SELECT *
FROM customers A
RIGHT OUTER JOIN orders B
ON A.customer_id = B.customer_id;

--Performing Outer Join Calculation
--SQL Syntax for the Outer JOIN:
/*
SELECT columns
FROM table1
FULL [OUTER] JOIN table2
ON table1.column = table2.column;
*/
SELECT *
FROM customers A
FULL OUTER JOIN orders B
ON A.customer_id = B.customer_id;






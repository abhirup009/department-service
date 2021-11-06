CREATE TABLE dept_details (
	id serial PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	address VARCHAR ( 50 ) NOT NULL
);
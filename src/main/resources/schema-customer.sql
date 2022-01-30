CREATE TABLE IF NOT EXISTS CustomerTable (
    customer_id serial PRIMARY KEY,
    firstName varchar,
    middleName varchar,
    lastName varchar,
    email varchar,
);
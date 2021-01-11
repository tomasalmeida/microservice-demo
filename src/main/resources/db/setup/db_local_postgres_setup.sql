--Create schema for storage.
CREATE DATABASE demo;

--Create a new user:
CREATE USER demo_user WITH PASSWORD 'admin';

--Grant privileges to the new user to the demo database:
GRANT ALL PRIVILEGES ON DATABASE demo TO demo_user;
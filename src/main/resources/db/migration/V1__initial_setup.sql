CREATE TABLE person_data (
    id                  BIGSERIAL PRIMARY KEY,
    firstname           VARCHAR(255),
    lastname            VARCHAR(255),
    email               VARCHAR(255),
    pets                JSONB,
    created             TIMESTAMP,
    last_update         TIMESTAMP
);

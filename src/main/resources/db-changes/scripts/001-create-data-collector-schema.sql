--liquibase formatted sql
/* https://docs.liquibase.com/concepts/changelogs/sql-format.html */

--changeset rahyabcp:1 context:schema-creation
CREATE SCHEMA IF NOT EXISTS DATA_COLLECTOR;

--rollback DROP SCHEMA schema_name CASCADE;

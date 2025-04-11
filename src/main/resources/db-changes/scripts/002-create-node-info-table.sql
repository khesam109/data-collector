--liquibase formatted sql
/* https://docs.liquibase.com/concepts/changelogs/sql-format.html */

--changeset rahyabcp:1 context:table-creation
CREATE TABLE DATA_COLLECTOR.NODE_INFO
(
    ID                  INT          PRIMARY KEY,
    CONNECTION_PROTOCOL VARCHAR(255) NOT NULL,
    SCHEDULE_INFO_ID    INT          NOT NULL
);
--rollback DROP TABLE DATA_COLLECTOR.NODE_INFO;

--changeset rahyabcp:2 context:sequence-creation
CREATE SEQUENCE DATA_COLLECTOR.NODE_INFO_SEQ
    START WITH 1
    INCREMENT BY 1
--rollback DROP DATA_COLLECTOR.NODE_INFO_SEQ;
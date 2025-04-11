--liquibase formatted sql
/* https://docs.liquibase.com/concepts/changelogs/sql-format.html */

--changeset rahyabcp:1 context:table-creation
CREATE TABLE DATA_COLLECTOR.SCHEDULE_INFO
(
    ID        INT          PRIMARY KEY,
    INTERVAL  INT          NOT NULL,
    TIME_UNIT VARCHAR(255) NOT NULL
);
--rollback DROP TABLE DATA_COLLECTOR.SCHEDULE_INFO;

--changeset rahyabcp:2 context:sequence-creation
CREATE SEQUENCE DATA_COLLECTOR.SCHEDULE_INFO_SEQ
    START WITH 1
    INCREMENT BY 1
--rollback DROP DATA_COLLECTOR.SCHEDULE_INFO_SEQ;
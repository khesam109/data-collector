--liquibase formatted sql
/* https://docs.liquibase.com/concepts/changelogs/sql-format.html */

--changeset rahyabcp:1 context:table-creation
CREATE TABLE DATA_COLLECTOR.FTP_CONNECTOR_INFO
(
    ID               INT          PRIMARY KEY,
    NODE_INFO_ID     INT          NOT NULL,
    HOST             VARCHAR(255) NOT NULL,
    PORT             INT          NOT NULL,
    USERNAME         VARCHAR(255) NOT NULL,
    PASSWORD         VARCHAR(255)         ,
    REMOTE_DIRECTORY VARCHAR(255) NOT NULL

);
--rollback DROP TABLE DATA_COLLECTOR.FTP_CONNECTOR_INFO;

--changeset rahyabcp:2 context:sequence-creation
CREATE SEQUENCE DATA_COLLECTOR.FTP_CONNECTOR_INFO_SEQ
    START WITH 1
    INCREMENT BY 1
--rollback DROP DATA_COLLECTOR.FTP_CONNECTOR_INFO_SEQ;
CREATE TABLE RETAIL_DB.USER_RECORD (
    USER_ID VARCHAR(200) NOT NULL,
    NAME VARCHAR(200) NOT NULL,
    AGE INTEGER NOT NULL,
    GENDER CHAR(1) CHECK (GENDER IN ('M','F')),
    CREATED_TIME TIMESTAMP NOT NULL,
    UPDATED_TIME TIMESTAMP NOT NULL,
    constraint USER_ID_PK primary key (USER_ID)
);
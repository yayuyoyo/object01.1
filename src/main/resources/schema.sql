CREATE TABLE
IF NOT EXISTS m_user
(user_name VARCHAR
(50) PRIMARY KEY,password VARCHAR
(100),mailAddress VARCHAR
(50),birthYear text, birthMonth text,birthday text,gender BOOLEAN,
role VARCHAR
(50));


-- create table if not exists w_data (
--     recordYear text,
--     recordMonth text,
--     recordDay text,
--     recordWeight DOUBLE
-- );

CREATE TABLE IF NOT EXISTS w_data (
    recordDate DATE,
    recordWeight DOUBLE
);

-- CREATE TABLE IF NOT EXISTS wa_data (
--     recordDate DATE,
--     recordWeight DOUBLE
-- );

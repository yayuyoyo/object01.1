CREATE TABLE
IF NOT EXISTS m_user
(user_name VARCHAR
(50) PRIMARY KEY,password VARCHAR
(100),mailAddress VARCHAR
(50),birthYear text, birthMonth text,birthday text,gender BOOLEAN,
role VARCHAR
(50));

CREATE TABLE
IF NOT EXISTS w_data
(
    id INT AUTO_INCREMENT,
    recordDate DATE,
    recordWeight DOUBLE,
    PRIMARY KEY
(id)
);

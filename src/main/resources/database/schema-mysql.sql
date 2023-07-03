DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS address;

CREATE TABLE IF NOT EXISTS user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    user_password VARCHAR(50) NOT NULL,
    user_tel VARCHAR()
    created_date DATETIME NOT NULL,
    modified_date DATETIME NULL
);

CREATE TABLE IF NOT EXISTS address (

);

CREATE TABLE IF NOT EXISTS board (
    board_id BIGINT NOT NULL AUTO_INCREMENT,
    board_title VARCHAR(50) NOT NULL,
    board_contents VARCHAR(200) NOT NULL,
    write_id VARCHAR(50) NOT NULL,
    modify_id VARCHAR(50) NULL,
    write_date DATETIME NOT NULL,
    modify_date DATETIME NULL,

    PRIMARY KEY (board_id)
);

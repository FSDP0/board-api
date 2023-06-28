CREATE DATABASE IF NOT EXISTS boards;


-- DELETE FROM board;
-- DELETE FROM user;

ALTER TABLE board DROP CONSTRAINT writer;
ALTER TABLE board DROP CONSTRAINT editor;

-- ALTER TABLE board DROP FOREIGN KEY write_id;
-- ALTER TABLE board DROP FOREIGN KEY modify_id;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS board;

--------------------------------------------------------------

CREATE TABLE IF NOT EXISTS user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    user_name VARCHAR(40) NOT NULL,
    user_password VARCHAR(60) NOT NULL,
    user_tel VARCHAR(50) NOT NULL,
    user_address VARCHAR(100) NOT NULL,
    address_zipcode VARCHAR(30) NOT NULL,
    created_date DATETIME NOT NULL,
    modified_date DATETIME NULL,

    PRIMARY KEY (user_id),

    UNIQUE KEY (id)
);

CREATE TABLE IF NOT EXISTS board (
    board_id BIGINT NOT NULL AUTO_INCREMENT,
    board_title VARCHAR(50) NOT NULL,
    board_contents VARCHAR(200) NOT NULL,
    write_id VARCHAR(50) NOT NULL,
    modify_id VARCHAR(50) NULL,
    write_date DATETIME NOT NULL,
    modify_date DATETIME NULL,

    PRIMARY KEY (board_id),

    CONSTRAINT writer FOREIGN KEY (write_id) REFERENCES user(user_id),
    CONSTRAINT editor FOREIGN KEY (modify_id) REFERENCES user(user_id)
);
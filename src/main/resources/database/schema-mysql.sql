DROP TABLE IF EXISTS board;

CREATE TABLE IF NOT EXISTS board(
    board_id BIGINT NOT NULL AUTO_INCREMENT,

    board_title VARCHAR(50) NOT NULL,
    board_contents VARCHAR(200) NOT NULL,

    write_id VARCHAR(50) NOT NULL,
    modify_id VARCHAR(50) NULL,

    write_date DATETIME NOT NULL,
    modify_date DATETIME NULL,

    PRIMARY KEY (board_id)
);

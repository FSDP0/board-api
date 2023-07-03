-- Drop exist tables
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS address;

CREATE TABLE IF NOT EXISTS user (
    id BIGINT NOT NULL AUTO_INCREMENT,       -- 사용자 번호
    user_id VARCHAR(50) NOT NULL,            -- 사용자 ID [PK]
    user_name VARCHAR(50) NOT NULL,          -- 사용자 이름
    user_password VARCHAR(50) NOT NULL,      -- 사용자 비밀번호
    user_tel VARCHAR(60) NOT NULL,           -- 사용자 번호
    user_address VARCHAR(100) NOT NULL,      -- 사용자 주소
    detail_address VARCHAR(100) NOT NULL,    -- 사용자 상세 주소
    created_date DATETIME NOT NULL,          -- 사용자 계정정보 생성일
    modified_date DATETIME NULL,             -- 사용자 계정정보 수정일

    PRIMARY KEY (user_id)                    -- user_id Column Set Primary Key
);

CREATE TABLE IF NOT EXISTS address (
    address VARCHAR(100) NOT NULL,           -- 특정 주소 [PK]
    address_zipcode VARCHAR(20) NOT NULL     -- 주소 ZipCode

    PRIMARY KEY (address)                    -- address Column Set Primary Key
);

CREATE TABLE IF NOT EXISTS board (
    board_id BIGINT NOT NULL AUTO_INCREMENT, -- 게시글 번호 [PK]
    board_title VARCHAR(50) NOT NULL,        -- 게시글 제목
    board_contents VARCHAR(200) NOT NULL,    -- 게시글 내용
    write_id VARCHAR(50) NOT NULL,           -- 게시글 작성자 ID
    modify_id VARCHAR(50) NULL,              -- 게시글 수정자 ID
    write_date DATETIME NOT NULL,            -- 게시글 생성일
    modify_date DATETIME NULL,               -- 게시글 수정일

    PRIMARY KEY (board_id)                   -- board_id Column Set Primary Key
);

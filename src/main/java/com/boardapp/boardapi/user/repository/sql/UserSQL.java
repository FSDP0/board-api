package com.boardapp.boardapi.user.repository.sql;

public class UserSQL {
        public final static String SELECT_ALL = """
                        SELECT *
                        FROM user
                        ORDER BY id ASC
                        """;

        public final static String INSERT_USER = """
                        INSERT
                        INTO user(
                            user_id,
                            user_name
                            user_password,
                            user_tel,
                            user_address,
                            address_zipcode
                        ) VALUES (
                            :id,
                            :name,
                            :password,
                            :tel,
                            :address,
                            :zipcode,
                        )
                        """;

        public final static String UPDATE_BY_ID = """
                        UPDATE user
                        SET user_name = :name,
                            user_password = :password,
                            user_tel = :tel,
                            user_address = :address,
                            address_zipcode = :zipcode,
                            modified_date = :modifyDate
                        WHERE user_id = :id
                        """;
}

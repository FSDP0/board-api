package com.boardapp.boardapi.user.sql;

public class AddressSql {
    public final static String INSERT_ADDRESS = """
            INSERT INTO users.address(
                user_id,
                user_address,
                address_zipcode
            ) VALUES (?, ?, ?)
            """;

    public final static String UPDATE_ADDRESS_BY_USER_ID = """
            UPDATE users.address
            SET user_address = ?
                address_zipcode = ?
            WHERE user_id = ?
            """;
}

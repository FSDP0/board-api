package com.boardapp.boardapi.user.repository;

public class AddressSql {
    protected final static String INSERT_ADDRESS = """
            INSERT INTO users.address(
                user_id,
                user_address,
                address_zipcode
            ) VALUES (?, ?, ?)
            """;

    protected final static String UPDATE_ADDRESS_BY_USER_ID = """
            UPDATE users.address
            SET user_address = ?
                address_zipcode = ?
            WHERE user_id = ?
            """;
}

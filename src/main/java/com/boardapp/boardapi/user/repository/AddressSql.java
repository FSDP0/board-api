package com.boardapp.boardapi.user.repository;

public class AddressSql {
    protected final static String INSERT_ADDRESS = """
            INSERT INTO users.address(
                user_id,
                user_address,
                address_zipcode
            ) VALUES (
                :userId,
                :userAddress,
                :addressZipcode
            )
            """;

    protected final static String UPDATE_ADDRESS_BY_USER_ID = """
            UPDATE users.address
            SET user_address = :userAddress
                address_zipcode = :addressZipcode
            WHERE user_id = :userId
            """;
}

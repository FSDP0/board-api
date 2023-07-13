package com.boardapp.boardapi.address.model;

import com.boardapp.boardapi.address.entity.Address;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressDto {
    private String address;

    private String zipcode;

    public Address toEntity(){
        return Address.builder()
                        .address(this.address)
                        .addressZipcode(this.zipcode)
                        .build();
    }
}

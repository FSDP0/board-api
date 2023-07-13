package com.boardapp.boardapi.address.entity;

import java.util.List;
import com.boardapp.boardapi.address.model.AddressDto;
import com.boardapp.boardapi.user.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address")
    private String address;

    @JsonManagedReference // ? Serailze for JSON [Reference Forward]
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private List<User> userList = new ArrayList<User>();

    @Column(name = "address_zipcode")
    private String addressZipcode;

    @Builder
    public Address(String address, String addressZipcode) {
        this.address = address;
        this.addressZipcode = addressZipcode;
    }

    public AddressDto toDto(){
        return AddressDto.builder()
                            .address(this.address)
                            .zipcode(this.addressZipcode)
                            .build();
    }
}

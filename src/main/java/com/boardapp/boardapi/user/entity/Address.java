package com.boardapp.boardapi.user.entity;

import java.util.List;
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

@Getter
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<User> userList = new ArrayList<User>();

    @Column(name = "address_zipcode")
    private String addressZipcode;

    @Builder
    public Address(String address, String addressZipcode) {
        this.address = address;
        this.addressZipcode = addressZipcode;
    }
}

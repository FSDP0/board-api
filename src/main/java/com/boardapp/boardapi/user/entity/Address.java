package com.boardapp.boardapi.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address")
    @OneToMany(
        mappedBy = "address", // ! Must be matching with N side entity column name
        fetch = FetchType.LAZY // * Define FetchType
    ) private String address;

    @Column(name = "address_zipcode")
    private String addressZipcode;
}

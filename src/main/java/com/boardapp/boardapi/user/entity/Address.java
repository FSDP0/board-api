package com.boardapp.boardapi.user.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "user_id", length = 50, nullable = false)
    private String userId; // 사용자 ID

    @Column(name = "user_address", length = 100, nullable = false)
    private String userAddress; // 사용자 주소

    @Column(name = "address_zipcode", length = 20, nullable = false)
    private String addressZipcode; // 주소 Zip Code

    @OneToOne(cascade = CascadeType.ALL, // Cascade Type : ALL
            fetch = FetchType.LAZY) // Fetch Type : LAZY
    @JoinColumn(name = "user") // 현재 Entity에서 설정할 FK
    private User user;

    @Builder
    public Address(String id, String address, String zipcode) {
        this.userId = id;
        this.userAddress = address;
        this.addressZipcode = zipcode;
    }
}

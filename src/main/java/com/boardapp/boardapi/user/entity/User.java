package com.boardapp.boardapi.user.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.user.model.UserDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {
    // * Unique Key Column for Indexing
    @Column(columnDefinition = "BIGINT NOT NULL AUTO_INCREMENT UNIQUE KEY")
    private Long indexId;

    @Id // ! Define PK Column
    @Column(name = "user_id", length = 60, nullable = false, unique = true)
    private String userId;

    @Column(name = "user_name", length = 60)
    private String userName;

    @Column(name = "user_password", length = 80)
    private String userPassword;

    @Column(name = "user_tel", length = 40)
    private String userTel;

    @Column(name = "user_address", length = 100)
    private String userAddress;

    @ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_address", insertable = false, updatable = false)
    private Address address;

    @Column(name = "detail_address", length = 200)
    private String detailAddress;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board> createBoards = new ArrayList<Board>();

    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board> editBoards = new ArrayList<Board>();

    // * Convert entity data to dto 
    public UserDto toDto() {
        return UserDto.builder()
                        .id(this.userId)
                        .name(this.userName)
                        .password(this.userPassword)
                        .tel(this.userTel)
                        .address(this.userAddress)
                        .addressZipcode(this.address.getAddressZipcode())
                        .detailAddress(this.detailAddress)
                        .createdDate(this.createdDate)
                        .modifiedDate(this.modifiedDate)
                        .build();
    }

    @Builder
    public User(
        String userId,
        String userName,
        String userPassword,
        String userTel, 
        String userAddress, 
        String detailAddress,
        Date createdDate,
        Date modifiedDate
    ) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userTel = userTel;
        this.userAddress = userAddress;
        this.detailAddress = detailAddress;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}

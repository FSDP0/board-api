package com.boardapp.boardapi.user.entity;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.boardapp.boardapi.board.entity.Board;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, insertable = false, updatable = false)
    private Long id; // 사용자 정보 Index

    @Id
    @Column(name = "user_id", length = 50, nullable = false, unique = true)
    private String userId; // 사용자 ID

    @Column(name = "user_name", length = 50, nullable = false)
    private String userName; // 사용자 이름

    @Column(name = "user_password", length = 50, nullable = false)
    private String userPassword; // 사용자 비밀번호

    @Column(name = "user_tel", length = 50, nullable = false)
    private String userTel; // 사용자 전화번호

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private Date createdDate; // 사용자 계정 생성일

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate; // 사용자 계정 정보 수정일

    // Table Join
    // 1:1 Mapping
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address")
    private Address address;

    // Table Joj
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id") // 현재 Entity에서 설정할 FK
    private List<Board> boards; // 사용자가 작성한 게시글 목록

    @Builder
    public User(Long index, String id, String name, String password, String phoneNumber,
            Date createdDate, Date modifiedDate) {
        this.id = index;

        this.userId = id;
        this.userName = name;
        this.userPassword = password;
        this.userTel = phoneNumber;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}

package com.boardapp.boardapi.user.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.boardapp.boardapi.board.entity.Board;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    // @Column(name = "id", nullable = false, unique = true, insertable = false, updatable = false)
    @Column(columnDefinition = "BIGINT NOT NULL AUTO_INCREMENT UNIQUE KEY")
    private Long id; // 사용자 정보 번호

    @Id
    @Column(name = "user_id", length = 50, nullable = false, unique = true)
    private String userId; // 사용자 ID

    @Column(name = "user_name", length = 50, nullable = false)
    private String userName; // 사용자 이름

    @Column(name = "user_password", length = 50, nullable = false)
    private String userPassword; // 사용자 비밀번호

    @Column(name = "user_tel", length = 50, nullable = false)
    private String userTel; // 사용자 전화번호

    @Column(name = "user_address", length = 100, nullable = false)
    private String userAddress; // 사용자 주소

    @Column(name = "address_zipcode", length = 20, nullable = false)
    private String addressZipcode; // 주소 Zip Code

    @Column(name = "created_date", nullable = false)
    private Date createdDate; // 사용자 계정 생성일

    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate; // 사용자 계정 정보 수정일

    @OneToMany(mappedBy = "creatorId", cascade = CascadeType.ALL)
    private List<Board> createBoards = new ArrayList<Board>();

    @OneToMany(mappedBy = "editorId", cascade = CascadeType.ALL)
    private List<Board> editBoards = new ArrayList<Board>();
}

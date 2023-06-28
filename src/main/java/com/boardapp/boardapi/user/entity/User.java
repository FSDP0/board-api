package com.boardapp.boardapi.user.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    private Long id;

    @Id
    private String userId;
    private String userName;
    private String userPassword;
    private String userTel;
    private String userAddress;
    private String addressZipcode;

    @MappedCollection(idColumn = "write_id", keyColumn = "board_id")
    private final List<Board> writeBoards = new ArrayList<Board>();

    @MappedCollection(idColumn = "modify_id", keyColumn = "board_id")
    private final List<Board> modifyBoards = new ArrayList<Board>();

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    public void addWriteBoards(Board board) {
        this.writeBoards.add(board);
    }

    public void addModifyBoards(Board board) {
        this.modifyBoards.add(board);
    }

    @Builder
    public User(String id, String name, String password, String phoneNumber, String adress,
            String zipCode) {
        this.userId = id;
        this.userName = name;
        this.userPassword = password;
        this.userTel = phoneNumber;
        this.userAddress = adress;
        this.addressZipcode = zipCode;
    }
}

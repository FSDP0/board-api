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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

    @Setter
    @MappedCollection(idColumn = "write_id", keyColumn = "board_id")
    private List<Board> createBoards = new ArrayList<Board>();

    @Setter
    @MappedCollection(idColumn = "modify_id", keyColumn = "board_id")
    private List<Board> editBoards = new ArrayList<Board>();

    public void addCreateBoard(Board board) {
        createBoards.add(board);
    }

    public void addEditBoard(Board board) {
        editBoards.add(board);
    }

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

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

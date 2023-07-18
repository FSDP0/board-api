package com.boardapp.boardapi;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.boardapp.boardapi.board.dao.BoardCudDao;
import com.boardapp.boardapi.board.dao.BoardReadDao;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.user.dao.UserCudDao;
import com.boardapp.boardapi.user.dao.UserReadDao;
import com.boardapp.boardapi.user.model.User;

@SpringBootTest
class BoardApiApplicationTests {
	
	@Autowired
	BoardReadDao boardReadDao;

	@Autowired
	BoardCudDao boardCudDao;

	@Autowired
	UserReadDao userReadDao;

	@Autowired
	UserCudDao userCudDao;

	// * Board Domain Test

	@Test
	void findAll() {
		// 전체 게시글 리스트 조회
		List<Board> entityList = this.boardReadDao.findAllBoards();
	}

	@Test
	void findById() {
		Board entity = this.boardReadDao.findByBoardId(Long.valueOf(1));
	}

	@Test
	void save() {
		Board params = Board.builder()
							.boardTitle("1번 게시글 제목")
							.boardContents("1번 게시글 내용")
							.writeId("User1")
							.writeDate(LocalDateTime.now())
							.build();

		this.boardCudDao.saveBoard(params);

		Board entity = this.boardReadDao.findByBoardId(Long.valueOf(11));
		
		assertThat(entity.getBoardTitle()).isEqualTo("1번 게시글 제목");
		assertThat(entity.getBoardContents()).isEqualTo("1번 게시글 내용");
		assertThat(entity.getWriteId()).isEqualTo("User1");
	}

	@Test
	void update() {
		Board params = Board.builder()
							.boardId(Long.valueOf(2))
							.boardTitle("2번 게시글 제목")
							.boardContents("2번 게시글 내용")
							.modifyId("User2")
							.modifyDate(LocalDateTime.now())
							.build();

		this.boardCudDao.updateBoard(params);

		Board entity = this.boardReadDao.findByBoardId(Long.valueOf(2));

		assertThat(entity.getBoardTitle()).isEqualTo("2번 게시글 제목");
		assertThat(entity.getBoardContents()).isEqualTo("2번 게시글 내용");
		assertThat(entity.getModifyId()).isEqualTo("User2");
	}

	@Test
	void delete() {
		this.boardCudDao.deleteBoard(Long.valueOf(1));
	}

	// * User Domain Test

	@Test
	void findAllUser() {
		List<User> entityList = this.userReadDao.findAllUser();
	}

	@Test
	void findByUserId() {
		User entity = this.userReadDao.findByUserId("TestUser1");
	}

	@Test
	void saverUser() {
		User params = User.builder()
							.userId("1번사용자아이디")
							.userName("1번사용자이름")
							.userPassword("1번사용자비밀번호")
							.userPhonenumber("010-1234-5678")
							.createdDate(LocalDateTime.now())
							.build();

		this.userCudDao.saveUser(params);

		User entity = this.userReadDao.findByUserId("1번사용자아이디");

		assertThat(entity.getUserId()).isEqualTo("1번사용자아이디");
		assertThat(entity.getUserName()).isEqualTo("1번사용자이름");
		assertThat(entity.getUserPassword()).isEqualTo("1번사용자비밀번호");
		assertThat(entity.getUserPhonenumber()).isEqualTo("010-1234-5678");
	}

	@Test
	void updateUser() {
		User params = User.builder()
							.userId("TestUser1")
							.userName("수정된이름")
							.userPassword("수정된비밀번호")
							.userPhonenumber("010-0000-9999")
							.modifiedDate(LocalDateTime.now())
							.build();

		this.userCudDao.updateUser(params);

		User entity = this.userReadDao.findByUserId("TestUser1");

		assertThat(entity.getUserName()).isEqualTo("수정된이름");
		assertThat(entity.getUserPassword()).isEqualTo("수정된비밀번호");
		assertThat(entity.getUserPhonenumber()).isEqualTo("010-0000-9999");
	}

	@Test
	void deleteUser() {
		this.userCudDao.deleteUser("1번사용자아이디");
	}
}

package com.boardapp.boardapi;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.boardapp.boardapi.board.dao.BoardDao;
import com.boardapp.boardapi.board.model.Board;

@SpringBootTest
class BoardApiApplicationTests {
	@Autowired
	BoardDao boardDao;	

	@Test
	void findAll() {
		// 전체 게시글 리스트 조회
		List<Board> entityList = this.boardDao.findAllBoards();
	}

	@Test
	void findById() {
		Board entity = this.boardDao.findByBoardId(Long.valueOf(1));
	}

	@Test
	void save() {
		Board params = Board.builder()
							.boardTitle("1번 게시글 제목")
							.boardContents("1번 게시글 내용")
							.writeId("User1")
							.writeDate(LocalDateTime.now())
							.build();

		this.boardDao.saveBoard(params);

		Board entity = this.boardDao.findByBoardId(Long.valueOf(11));
		
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

		this.boardDao.updateBoard(params);

		Board entity = this.boardDao.findByBoardId(Long.valueOf(2));

		assertThat(entity.getBoardTitle()).isEqualTo("2번 게시글 제목");
		assertThat(entity.getBoardContents()).isEqualTo("2번 게시글 내용");
		assertThat(entity.getModifyId()).isEqualTo("User2");
	}

	@Test
	void delete() {
		this.boardDao.deleteBoard(Long.valueOf(1));
	}
}

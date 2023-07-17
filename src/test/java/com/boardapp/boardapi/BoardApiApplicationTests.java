package com.boardapp.boardapi;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.boardapp.boardapi.board.mapper.BoardMapper;
import com.boardapp.boardapi.board.model.Board;

@SpringBootTest
class BoardApiApplicationTests {
	@Autowired
	BoardMapper boardMapper;

	@Test
	void findAll() {
		List<Board> entityList = this.boardMapper.findAllBoards();
	}

	@Test
	void findById() {
		Board entity = this.boardMapper.findByBoardId(Long.valueOf(1));
	}

	@Test
	void save() {
		Board params = Board.builder()
							.boardTitle("1번 게시글 제목")
							.boardContents("1번 게시글 내용")
							.writeId("User1")
							.writeDate(LocalDateTime.now())
							.build();

		this.boardMapper.saveBoard(params);

		Board entity = this.boardMapper.findByBoardId(Long.valueOf(1));

		assertThat(entity.getBoardTitle()).isEqualTo("1번 게시글 제목");
		assertThat(entity.getBoardContents()).isEqualTo("1번 게시글 내용");
		assertThat(entity.getWriteId()).isEqualTo("User1");
	}

	@Test
	void update() {

	}

	@Test
	void delete() {

	}
}

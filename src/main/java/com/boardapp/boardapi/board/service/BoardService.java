package com.boardapp.boardapi.board.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.model.BoardUpdateDto;
import com.boardapp.boardapi.board.model.BoardWithCreator;
import com.boardapp.boardapi.board.model.BoardWithEditor;
import com.boardapp.boardapi.common.mapper.master.MasterDatabaseMapper;

@Service
public class BoardService {
    private final MasterDatabaseMapper masterDatabaseMapper;

    public BoardService(MasterDatabaseMapper masterDatabaseMapper) {
        this.masterDatabaseMapper = masterDatabaseMapper;
    }

    public List<Board> getAllBoards() throws Exception {
        return this.masterDatabaseMapper.getAllBoards();
    }

    public Board getBoardById(Long id) throws Exception {
        return this.masterDatabaseMapper.getBoardById(id);
    }

    public BoardWithCreator getBoardWithCreatorById(Long id) throws Exception {
        return this.masterDatabaseMapper.getBoardWithCreatorById(id);
    }

    public BoardWithEditor getBoardWithEditorById(Long id) throws Exception {
        BoardWithEditor data = this.masterDatabaseMapper.getBoardWithEditorById(id);

        if (data.getModifyId() == null) {

            return null;
        }

        return data;
    }

    public void saveBoard(BoardSaveDto saveDto) throws Exception {
        this.masterDatabaseMapper.saveBoard(saveDto.toEntity());
    }

    public void updateBoard(Long id, BoardUpdateDto updateDto) throws Exception {
        this.masterDatabaseMapper.updateBoard(updateDto.toEntity(), id);
    }

    public void deleteBoard(Long id) throws Exception {
        this.masterDatabaseMapper.deleteBoard(id);
    }
}

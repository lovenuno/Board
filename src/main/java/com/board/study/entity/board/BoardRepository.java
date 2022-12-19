package com.board.study.entity.board;

import com.board.study.dto.board.BoardRequestDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    String UPDATE_BOARD = "UPDATE Board " +
            "SET title = :#{#boardRequestDto.title}, " +
            "content = :#{#boardRequestDto.content}, " +
            "update_time = NOW() " +
            "WHERE id = :#{#boardRequestDto.id}";

    @Transactional
    @Modifying
    @Query(value = UPDATE_BOARD, nativeQuery = true)
    public int updateBoard(@Param("boardRequestdDto") BoardRequestDto boardRequestDto);
}

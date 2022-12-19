package com.study.service;

import com.study.board.BoardRequestDto;
import com.study.board.BoardResponseDto;
import com.study.entity.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardRequestDto boardSaveDto){
        return boardRepository.save(boardSaveDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll(){
        return boardRepository.findAll().stream()
                // .map(entity -> new BoardResponseDto(entity))
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    public BoardResponseDto findById(Long id){
        return new BoardResponseDto(boardRepository.findById(id).get());
    }

    public int updateBoard(BoardRequestDto boardRequestDto){
        return boardRepository.updateBoard(boardRequestDto);
    }

    public void deleteById(Long id){
        boardRepository.deleteById(id);
    }
}

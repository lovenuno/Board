package com.study;

import com.study.board.BoardRequestDto;
import com.study.board.BoardResponseDto;
import com.study.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardApplicationTests {

//	@Test
//	void contextLoads() {
//	}
//
//	@Autowired
//	private ApplicationContext context;
//
//	@Autowired
//	private SqlSessionFactory sessionFactory;
//
//	@Test
//	public void testByApplicationContext() {
//		try {
//			System.out.println("=========================");
//			System.out.println(context.getBean("sqlSessionFactory"));
//			System.out.println("=========================");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testByApplicationContextByName() {
//		try {
//			System.out.println("=========================");
//			System.out.println(context.getBean("abc"));
//			System.out.println("=========================");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testBySqlSessionFactory() {
//		try {
//			System.out.println("=========================");
//			System.out.println(sessionFactory.toString());
//			System.out.println("=========================");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Autowired
	private BoardService boardService;

	@Test
	void save(){
		BoardRequestDto boardRequestDto = new BoardRequestDto();

		boardRequestDto.setTitle("title");
		boardRequestDto.setContent("content");
		boardRequestDto.setRegisterId("user id");

		Long result = boardService.save(boardRequestDto);

		if (result > 0){
			System.out.println("# Success save()");
			findAll();
			findById(result);
		}else {
			System.out.println("# Fail save()");
		}
	}

	void findAll(){
		List<BoardResponseDto> list = boardService.findAll();

		if(list != null){
			System.out.println("# Success findAll() : " + list.toString());
		} else {
			System.out.println("# Fail findAll()");
		}
	}

	void findById(Long id){
		BoardResponseDto boardResponseDto = boardService.findById(id);

		if(boardResponseDto != null){
			System.out.println("# Success findById()" + boardResponseDto.toString());
			updateBoard(id);
		} else {
			System.out.println("# Fail findById()");
		}
	}

	void updateBoard(Long id){
		BoardRequestDto boardRequestDto = new BoardRequestDto();

		boardRequestDto.setId(id);
		boardRequestDto.setTitle("title2");
		boardRequestDto.setContent("content2");
		boardRequestDto.setRegisterId("new id");

		int result = boardService.updateBoard(boardRequestDto);

		if (result > 0 ) {
			System.out.println("# Success updateBoard()");
		} else {
			System.out.println("# Faiol updateBoard()");
		}
	}
}

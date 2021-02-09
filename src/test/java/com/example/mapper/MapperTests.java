package com.example.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {

	@Setter(onMethod_=@Autowired)
	private BoardMapper b_mapper;
	
	public void testInsert() {
		log.info("testInsert");
		BoardVO board = new BoardVO();
		board.setTitle("게시글 등록");
		board.setContent("게시글 등록");
		board.setWriter("user01");
		b_mapper.insertSelectKey_bno(board);
	}
	
	public void testGetBoard() {
		log.info("testGetBoard");
		Long bno = 1L;
		log.info("------------------------------------");
		//b_mapper.getAll().forEach(log::info);
		log.info(b_mapper.getBoard(bno));
		log.info("------------------------------------");
	}
	
	@Test
	public void testGetList() {
		log.info("testGetList");
		//b_mapper.getListAll().forEach(log::info);
	}

	public void testDelete() {
		log.info("testDelete");
		Long bno = 1L;
		b_mapper.delete(bno);
	}
	
}

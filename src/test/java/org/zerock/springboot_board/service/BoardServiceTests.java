package org.zerock.springboot_board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.springboot_board.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        BoardDTO dto = BoardDTO.builder()
                .title("Test..")
                .content("test.........")
                .writerEmail("test@sest.com")
                .build();

        Long bno = boardService.register(dto);
    }
}

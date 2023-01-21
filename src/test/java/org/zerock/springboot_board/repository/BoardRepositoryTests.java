package org.zerock.springboot_board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.springboot_board.enitty.Board;
import org.zerock.springboot_board.enitty.Member;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@test.com")
                    .build();

            Board board = Board.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .writer(member)
                    .build();

            boardRepository.save(board);
        });
    }

    @Transactional // 해당 메서드를 전부 하나의 transaction 으로 처리하자
    @Test
    public void testRead1(){

        Optional<Board> result = boardRepository.findById(100L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());
    }

    @Test
    public void testReadWuthWriter(){
        Object result = boardRepository.getBoardWithWriter(100L);
        Object[] arr = (Object[])result;

        System.out.println("::::::::::::::::::::::::::::::::::;");
        System.out.println(Arrays.toString(arr));

    }
}

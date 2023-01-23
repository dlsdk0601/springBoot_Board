package org.zerock.springboot_board.service;

import org.zerock.springboot_board.dto.BoardDTO;
import org.zerock.springboot_board.enitty.Board;
import org.zerock.springboot_board.enitty.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    default Board dtoToEntity(BoardDTO dto){

        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Board board = Board.builder().bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();

        return board;
    }
}

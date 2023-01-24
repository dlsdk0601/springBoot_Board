package org.zerock.springboot_board.service;

import org.zerock.springboot_board.dto.PageResultDTO;
import org.zerock.springboot_board.dto.PageRequestDTO;
import org.zerock.springboot_board.enitty.Board;
import org.zerock.springboot_board.enitty.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDto pageRequestDTO);

    default Board dtoToEntity(BoardDTO dto){

        Member member = Member
                .builder()
                .email(dto.getWriterEmail())
                .build();

        return Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
    }

    // BoardService 인터페이스에 추가하는 entityToDTO()
    default BoardDTO entityToDTO(Board board, Member member, Long replyCount){

        return BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())
                .build();
    }
}

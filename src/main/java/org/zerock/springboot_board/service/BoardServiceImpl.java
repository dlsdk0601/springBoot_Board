package org.zerock.springboot_board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.springboot_board.dto.BoardDTO;
import org.zerock.springboot_board.dto.PageRequestDTO;
import org.zerock.springboot_board.dto.PageResultDTO;
import org.zerock.springboot_board.enitty.Board;
import org.zerock.springboot_board.enitty.Member;
import org.zerock.springboot_board.repository.BoardRepository;
import org.zerock.springboot_board.repository.ReplyRepository;

import javax.transaction.Transactional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    private final ReplyRepository replyRepository;

    @Override
    public Long register(BoardDTO dto){

        log.info(dto);

        Board board = dtoToEntity(dto);

        repository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO){
        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board)en[0], (Member)en[1], (Long)en[2]));

        Page<Object[]> result = repository.getBoardWithReplyCount(
                pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO get(Long bno){
        Object result = repository.getBoardByBno(bno);

        Object[] arr = (Object[]) result;

        return entityToDTO((Board) arr[0], (Member) arr[1], (Long) arr[2]);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno){
        // 삭제 기능
        // 트랜잭션 추가

        replyRepository.deleteByBno(bno);

        repository.deleteById(bno);
    }

    @Transactional
    @Override
    public void modify(BoardDTO boardDTO){
        // 책에서는 modify 는 findById 를 이용하는 대신에 필요한 순간까지 로딩을 지연하는 방식인 getOne를 이용한다고 나와있지만,
        // 해당 메서드는 드랍 된거같아서 getReferenceById 로 대체
        Board board = repository.getReferenceById(boardDTO.getBno());

        board.changeTitle(boardDTO.getTitle());
        board.changeContent(boardDTO.getContent());

        repository.save(board);
    }
}

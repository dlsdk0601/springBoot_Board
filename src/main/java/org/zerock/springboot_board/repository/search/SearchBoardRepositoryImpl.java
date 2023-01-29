package org.zerock.springboot_board.repository.search;

import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.springboot_board.enitty.Board;
import org.zerock.springboot_board.enitty.QBoard;

import java.util.List;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository{
    // QuerydslRepositorySupport 클래스를 상속해야한다.
    // QuerydslRepositorySupport 는 생성자가 존재하므로 클래스 내에서
    // super 를 이용해서 호출해야한다.

    public SearchBoardRepositoryImpl(){
        super(Board.class);
    }

    @Override
    public Board search1(){
        log.info("search1...............");

        QBoard board = QBoard.board;

        JPQLQuery<Board> jpqlQuery = from(board);

        jpqlQuery.select(board).where(board.bno.eq(1L));

        log.info("-------------------------------");
        log.info(jpqlQuery);
        log.info("-------------------------------");

        List<Board> result = jpqlQuery.fetch();
        return null;
    }
}

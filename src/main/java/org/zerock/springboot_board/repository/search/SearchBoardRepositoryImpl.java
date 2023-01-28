package org.zerock.springboot_board.repository.search;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.springboot_board.enitty.Board;

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

        return null;
    }
}

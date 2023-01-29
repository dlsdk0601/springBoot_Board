package org.zerock.springboot_board.repository.search;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import jdk.jfr.MemoryAddress;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.springboot_board.enitty.Board;
import org.zerock.springboot_board.enitty.QBoard;
import org.zerock.springboot_board.enitty.QMember;
import org.zerock.springboot_board.enitty.QReply;

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
        QReply reply = QReply.reply;
        QMember member = QMember.member;

        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(reply).on(reply.board.eq(board));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(board, member.email, reply.count());
        // 각각의 데이터를 추출하는 경유, Tuple를 이용하면 된다.
        tuple.groupBy(board);

        log.info("-------------------------------");
        log.info(jpqlQuery);
        log.info("-------------------------------");

        List<Tuple> result = tuple.fetch();
        return null;
    }
}

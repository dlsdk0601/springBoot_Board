package org.zerock.springboot_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.springboot_board.enitty.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
//    한개의 low 내에 list 로 나옴
    @Query("select b, w from Board b left join b.writer w where b.bno =:bno")
    Object getBoardWithWriter(@Param("bno") Long bno);
}

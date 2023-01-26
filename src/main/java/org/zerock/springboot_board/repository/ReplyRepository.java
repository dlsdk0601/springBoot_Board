package org.zerock.springboot_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.springboot_board.enitty.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Modifying // update, delete 를 실행하기 위해 필요한 어노테이션이다.
    @Query("delete from Reply r where r.board.bno = :bno")
    void deleteByBno(Long bno);

}

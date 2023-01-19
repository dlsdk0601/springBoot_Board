package org.zerock.springboot_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.springboot_board.enitty.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

}

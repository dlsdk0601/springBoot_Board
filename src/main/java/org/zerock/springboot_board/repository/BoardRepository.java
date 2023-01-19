package org.zerock.springboot_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.springboot_board.enitty.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

package org.zerock.springboot_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.springboot_board.enitty.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}

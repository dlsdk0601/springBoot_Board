package org.zerock.springboot_board.enitty;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    // TODO :: 작성자도 나중에 추가
    @ManyToOne
    private Member writer;
}

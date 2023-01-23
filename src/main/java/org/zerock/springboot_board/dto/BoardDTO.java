package org.zerock.springboot_board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long bno;

    private String title;

    private String content;

    private String writerEmail;

    private String writerName;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private int replyCount;
}

// BoardDTO class 와 Board entity Class 가 다른 점은 Member 를 참조하는 대신에
// 화면에서 필요한 작성자 이메일, 작성자 이름으로 처리한다는 점이다
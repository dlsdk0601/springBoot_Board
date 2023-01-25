package org.zerock.springboot_board.enitty;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity{

    @Id
    private String email;

    private String password;

    private String name;
}

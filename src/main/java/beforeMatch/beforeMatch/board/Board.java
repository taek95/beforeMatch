package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.BaseTimeEntity;
import beforeMatch.beforeMatch.member.Member;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String title;
    public String content;
    public Integer good;

    @ManyToOne
    public Member member;
}

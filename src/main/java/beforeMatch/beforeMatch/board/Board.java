package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String title;
    public String content;
    public LocalDateTime time;
    public int good;

    @ManyToOne
    @JoinColumn(name = "memid")
    public Member member;
}

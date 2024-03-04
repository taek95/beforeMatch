package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter @Setter
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String title;
    public String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date time;

    public int good;

    @ManyToOne
    @JoinColumn(name = "memid")
    public Member member;
}

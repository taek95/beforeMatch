package beforeMatch.beforeMatch.member;

import beforeMatch.beforeMatch.board.Board;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // JPA가 관리할 객체
@Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id : PK매핑, 자동생성,
    public Integer id;
    public String memberId;
    @Pattern(regexp = "^[a-zA-Z0-9]+@[0-9a-zA-Z]+\\.[a-z]+$", message = "이메일 형식을 지켜주시기 바랍니다.")
    public String memberEmail;
    public String memberPwd;
    public String memberAddress;
    @Pattern(regexp = "^[ㄱ-ㅎ|가-힣]*$", message = "한글만 가능합니다.")
    @Size(max=5, message = "이름의 최대 길이는 5자 입니다.")
    public String memberName;
    @OneToMany(mappedBy = "member")
    List<Board> boards = new ArrayList<>();
}

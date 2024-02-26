package beforeMatch.beforeMatch.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity // JPA가 관리할 객체
@Getter @Setter
public class Member {

    @Id @GeneratedValue // @Id : PK매핑
    public Long id;

    @Pattern(regexp = "^[ㄱ-ㅎ|가-힣]*$", message = "한글만 가능합니다.")
    @Size(max=5, message = "이름의 최대 길이는 5자 입니다.")
    public String memberName;
    @Pattern(regexp = "^[a-zA-Z0-9]+@[0-9a-zA-Z]+\\.[a-z]+$", message = "이메일 형식을 지켜주시기 바랍니다.")
    public String memberEmail;
    @Pattern(regexp = "^(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{10,128}+$", message = "대소문자 + 숫자 + 특수문자 조합으로 10자리 이상 입력해 주세요")
    public String memberPwd;
    public String memberAddress;

}

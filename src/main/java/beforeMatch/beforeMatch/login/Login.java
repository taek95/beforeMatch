package beforeMatch.beforeMatch.login;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

//`
@Getter @Setter
public class Login {
    @Pattern(regexp = "^[a-zA-Z0-9]+@[0-9a-zA-Z]+\\.[a-z]+$", message = "이메일이 형식에 맞지 않습니다.")
    public String loginEmail;
    @Pattern(regexp = "^(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{10,128}+$", message = "비밀번호를 잘못 입력하셨습니다.")
    public String loginPwd;
    public String memberName;

}

package beforeMatch.beforeMatch.login;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

//`
@Getter @Setter
public class Login {

    public String loginId;

    public String loginPwd;

    public String memberName;

}

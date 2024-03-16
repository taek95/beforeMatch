package beforeMatch.beforeMatch.record;

import beforeMatch.beforeMatch.login.Login;
import beforeMatch.beforeMatch.login.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class recordController {

    @GetMapping("/record/list")
    public String record(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model) {
        model.addAttribute("loginMember", loginMember);
        return "record/recordList";
    }
}

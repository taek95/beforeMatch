package beforeMatch.beforeMatch;

import beforeMatch.beforeMatch.login.Login;
import beforeMatch.beforeMatch.login.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    @GetMapping("/")
    public String loginHome(
            // 이미 로그인된 사용자 찾을 때, required = false 하면 새로운 세션을 생성하지 않는다.
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember, Model model) {
        if(loginMember == null) return "home";
        model.addAttribute("loginMember", loginMember);
//        if(loginMember.getLoginId().equals("fcista"))
//            return "test";
        return "test";
    }

}

package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.login.Login;
import beforeMatch.beforeMatch.login.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String board(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember, Model model){
        if (loginMember == null) return "home";

        model.addAttribute(loginMember);
        return "board/boardForm";
    }

//    @PostMapping("/board/add")
//    public String addBoard() {
//
//    }
}

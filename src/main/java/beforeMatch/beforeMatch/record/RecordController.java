package beforeMatch.beforeMatch.record;

import beforeMatch.beforeMatch.board.Board;
import beforeMatch.beforeMatch.login.Login;
import beforeMatch.beforeMatch.login.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RecordController {

    @GetMapping("/record/list")
    public String record(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model) {
        model.addAttribute("loginMember", loginMember);
        return "record/recordList";
    }

    @GetMapping("/record/add")
    public String addRecord(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model) {
        model.addAttribute("loginMember", loginMember);
        model.addAttribute("record",new Record());
        return "record/addRecordForm";
    }

    @PostMapping("/record/add")
    public String addRecord(
            @Validated Record record, BindingResult bindingResult,
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model) {
        model.addAttribute("loginMember", loginMember);
        return "record/recordList";
    }
}

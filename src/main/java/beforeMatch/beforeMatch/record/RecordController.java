package beforeMatch.beforeMatch.record;

import beforeMatch.beforeMatch.board.Board;
import beforeMatch.beforeMatch.login.Login;
import beforeMatch.beforeMatch.login.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @GetMapping("/record/list")
    public String record(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model) {
        List<Record> records = recordService.findAll();
        model.addAttribute("records", records);
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

        recordService.save(record);
        model.addAttribute("loginMember", loginMember);
        return "redirect:/record/list";

    }
}
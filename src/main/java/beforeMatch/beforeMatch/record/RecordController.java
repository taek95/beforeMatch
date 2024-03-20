package beforeMatch.beforeMatch.record;

import beforeMatch.beforeMatch.board.Board;
import beforeMatch.beforeMatch.login.Login;
import beforeMatch.beforeMatch.login.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/record/edit/{id}")
    public String editRecord(
            @Validated Record record, BindingResult bindingResult,
            @PathVariable String id,
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model) {

        model.addAttribute("record",recordService.findRecord(id));
        model.addAttribute("loginMember", loginMember);
        return "record/editRecordForm";

    }
    @PatchMapping("/record/edit")
    public String editRecord(
            @Validated Record record, BindingResult bindingResult,
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model) {

        recordService.save(record);
        model.addAttribute("loginMember", loginMember);
        return "redirect:/record/list";

    }

    @DeleteMapping("/record/list/{id}")
    public String deleteRecord(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            @PathVariable String id,
            Model model) {

        recordService.recordDelete(id);
        model.addAttribute("loginMember",loginMember);
        return "redirect:/record/list";

    }

}

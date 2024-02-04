package beforeMatch.beforeMatch.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/add")
    public String addMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "member/addMemberForm";
    }

    @PostMapping("/member/add")
    public String addMemberSave(@Validated Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) return "member/addMemberForm";
        else {
            try {
                memberService.join(member);
            }catch(IllegalStateException e) {
                bindingResult.addError(new FieldError("member","memberEmail","이미 존재하는 이메일 입니다."));
                return "member/addMemberForm";
            }
        }
        return "redirect:/";
    }
}

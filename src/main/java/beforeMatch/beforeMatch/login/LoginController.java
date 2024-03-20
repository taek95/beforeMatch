package beforeMatch.beforeMatch.login;

import beforeMatch.beforeMatch.member.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login",new Login());
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String loginCheck(@Validated Login login, BindingResult bindingResult, HttpServletRequest request) {
        if(bindingResult.hasErrors()) return "login/loginForm";
        else {
            try {
                Member member = loginService.login(login);
                login.setMemberName(member.getMemberName());
            }catch(IllegalStateException e) {
                bindingResult.addError(new FieldError("login", "loginPwd", e.getMessage()));
                return "login/loginForm";
            }catch (NullPointerException ne){
                bindingResult.addError(new FieldError("login", "loginId", ne.getMessage()));
                return "login/loginForm";
            }

        }
        // 세션이 있으면 가져오고 없으면 새로 생성해서 return
        HttpSession session = request.getSession(true);
        session.setAttribute(SessionConst.LOGIN_MEMBER, login);
        return "redirect:/";
        }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) session.invalidate();
        return "home";
    }
}

package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.login.Login;
import beforeMatch.beforeMatch.login.SessionConst;
import beforeMatch.beforeMatch.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.awt.print.Pageable;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String board(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model)
    {
        if (loginMember == null) return "home";
        model.addAttribute("loginMember",loginMember);
        return "board/boardForm";
    }

    @GetMapping("/board/add")
    public String addBoard(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember, Model model){
        if (loginMember == null) return "home";
        Member member = boardService.findMember(loginMember.getLoginId());
        Board board = new Board();
        board.setMember(member);
        model.addAttribute("loginMember",loginMember);
        model.addAttribute("board", board);
        model.addAttribute("member", member);
        return "board/addBoardForm";
    }

    @PostMapping("/board/add")
    public String addBoard(@Validated Board board, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "board/addBoardForm";
        boardService.save(board);
        return "board/boardForm";

    }
}

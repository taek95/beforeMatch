package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.login.Login;
import beforeMatch.beforeMatch.login.SessionConst;
import beforeMatch.beforeMatch.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping("/board")
    public String board(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model, Pageable pageable)
    {
        if (loginMember == null) return "home";
        Page<Board> page = boardRepository.findAll(pageable);
        model.addAttribute("loginMember",loginMember);
        model.addAttribute("list",page);
        return "board/boardForm";
    }

    @GetMapping("/board/add")
    public String addBoard(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember, Model model){
        if (loginMember == null) return "home";
        model.addAttribute("loginMember",loginMember);
        model.addAttribute("board", new Board());
        return "board/addBoardForm";
    }

    @PostMapping("/board/add")
    public String addBoard(@Validated Board board, BindingResult bindingResult,
                           @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
                           Model model) {
        if(bindingResult.hasErrors())
            return "board/addBoardForm";
        Member member = boardService.findMember(loginMember.getLoginId());
        board.setMember(member);
        boardService.save(board);
        model.addAttribute("loginMember",loginMember);
        return "board/boardForm";

    }
}

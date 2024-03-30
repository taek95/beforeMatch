package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.login.Login;
import beforeMatch.beforeMatch.login.SessionConst;
import beforeMatch.beforeMatch.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public String boardList(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            Model model,
            // 쿼리스트링 형식으로 요청이 들어오면 pageable이 객체를 자동으로 만들어준다.
            @PageableDefault(page= 0,size=10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable)
    {
        Page<Board> list = boardService.boardList(pageable);
        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4,1);
        int endPage = nowPage+2;

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);

        if(list.getSize() == 0) {
            model.addAttribute("endPage", nowPage);
        }
        else {
            model.addAttribute("endPage", endPage);
        }

        if(loginMember == null)
            return "board/boardList";
        else {
            model.addAttribute("loginMember", loginMember);
            return "board/loginBoardList";
        }

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
        return "redirect:/board/list";

    }

    @GetMapping("/board/{id}")
    public String findBoard(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            @PathVariable Integer id,
            Model model){
        model.addAttribute("board", boardService.findBoard(id));
        if (loginMember == null) return "board/content";
        model.addAttribute("loginMember",loginMember);
        return "board/loginContent";
    }

    @DeleteMapping("/board/list/{id}")
    public String deleteBoardContent(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Login loginMember,
            @PathVariable Integer id,
            Model model) {

        boardService.boardContentDelete(id);
        model.addAttribute("loginMember",loginMember);
        return "redirect:/board/list";

    }
}

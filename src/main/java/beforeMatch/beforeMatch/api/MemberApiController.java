package beforeMatch.beforeMatch.api;

import beforeMatch.beforeMatch.member.Member;
import beforeMatch.beforeMatch.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 회원 가입 api
@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    @PostMapping("api/members")
    public CreateMemberResponse saveMember(@RequestBody Member member) {
        int id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    static class CreateMemberResponse {
        private int id;
        public CreateMemberResponse(int id) {
            this.id = id;
        }
    }
}

package beforeMatch.beforeMatch.api;

import beforeMatch.beforeMatch.member.Member;
import beforeMatch.beforeMatch.member.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 회원 가입 api
@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/members")
    public CreateMemberResponse saveMember(@RequestBody CreateMemberRequest request) {
        Member member = new Member();
        member.setMemberName(request.getName());
        int id = memberService.join(member);
        return new CreateMemberResponse(id);
    }
    @Data
    public static class CreateMemberRequest {
        private String name;
    }

    @Data
    public static class CreateMemberResponse {
        private int id;
        public CreateMemberResponse(int id) {
            this.id = id;
        }
    }
}

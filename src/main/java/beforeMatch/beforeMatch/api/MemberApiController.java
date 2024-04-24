package beforeMatch.beforeMatch.api;

import beforeMatch.beforeMatch.member.Member;
import beforeMatch.beforeMatch.member.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    // 회원 등록 api
    @PostMapping("/api/members")
    public CreateMemberResponse saveMember(@RequestBody CreateMemberRequest request) {
        Member member = new Member();
        member.setMemberName(request.getMemberName());
        member.setMemberId(request.getMemberId());
        String memberId = memberService.join(member);
        return new CreateMemberResponse(memberId);
    }

    // 회원 수정 api, memberId가 들어오면 memberName을 수정
    @PutMapping("/api/members/{memberId}")
    public UpdateMemberResponse updateMember(
            @PathVariable("memberId") String memberId, @RequestBody UpdateMemberRequest request) {
        memberService.update(memberId, request.getMemberName());
        Member findMember = memberService.findOne(memberId);
        return new UpdateMemberResponse(findMember.getMemberId(),findMember.getMemberName());
    }

    @Data
    public static class CreateMemberRequest {
        private String memberName;
        private String memberId;
    }

    @Data
    public static class CreateMemberResponse {
        private String memberId;
        public CreateMemberResponse(String memberId) {
            this.memberId = memberId;
        }
    }

    @Data
    public static class UpdateMemberRequest {
        private String memberName;
    }

    @Data
    @AllArgsConstructor
    public static class UpdateMemberResponse {
        private String memberId;
        private String memberName;
    }
}

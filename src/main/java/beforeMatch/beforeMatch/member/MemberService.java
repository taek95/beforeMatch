package beforeMatch.beforeMatch.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String join(Member member) {

        validateDuplicateUser(member);
        memberRepository.save(member);
        return member.getMemberId();
    }
    private void validateDuplicateUser(Member member) {
        List<Member> findMembers = memberRepository.findByMemberId(member.getMemberId());
        if(!findMembers.isEmpty()) throw new IllegalStateException("이미 존재하는 아이디입니다.");
    }
    public Member findOne(String memberId) {
        return memberRepository.findOne(memberId);
    }
    @Transactional // 변경감지
    public void update(String memberId, String name) {
        Member member = memberRepository.findOne(memberId);
        member.setMemberName(name);
    }
}

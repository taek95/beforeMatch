package beforeMatch.beforeMatch.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void join(Member member) {

        validateDuplicateUser(member);
        memberRepository.save(member);
//        return member.getId();
    }

    private void validateDuplicateUser(Member member) {
        List<Member> findMembers = memberRepository.findByMemberEmail(member.getMemberEmail());
        if(!findMembers.isEmpty()) throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
}

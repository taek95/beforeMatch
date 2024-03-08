package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.member.Member;
import beforeMatch.beforeMatch.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public Member findMember(String loginId) {
        return memberRepository.findOne(loginId);
    }

}

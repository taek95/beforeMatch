package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public Member find(String loginId) {
        return boardRepository.findByMemberId(loginId);

    }
}

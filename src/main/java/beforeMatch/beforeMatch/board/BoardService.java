package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.member.Member;
import beforeMatch.beforeMatch.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }

    public Member findMember(String loginId) {
        return memberRepository.findOne(loginId);
    }

    public Board findBoard(int boardId) {
        return boardRepository.getReferenceById(boardId);
    }

    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public void boardContentDelete(int boardId) {
        boardRepository.deleteById(boardId);
    }
}

package beforeMatch.beforeMatch.record;


import beforeMatch.beforeMatch.board.Board;
import beforeMatch.beforeMatch.board.BoardRepository;
import beforeMatch.beforeMatch.member.Member;
import beforeMatch.beforeMatch.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;

    public void save(Record record) {
        recordRepository.save(record);
    }
}

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

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;

    public void save(Record record) {
        recordRepository.save(record);
    }
    public List<Record> findAll() {
        return recordRepository.findAll();
    }
    public Record findRecord(String recordId) {
        return recordRepository.getReferenceById(recordId);
    }
    public void recordDelete(String recordId) {
        recordRepository.deleteById(recordId);
    }


}

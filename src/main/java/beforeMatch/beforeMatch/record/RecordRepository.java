package beforeMatch.beforeMatch.record;

import beforeMatch.beforeMatch.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, String> {

//    // 페이징 기능
//    @Override
//    Page<Board> findAll(Pageable pageable);

}


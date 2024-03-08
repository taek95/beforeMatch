package beforeMatch.beforeMatch.board;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    // 페이징 기능
    Page<Board> findAll(Pageable pageable);

}

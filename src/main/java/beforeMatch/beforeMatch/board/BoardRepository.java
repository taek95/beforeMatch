package beforeMatch.beforeMatch.board;

import beforeMatch.beforeMatch.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Member findByMemberMemberId(String loginId);
    //    // 페이지네이션
//    Page<Board> find
}

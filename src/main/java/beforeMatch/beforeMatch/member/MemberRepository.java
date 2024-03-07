package beforeMatch.beforeMatch.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext // 영속성 컨텍스트
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(String memberId) {
        return em.find(Member.class, memberId);
    }

    public List<Member> findByMemberId(String memberId) {
        return em.createQuery("select m from Member m where m.memberId = :memberId" , Member.class)
                .setParameter("memberId",memberId)
                .getResultList();
    }


}

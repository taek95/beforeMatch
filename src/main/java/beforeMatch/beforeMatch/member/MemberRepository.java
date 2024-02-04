package beforeMatch.beforeMatch.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findByMemberEmail(String memberEmail) {
        return em.createQuery("select m from Member m where m.memberEmail = :memberEmail" , Member.class)
                .setParameter("memberEmail",memberEmail)
                .getResultList();
    }


}

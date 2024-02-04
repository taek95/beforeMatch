package beforeMatch.beforeMatch.login;

import beforeMatch.beforeMatch.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoginRepository {

    @PersistenceContext
    private EntityManager em;

    public Optional<Member> findByLoginEmail(String loginEmail) {
        List<Member> members = em.createQuery("select m from Member m where m.memberEmail = :memberEmail", Member.class)
                .setParameter("memberEmail", loginEmail)
                .getResultList();
        return members.stream().findAny();
    }
}

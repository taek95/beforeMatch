package beforeMatch.beforeMatch.login;

import beforeMatch.beforeMatch.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final LoginRepository loginRepository;

    public Member login(Login login) {
        Optional<Member> findMember = loginRepository.findByLoginEmail(login.getLoginEmail());
        if(findMember.isEmpty()) throw new NullPointerException("아이디가 존재하지 않습니다.");

        Member member = findMember.get();
        if (!member.getMemberPwd().equals(login.getLoginPwd()))
            throw new IllegalStateException("비밀번호가 다릅니다.");
        return member;
    }
}

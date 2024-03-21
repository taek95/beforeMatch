package beforeMatch.beforeMatch;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// builder 패턴 : 빌더 패턴은 객체 생성을 보다 유연하고 가독성 높은 방식으로 구현할 수 있어, 객체 생성 로직이 복잡한 경우 유용
@Data
@MappedSuperclass // JPA가 테이블로 매핑하지 않고 자식들에게 상속을 통해 컬럼 정보만 제공
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될 대의 시간을 자동으로 넣어준다.
    private LocalDateTime createAt;
    @LastModifiedDate // 수정되는 시간을 자동으로 업데이트
    private LocalDateTime updateAt;
}


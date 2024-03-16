package beforeMatch.beforeMatch.record;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Record {

    @Id
    public String backNum;
    public String name;
    public String matchNum;
    public String score;
    public String assist;

}

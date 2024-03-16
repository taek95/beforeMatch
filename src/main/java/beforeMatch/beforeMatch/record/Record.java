package beforeMatch.beforeMatch.record;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Record {

    @Id
    public String backNum;
    public String name;
    public String matchNum;
    public String score;
    public String assist;

}

package beforeMatch.beforeMatch.squad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SquadController {

    @GetMapping("/squad/add")
    public String addSquad() {
        return "squad/addSquadForm";
    }
}

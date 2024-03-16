package beforeMatch.beforeMatch.record;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class recordController {

    @GetMapping("/record")
    public String record() {
        return "record/recordList";
    }
}

package vitorreis.discussion.api;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscussionController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/discussion")
    public Discussion greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Discussion(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

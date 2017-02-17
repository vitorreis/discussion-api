package vitorreis.discussion.api;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vitorreis.discussion.api.model.Discussion;

@RestController
public class DiscussionController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/discussion")
    public Discussion greeting(@RequestParam(value="name") String name) {
        return new Discussion(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

package vitorreis.discussion.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import vitorreis.discussion.api.dto.UserDto;
import vitorreis.discussion.api.model.User;

@RestController
public class UserController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path="/user", method= RequestMethod.POST)
    public User create(@RequestBody UserDto userDto) {
        return new User(counter.incrementAndGet(), userDto.getName());
    }
}

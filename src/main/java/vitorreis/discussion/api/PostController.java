package vitorreis.discussion.api;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import vitorreis.discussion.api.dto.PostDto;
import vitorreis.discussion.api.model.Post;

@RestController
public class PostController {

    private final AtomicLong counter = new AtomicLong();
    private final HashMap<Long, Post> posts = new HashMap<>();

    @RequestMapping(path="v1/post/{id}/reply", method= RequestMethod.POST)
    public Post reply(
        @PathVariable("id") Long parentId,
        @RequestBody PostDto postDto
    )
    {
        Post post = new Post(counter.incrementAndGet(), Optional.of(parentId), postDto.getBody());

        savePost(post);

        return post;
    }

    // todo: fix conflict with routes and remove "new" as a path
    @RequestMapping(path = "v1/post/new", method= RequestMethod.POST)
    public Post create(
        @RequestBody PostDto postDto
    )
    {
        Post post = new Post(counter.incrementAndGet(), Optional.empty(), postDto.getBody());

        savePost(post);

        return post;
    }

    @RequestMapping(path = "v1/post", method= RequestMethod.GET)
    public List<Post> query()
    {
        return posts.values().stream()
            .filter(post -> post.getParentId().isPresent() == false)
            .collect(Collectors.toList());
    }

    @RequestMapping(path="v1/post/{id}", method= RequestMethod.GET)
    public Post getById(
        @PathVariable("id") Long id
    )
    {
        return posts.get(id);
    }

    private void savePost(Post post) {
        posts.put(post.getId(), post);
    }
}

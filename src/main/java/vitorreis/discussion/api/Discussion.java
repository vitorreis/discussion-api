package vitorreis.discussion.api;

public class Discussion {

    private final long id;
    private final String content;

    public Discussion(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

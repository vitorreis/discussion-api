package vitorreis.discussion.api.model;

import java.time.OffsetDateTime;
import java.util.Optional;

public class Post {
    private final Long id;
    private Optional<Long> parentId;
    private final String body;
    private User createdBy;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Post(Long id, Optional<Long> parentId, String body) {
        this.id = id;
        this.parentId = parentId;
        this.body = body;
        this.createdBy = createdBy;
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

//    public User getCreatedBy() {
//        return createdBy;
//    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Optional<Long> getParentId() {
        return parentId;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;


    }
}

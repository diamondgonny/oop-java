package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class Post {
    private String title;
    private String body;
    private User author;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime updatedDateTime;
    private HashSet<String> tags;
    private ArrayList<Comment> comments;
    private ReactionType reactionType;

    private enum ReactionType {
        GREAT,
        SAD,
        ANGRY,
        FUN,
        LOVE
    }

    public Post(User author, String title, String body) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.createdDateTime = OffsetDateTime.now();
        this.updatedDateTime = createdDateTime;
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
        // *reactionType?
    }

    // setPostTitle
    public void setPostTitle(String title) {
        this.title = title;
    }

    // setPostBody
    public void setPostBody(String body) {
        this.body = body;
    }

    // addPostTag
    public void addPostTag(String tag) {
        this.tags.add(tag);
    }

    // addReaction

    // removeReaction

    // addComment

    // setComment

    // getCommentlist

}

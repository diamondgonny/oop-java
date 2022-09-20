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
    private HashSet<String> tags = new HashSet<>();
    private ArrayList<Comment> comments = new ArrayList<>();
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
        // tags, comments and *reactionType?
    }

    // setPostTitle

    // setPostBody

    // addPostTag

    // addReaction

    // removeReaction

    // addComment

    // setComment

    // getCommentlist

}

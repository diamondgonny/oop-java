package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class Comment {
    private String text;
    private ArrayList<Comment> subcomments = new ArrayList<>();
    private HashSet<User> upvoters = new HashSet<>();
    private HashSet<User> downvoters = new HashSet<>();
    private User author;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime updatedDateTime;

    public Comment(User author, String text) {
        this.author = author;
        this.text = text;
        this.createdDateTime = OffsetDateTime.now();
        this.updatedDateTime = createdDateTime;
        // subcomments, upvoters, downvoters?

    }

    // addSubcomment

    // setSubcomment

    // getSubcommentList

    // addUpvote

    // addDownvote

}

package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private String body;
    // private String tag;
    // private String author;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime updatedDateTime;
    private List<Comment> comments = new ArrayList<>();
    private ReactionType reactionType;


}

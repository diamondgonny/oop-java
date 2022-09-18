package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comment {
    private String text;
    private List<Comment> subcomments = new ArrayList<>();
    // private List<String> upvoters = new ArrayList<>();
    // private List<String> downvoters = new ArrayList<>();
    // private String author;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime updatedDateTime;


}

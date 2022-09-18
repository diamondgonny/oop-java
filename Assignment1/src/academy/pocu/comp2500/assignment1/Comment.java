package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Comment {
    private String text;
    private ArrayList<String> subcomments = new ArrayList<>();
    private ArrayList<String> upvoters = new ArrayList<>();
    private ArrayList<String> downvoters = new ArrayList<>();
    private OffsetDateTime createdDateTime;
    private OffsetDateTime updatedDateTime;


}

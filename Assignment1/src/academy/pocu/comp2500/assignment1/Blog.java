package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class Blog {
    private ArrayList<Post> posts;
    private User master;
    private OffsetDateTime createdDateTime;
    private HashSet<String> tagFilter = new HashSet<>();
    private User authorFilter;
    private SortingType sortingType;

    private enum SortingType {
        CREATED_DESC,
        CREATED_ASC,
        MODIFIED_DESC,
        MODIFIED_ASC,
        ABC_ASC
    }

    public Blog(User master) {
        this.master = master;
        this.createdDateTime = OffsetDateTime.now();
        this.posts = new ArrayList<>();
    }

    // setTagFilter

    // setAuthorFilter

    // setPostOrder

    /*
    public void addPost(Post post) {
        this.posts.add(post);
    }
     */

    //getPostList

}

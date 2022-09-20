package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class Blog {
    private ArrayList<Post> posts = new ArrayList<>();
    private HashSet<String> tagFilter = new HashSet<>();
    private User authorFilter;
    private SortingType sortingType;
    private OffsetDateTime createdDateTime;

    private enum SortingType {
        CREATED_DESC,
        CREATED_ASC,
        MODIFIED_DESC,
        MODIFIED_ASC,
        ABC_ASC
    }

    public Blog(User author) {}

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

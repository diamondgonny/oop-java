package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class Blog {
    private ArrayList<Post> posts;
    private User master;
    private OffsetDateTime createdDateTime;
    private HashSet<String> tagFilter;
    private User authorFilterOrNull;
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
        this.sortingType = SortingType.CREATED_DESC;
        this.tagFilter = new HashSet<>();
        this.authorFilterOrNull = null;
    }

    // addPost : boolean으로 성공여부까지 체크할 것인가?
    public void addPost(Post post) {
        this.posts.add(post);
    }

    //getPostList : PostList 통째로 읽어들이기... 어떻게?

    // setTagFilter : tags 받아와서, PostList중 선별해서 반환

    // setAuthorFilter : author 받아와서, PostList중 선별해서 반환

    // setPostOrder : sortingType 받아와서, PostList 정렬조건 선별해서 반환

}

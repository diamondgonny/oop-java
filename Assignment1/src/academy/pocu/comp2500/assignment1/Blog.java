package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;

public class Blog {
    private User master;
    private ArrayList<Post> posts;
    private HashSet<String> tagFilterOrNone;
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
        this.posts = new ArrayList<>();
        this.tagFilterOrNone = new HashSet<>();
        this.authorFilterOrNull = null;
        this.sortingType = SortingType.CREATED_DESC;
    }

    // addPost : boolean으로 성공여부까지 확인?
    public void addPost(Post post) {
        this.posts.add(post);
    }

    // setTagFilter : Unset까지 어떻게 감안할건가?
    public void setTagFilter(HashSet<String> tags) {
        this.tagFilterOrNone = tags;
    }

    public void setauthorFilter(User author) {
        this.authorFilterOrNull = author;
    }

    public void setPostOrder(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    // getPostList : PostList 통째로 읽어들이기... 어떻게?
    public ArrayList<Post> getPostList() {
        ArrayList<Post> sexyPostList = new ArrayList<>();
        /*
        새로운 ArrayList 생성

        1. tag 변수가 유효
        2. author 변수가 유효
        3. tag, author 변수 둘 다 유효
        4. tag, author 변수 둘 다 null
        -> 새로운 ArrayList에 작성

        1. 글 목록 정렬 (1~5)
        -> 반환
         */
        return sexyPostList;
    }
}

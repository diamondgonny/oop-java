package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {
    private User master;
    private ArrayList<Post> posts;
    private HashSet<String> tagFilterOrEmpty;
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
        this.tagFilterOrEmpty = new HashSet<>();
        this.authorFilterOrNull = null;
        this.sortingType = SortingType.CREATED_DESC;
    }

    // addPost : boolean으로 성공여부까지 확인?
    public void addPost(Post post) {
        this.posts.add(post);
    }

    // setTagFilter : Unset까지 어떻게 감안할건가?
    public void setTagFilter(HashSet<String> tags) {
        this.tagFilterOrEmpty = tags;
    }

    public void setauthorFilter(User author) {
        this.authorFilterOrNull = author;
    }

    public void setPostOrder(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public ArrayList<Post> getPostList() {
        ArrayList<Post> sexyPostList = new ArrayList<>();
        sexyPostList = doAuthorFilter(this.posts);
        sexyPostList = doTagFilter(sexyPostList);
        sexyPostList = doSorting(sexyPostList);
        return sexyPostList;
    }

    private ArrayList<Post> doAuthorFilter(ArrayList<Post> thePostList) {
        ArrayList<Post> filteredPostList = new ArrayList<>();
        if (this.authorFilterOrNull != null) {
            for (Post post : thePostList) {
                // User 판별 문제, equals 문제
                if (post.getAuthor() == authorFilterOrNull) {
                    filteredPostList.add(post);
                }
            }
        } else {
            filteredPostList = thePostList;
        }
        return filteredPostList;
    }

    // 무엇을 호출? 어떻게 손질? 무엇을 반환?
    private ArrayList<Post> doTagFilter(ArrayList<Post> thePostList) {
        ArrayList<Post> filteredPostList = new ArrayList<>();
        if (!tagFilterOrEmpty.isEmpty()) {
            for (Post post : thePostList) {
                // 조건이 들어맞으면, filteredList에 add하라
            }
        } else {
            filteredPostList = thePostList;
        }
        return filteredPostList;
    }

    private ArrayList<Post> doSorting(ArrayList<Post> thePostList) {
        switch (sortingType) {
            case SortingType.CREATED_DESC:
                Collections.reverse(thePostList.getCreatedDateTime());
            case SortingType.CREATED_ASC:
                Collections.sort(thePostList.getCreatedDateTime());
            case SortingType.MODIFIED_DESC:
            case SortingType.MODIFIED_ASC:
            case SortingType.ABC_ASC:
            default:
                assert (false) : "Unknown case SortingType. in 'doSorting' method";
                break;
        }
        return thePostList;
    }

}

package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {
    private String userId;
    private ArrayList<Post> posts;
    private HashSet<String> tagFilterOrEmpty;
    private String authorFilterOrNull;
    private SortingType sortingType;

    public Blog(String userId) {
        this.userId = userId;
        this.posts = new ArrayList<>();
        this.tagFilterOrEmpty = new HashSet<>();
        this.authorFilterOrNull = null;
        this.sortingType = SortingType.CREATED_DESC;
    }

    // setTagFilter (네이밍으로 unset까지 힌트주기)
    public void setTagFilter(HashSet<String> tags) {
        this.tagFilterOrEmpty = tags;
    }

    // setAuthorFilter (")
    public void setAuthorFilter(String userId) {
        this.authorFilterOrNull = userId;
    }

    // setPostOrder
    public void setPostOrder(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    // addPost (void vs boolean)
    public void addPost(Post post) {
        this.posts.add(post);
    }

    // getPostList
    public ArrayList<Post> getPostList() {
        ArrayList<Post> resultPostList = new ArrayList<>();
        resultPostList = doAuthorFilter(this.posts);
        resultPostList = doTagFilter(resultPostList);
        resultPostList = sortPostList(resultPostList);
        return resultPostList;
    }

    private ArrayList<Post> doAuthorFilter(ArrayList<Post> posts) {
        ArrayList<Post> filteredPostList = new ArrayList<>();
        if (this.authorFilterOrNull != null) {
            for (Post post : posts) {
                if (this.authorFilterOrNull.equals(post.getUserId())) {
                    filteredPostList.add(post);
                }
            }
        } else {
            filteredPostList = posts;
        }
        return filteredPostList;
    }

    private ArrayList<Post> doTagFilter(ArrayList<Post> posts) {
        // .contains?
        ArrayList<Post> filteredPostList = new ArrayList<>();
        if (!tagFilterOrEmpty.isEmpty()) {
            for (Post post : posts) {
                for (String tag : this.tagFilterOrEmpty) {
                    if (post.getTags().contains(tag)) {
                        filteredPostList.add(post);
                        break;
                    }
                }
            }
        } else {
            filteredPostList = posts;
        }
        return filteredPostList;
    }

    private ArrayList<Post> sortPostList(ArrayList<Post> posts) {
        // Lambda로 Comparator 작성 && compareTo Comparable?
        // 문자열(s1, s2) -> 기준값.compareTo(비교값);
        switch (this.sortingType) {
            case CREATED_DESC:
                Collections.sort(posts, (s1, s2) -> s2.getCreatedDateTime().compareTo(s1.getCreatedDateTime()));
                break;
            case CREATED_ASC:
                Collections.sort(posts, (s1, s2) -> s1.getCreatedDateTime().compareTo(s2.getCreatedDateTime()));
                break;
            case UPDATED_DESC:
                Collections.sort(posts, (s1, s2) -> s2.getUpdatedDateTime().compareTo(s1.getUpdatedDateTime()));
                break;
            case UPDATED_ASC:
                Collections.sort(posts, (s1, s2) -> s1.getUpdatedDateTime().compareTo(s2.getUpdatedDateTime()));
                break;
            case LEXICAL_ASC:
                Collections.sort(posts, (s1, s2) -> s1.getTitle().compareTo(s2.getTitle()));
                break;
            default:
                assert (false) : "Unknown case SortingType in 'sortPostList' method";
                break;
        }
        return posts;
    }
}

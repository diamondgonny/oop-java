package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {
    private User user;
    private ArrayList<Post> posts;
    private HashSet<String> tagFilterOrEmpty;
    private User authorFilterOrNull;
    private SortingType sortingType;

    private enum SortingType {
        CREATED_DESC,
        CREATED_ASC,
        UPDATED_DESC,
        UPDATED_ASC,
        LEXICAL_ASC
    }

    public Blog(User user) {
        this.user = user;
        this.posts = new ArrayList<>();
        this.tagFilterOrEmpty = new HashSet<>();
        this.authorFilterOrNull = null;
        this.sortingType = SortingType.CREATED_DESC;
    }

    // setTagFilter : Unset까지 어떻게 감안할건가?
    public void setTagFilter(HashSet<String> tags) {
        this.tagFilterOrEmpty = tags;
    }

    public void setAuthorFilter(User author) {
        this.authorFilterOrNull = author;
    }

    public void setPostOrder(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    // addPost : boolean으로 성공여부까지 확인?
    public void addPost(Post post) {
        this.posts.add(post);
    }

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
                if (this.authorFilterOrNull.equals(post.getAuthor())) {
                    filteredPostList.add(post);
                }
            }
        } else {
            filteredPostList = posts;
        }
        return filteredPostList;
    }

    // tagFilter는 어떻게 unset할 것인가? / contains?
    private ArrayList<Post> doTagFilter(ArrayList<Post> posts) {
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

    // Lambda로 Comparator 작성 && compareTo Comparable?
    // 문자열(s1, s2) -> 기준값.compareTo(비교값);
    private ArrayList<Post> sortPostList(ArrayList<Post> posts) {
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

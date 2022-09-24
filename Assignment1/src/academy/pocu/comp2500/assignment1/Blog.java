package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {
    private String userId;
    private ArrayList<Post> posts = new ArrayList<>();
    private HashSet<String> tagFilterOrEmpty = new HashSet<>();
    private String authorFilterOrNull;
    private SortingType sortingType;

    public Blog(String userId) {
        this.userId = userId;
        this.sortingType = SortingType.CREATED_DESC;
    }

    public void setTagFilter(HashSet<String> tags) {
        this.tagFilterOrEmpty = tags;
    }

    public void setAuthorFilter(String userId) {
        this.authorFilterOrNull = userId;
    }

    public void setPostOrder(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public ArrayList<Post> getPostList() {
        ArrayList<Post> resultPostList;
        resultPostList = doAuthorFilter(this.posts);
        resultPostList = doTagFilter(resultPostList);
        resultPostList = sortPostList(resultPostList);
        return resultPostList;
    }

    private ArrayList<Post> doAuthorFilter(ArrayList<Post> posts) {
        ArrayList<Post> filteredPostList = new ArrayList<>();
        if (this.authorFilterOrNull != null) {
            for (Post post : posts) {
                if (post.isUserIdExists(this.authorFilterOrNull) == true) {
                    filteredPostList.add(post);
                }
            }
        } else {
            filteredPostList = posts;
        }
        return filteredPostList;
    }

    private ArrayList<Post> doTagFilter(ArrayList<Post> posts) {
        ArrayList<Post> filteredPostList = new ArrayList<>();
        if (tagFilterOrEmpty.isEmpty() != true) {
            for (Post post : posts) {
                if (post.isTagAtLeastExists(this.tagFilterOrEmpty) == true) {
                    filteredPostList.add(post);
                }
            }
        } else {
            filteredPostList = posts;
        }
        return filteredPostList;
    }

    private ArrayList<Post> sortPostList(ArrayList<Post> posts) {
        switch (this.sortingType) {
            case CREATED_DESC:
                Collections.sort(posts, (s1, s2) -> s2.getCreatedDateTime().compareTo(s1.getCreatedDateTime()));
                // Collections.sort(posts, Comparator.comparing(Post::getCreatedDateTime).reversed());
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

package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Comment {
    private String userId;
    private String text;
    private ArrayList<Comment> subcomments = new ArrayList<>();
    private HashSet<String> upvoters = new HashSet<>();
    private HashSet<String> downvoters = new HashSet<>();

    public Comment(String userId, String text) {
        this.userId = userId;
        this.text = text;
    }

    public boolean setCommentFamily(String userId, String text) {
        if (this.userId.equals(userId) == false) {
            return false;
        }
        this.text = text;
        return true;
    }

    public void addSubcomment(Comment comment) {
        this.subcomments.add(comment);
    }

    public ArrayList<Comment> getSubcommentListWithSort() {
        Collections.sort(this.subcomments, (n1, n2) -> Integer.compare(n2.getVotePoints(), n1.getVotePoints()));
        // Is wrapper class unnecessary here?
        // Duplicated method(addComment in Post)... Any solution without being 'static'?
        return this.subcomments;
    }

    public boolean addUpvote(String userId) {
        if (this.upvoters.add(userId) == true) {
            this.downvoters.remove(userId);
            return true;
        }
        return false;
    }

    public boolean addDownvote(String userId) {
        if (this.downvoters.add(userId) == true) {
            this.upvoters.remove(userId);
            return true;
        }
        return false;
    }

    int getVotePoints() {
        return this.upvoters.size() - this.downvoters.size();
    }
}

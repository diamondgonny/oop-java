package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Comment {
    private String userId;
    private String text;
    private ArrayList<Comment> subcomments;
    private HashSet<String> upvoters;
    private HashSet<String> downvoters;

    public Comment(String userId, String text) {
        this.userId = userId;
        this.text = text;
        this.subcomments = new ArrayList<>();
        this.upvoters = new HashSet<>();
        this.downvoters = new HashSet<>();
    }

    public String getUserId() {
        return this.userId;
    }

    public String getText() {
        return this.text;
    }

    // setCommentFamily
    public boolean setCommentFamily(String userId, String text) {
        if (this.userId.equals(userId) == false) {
            return false;
        }
        this.text = text;
        return true;
    }

    // addSubcomment
    public void addSubcomment(Comment comment) {
        this.subcomments.add(comment);
    }

    // getSubcommentListWithSort
    public ArrayList<Comment> getSubcommentListWithSort() {
        Collections.sort(this.subcomments, (s1, s2) -> s2.countVotePoints() - s1.countVotePoints());
        return this.subcomments;
    }

    public int getUpvoters() {
        return this.upvoters.size();
    }

    public int getDownvoters() {
        return this.downvoters.size();
    }

    // addUpvote
    public boolean addUpvote(String userId) {
        if (upvoters.contains(userId) == true) {
            return false;
        }
        this.downvoters.remove(userId);
        this.upvoters.add(userId);
        return true;
    }

    // addDownvote
    public boolean addDownvote(String userId) {
        if (downvoters.contains(userId) == true) {
            return false;
        }
        this.upvoters.remove(userId);
        this.downvoters.add(userId);
        return true;
    }

    // countVotes
     int countVotePoints() {
        return this.upvoters.size() - this.downvoters.size();
    }
}

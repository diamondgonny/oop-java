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
    public void addSubcomment(Comment subcomment) {
        this.subcomments.add(subcomment);
    }

    // getSubcommentListWithSort
    public ArrayList<Comment> getSubcommentListWithSort() {
        Collections.sort(this.subcomments, (s1, s2) -> s1.countVotePoints() - s2.countVotePoints());
        return this.subcomments;
    }

    // addUpvoter
    public boolean addUpvote(String userId) {
        if (upvoters.contains(userId) == true) {
            return false;
        }
        this.upvoters.add(userId);
        return true;
    }

    // addDownvoter
    public boolean addDownvote(String userId) {
        if (upvoters.contains(userId) == true) {
            return false;
        }
        this.downvoters.add(userId);
        return true;
    }

    // countVotes
    public int countVotePoints() {
        int upvote = this.upvoters.size();
        int downvote = this.downvoters.size();
        return upvote - downvote;
    }
}

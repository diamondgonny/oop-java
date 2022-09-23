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

    // getSubcommentListWithSort (sort 분리시 static wtf)
    public ArrayList<Comment> getSubcommentListWithSort() {
        Collections.sort(this.subcomments, (s1, s2) -> s2.countVotePoints() - s1.countVotePoints());
        return this.subcomments;
    }

    // addUpvote
    public boolean addUpvote(String userId) {
        if (this.upvoters.add(userId) == true) {
            this.downvoters.remove(userId);
            return true;
        }
        return false;
    }

    // addDownvote
    public boolean addDownvote(String userId) {
        if (this.downvoters.add(userId) == true) {
            this.upvoters.remove(userId);
            return true;
        }
        return false;
    }

    int countVotePoints() {
        return this.upvoters.size() - this.downvoters.size();
    }
}

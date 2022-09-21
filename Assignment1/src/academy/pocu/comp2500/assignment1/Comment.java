package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Comment {
    private User author;
    private String text;
    private ArrayList<Comment> subcomments;
    private HashSet<User> upvoters;
    private HashSet<User> downvoters;

    public Comment(User author, String text) {
        this.author = author;
        this.text = text;
        this.subcomments = new ArrayList<>();
        this.upvoters = new HashSet<>();
        this.downvoters = new HashSet<>();
    }

    // setCommentFamily
    public boolean setCommentFamily(User author, String text) {
        if (this.author.equals(author) == false) {
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
    public boolean addUpvoter(User user) {
        if (upvoters.contains(user) == true) {
            return false;
        }
        this.upvoters.add(user);
        return true;
    }

    // addDownvoter
    public boolean addDownvoter(User user) {
        if (upvoters.contains(user) == true) {
            return false;
        }
        this.downvoters.add(user);
        return true;
    }

    // countVotes
    public int countVotePoints() {
        int upvote = this.upvoters.size();
        int downvote = this.downvoters.size();
        return upvote - downvote;
    }
}

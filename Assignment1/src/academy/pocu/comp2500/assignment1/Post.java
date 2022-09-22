package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Post {
    private User author;
    private String title;
    private String body;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime updatedDateTime;
    private HashSet<String> tags;
    private ArrayList<Comment> comments;
    private HashMap<ReactionType, HashSet<User>> reactions;

    private enum ReactionType {
        GREAT,
        SAD,
        ANGRY,
        FUN,
        LOVE
    }

    public Post(User author, String title, String body) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.createdDateTime = OffsetDateTime.now();
        this.updatedDateTime = createdDateTime;
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
        this.reactions = new HashMap<>();
        // *reactions는 HashMap? ArrayList? (User의 고유성)  /  .values, .put(HashMap)
        for (ReactionType reactionType : ReactionType.values()) {
            reactions.put(reactionType, new HashSet<>());
        }
    }

    public User getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public OffsetDateTime getUpdatedDateTime() {
        return this.updatedDateTime;
    }

    public HashSet<String> getTags() {
        return this.tags;
    }

    // setPostTitle(... boolean?)
    public boolean setPostTitle(User author, String title) {
        if (this.author.equals(author) == false) {
            return false;
        }
        this.updatedDateTime = OffsetDateTime.now();
        this.title = title;
        return true;
    }

    // setPostBody(")
    public boolean setPostBody(User author, String body) {
        if (this.author.equals(author) == false) {
            return false;
        }
        this.updatedDateTime = OffsetDateTime.now();
        this.body = body;
        return true;
    }

    // *setPostTag??? setPostTags??? Or...add?
    public boolean setPostTag(User author, String tag) {
        if (this.author.equals(author) == false) {
            return false;
        }
        this.tags.add(tag);
        return true;
    }

    // addComment
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    // getCommentListWithSort : Upvotes - Downvotes 차이에 의한 정렬 req.
    // cf. 얕은 복사 vs 깊은 복사
    public ArrayList<Comment> getCommentListWithSort() {
        Collections.sort(this.comments, (s1, s2) -> s1.countVotePoints() - s2.countVotePoints());
        return this.comments;
    }

    private boolean checkReactionExists(ReactionType reactionType) {
        for (ReactionType reaction : ReactionType.values()) {
            if (reactionType.equals(reaction)) {
                return true;
            }
        }
        return false;
    }

    // addReaction / .get(HashMap?)
    public boolean addReaction(User user, ReactionType reactionType) {
        if (checkReactionExists(reactionType) == false) {
            return false;
        }
        HashSet<User> reactionUsers = this.reactions.get(reactionType);
        if (reactionUsers.contains(user) == true) {
            return false;
        }
        reactionUsers.add(user);
        return true;
    }

    // removeReaction
    public boolean removeReaction(User user, ReactionType reactionType) {
        if (checkReactionExists(reactionType) == false) {
            return false;
        }
        HashSet<User> reactionUsers = this.reactions.get(reactionType);
        if (reactionUsers.contains(user) == false) {
            return false;
        }
        reactionUsers.remove(user);
        return true;
    }
}

package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Post {
    private String userId;
    private String title;
    private String body;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime updatedDateTime;
    private HashSet<String> tags;
    private ArrayList<Comment> comments;
    private HashMap<ReactionType, HashSet<String>> reactions;

    public enum ReactionType {
        GREAT,
        SAD,
        ANGRY,
        FUN,
        LOVE
    }

    public Post(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.createdDateTime = OffsetDateTime.now();
        this.updatedDateTime = createdDateTime;
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
        this.reactions = new HashMap<>();
        // *reactions는 HashMap? ArrayList? (작성자의 고유성) / .values, .put(HashMap)
        for (ReactionType reactionType : ReactionType.values()) {
            reactions.put(reactionType, new HashSet<>());
        }
    }

    public String getUserId() {
        return this.userId;
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

    // setPostTitle(...boolean?)
    public boolean setTitle(String userId, String title) {
        if (this.userId.equals(userId) == false) {
            return false;
        }
        this.updatedDateTime = OffsetDateTime.now();
        this.title = title;
        return true;
    }

    // setPostBody(")
    public boolean setBody(String userId, String body) {
        if (this.userId.equals(userId) == false) {
            return false;
        }
        this.updatedDateTime = OffsetDateTime.now();
        this.body = body;
        return true;
    }

    // *setPostTag??? setPostTags??? Or...add?
    public void addTag(String tag) {
        this.tags.add(tag);
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
    public boolean addReaction(String userId, ReactionType reactionType) {
        if (checkReactionExists(reactionType) == false) {
            return false;
        }
        HashSet<String> reactionUsers = this.reactions.get(reactionType);
        if (reactionUsers.contains(userId) == true) {
            return false;
        }
        reactionUsers.add(userId);
        return true;
    }

    // removeReaction
    public boolean removeReaction(String userId, ReactionType reactionType) {
        if (checkReactionExists(reactionType) == false) {
            return false;
        }
        HashSet<String> reactionUsers = this.reactions.get(reactionType);
        if (reactionUsers.contains(userId) == false) {
            return false;
        }
        reactionUsers.remove(userId);
        return true;
    }
}

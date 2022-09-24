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
    private HashSet<String> tags = new HashSet<>();
    private ArrayList<Comment> comments = new ArrayList<>();
    private HashMap<ReactionType, HashSet<String>> reactions = new HashMap<>();

    public Post(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.createdDateTime = OffsetDateTime.now();
        this.updatedDateTime = createdDateTime;
        for (ReactionType reactionType : ReactionType.values()) {
            this.reactions.put(reactionType, new HashSet<>());
        }
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
    /*
    public String getUserId() {
        return this.userId;
    }

    public HashSet<String> getTags() {
        return this.tags;
    }
    */
    public boolean isUserIdExists(String userId) {
        return this.userId.equals(userId);
    }

    public boolean isTagAtLeastExists(HashSet<String> tags) {
        for (String tag : tags) {
            if (this.tags.contains(tag)) {
                return true;
            }
        }
        return false;
    }

    public int getReactions(ReactionType reactionType) {
        return this.reactions.get(reactionType).size();
    }

    public boolean setTitle(String userId, String title) {
        if (this.userId.equals(userId) == false) {
            return false;
        }
        this.updatedDateTime = OffsetDateTime.now();
        this.title = title;
        return true;
    }

    public boolean setBody(String userId, String body) {
        if (this.userId.equals(userId) == false) {
            return false;
        }
        this.updatedDateTime = OffsetDateTime.now();
        this.body = body;
        return true;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public ArrayList<Comment> getCommentListWithSort() {
        Collections.sort(this.comments, (n1, n2) -> Integer.compare(n2.getVotePoints(), n1.getVotePoints()));
        // Collections.sort(comments, Comparator.comparing(Comment::getVotePoints).reversed());
        return this.comments;
    }

    public boolean addReaction(String userId, ReactionType reactionType) {
        HashSet<String> reactionUsers = this.reactions.get(reactionType);
        return reactionUsers.add(userId);
    }

    public boolean removeReaction(String userId, ReactionType reactionType) {
        HashSet<String> reactionUsers = this.reactions.get(reactionType);
        return reactionUsers.remove(userId);
    }
}

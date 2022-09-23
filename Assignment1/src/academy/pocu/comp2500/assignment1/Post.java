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
    // Hashmap, HashSet, ArrayList 사용에 대한 이해 (key, value)

    public Post(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.createdDateTime = OffsetDateTime.now();
        this.updatedDateTime = createdDateTime;
        for (ReactionType reactionType : ReactionType.values()) {
            reactions.put(reactionType, new HashSet<>());
            // .values(), .put()
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

    public int getReactions(ReactionType reactionType) {
        // 명세서 : 유저명단이 아닌 인원수를 요구함
        return this.reactions.get(reactionType).size();
    }

    // setTitle
    public boolean setTitle(String userId, String title) {
        if (this.userId.equals(userId) == false) {
            return false;
        }
        this.updatedDateTime = OffsetDateTime.now();
        this.title = title;
        return true;
    }

    // setBody
    public boolean setBody(String userId, String body) {
        if (this.userId.equals(userId) == false) {
            return false;
        }
        this.updatedDateTime = OffsetDateTime.now();
        this.body = body;
        return true;
    }

    // addtag (단수 vs 복수)
    public void addTag(String tag) {
        this.tags.add(tag);
    }

    // addComment
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    // getCommentListWithSort (cf. 얕은 복사 vs 깊은 복사?)
    public ArrayList<Comment> getCommentListWithSort() {
        Collections.sort(this.comments, (s1, s2) -> s2.countVotePoints() - s1.countVotePoints());
        return this.comments;
    }

    // addReaction
    public boolean addReaction(String userId, ReactionType reactionType) {
        HashSet<String> reactionUsers = this.reactions.get(reactionType);   // .get
        if (reactionUsers.contains(userId) == true) {
            return false;
        }
        reactionUsers.add(userId);
        return true;
    }

    // removeReaction
    public boolean removeReaction(String userId, ReactionType reactionType) {
        HashSet<String> reactionUsers = this.reactions.get(reactionType);
        if (reactionUsers.contains(userId) == false) {
            return false;
        }
        reactionUsers.remove(userId);
        return true;
    }
}

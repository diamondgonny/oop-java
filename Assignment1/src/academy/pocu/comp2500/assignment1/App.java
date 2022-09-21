package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");
        registry.registerBlogCreator("Blog");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerTagFilterSetter("Blog", "setTagFilter");
        registry.registerAuthorFilterSetter("Blog", "setAuthorFilter");
        registry.registerPostOrderSetter("Blog", "setPostOrder");
        registry.registerPostListGetter("Blog", "getPostList");

        registry.registerPostTitleUpdater("Post", "setPostTitle");
        registry.registerPostBodyUpdater("Post", "setPostBody");
        registry.registerPostTagAdder("Post", "setPostTags");
        registry.registerCommentAdder("Post", "addComment");
        registry.registerCommentListGetter("Post", "getCommentList");
        registry.registerReactionAdder("Post", "addReaction");
        registry.registerReactionRemover("Post", "removeReaction");

        registry.registerCommentUpdater("Comment", "setComment");
        registry.registerSubcommentAdder("Comment", "addSubcomment");
        registry.registerSubcommentUpdater("Comment", "setSubcomment");
        registry.registerSubcommentListGetter("Comment", "getSubcommentList");
        registry.registerCommentUpvoter("Comment", "addUpvoter");
        registry.registerCommentDownvoter("Comment", "addDownvoter");
        registry.registerSubcommentUpvoter("Comment", "addUpvoter");
        registry.registerSubcommentDownvoter("Comment", "addDownvoter");
    }
}

package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.*;

import java.util.ArrayList;
import java.util.HashSet;

import static academy.pocu.comp2500.assignment1.ReactionType.*;
import static academy.pocu.comp2500.assignment1.SortingType.*;

public class Program {
    public static void main(String[] args) {
        String a1 = "a1";
        String a2 = "a2";
        String a3 = "a3";
        String a4 = "a4";
        String a5 = "a5";
        Blog blog = new Blog(a1);
        blog.setPostOrder(LEXICAL_ASC);

        Post p1 = new Post(a1, "p1", "body");
        Post p2 = new Post(a1, "p2", "body");
        Post p3 = new Post(a2, "a3", "body");
        Post p4 = new Post(a2, "a4", "body");
        Post p5 = new Post(a2, "p5", "body");
        Post p6 = new Post(a2, "p6", "body");
        Post p7 = new Post(a2, "p6", "body");

        blog.addPost(p1);
        blog.addPost(p2);
        blog.addPost(p3);
        blog.addPost(p4);
        blog.addPost(p5);
        blog.addPost(p6);
        blog.addPost(p7);

        p1.addTag("t1");
        p1.addTag("t1");
        p1.addTag("t1");
        p1.addTag("t1");

        Comment c1 = new Comment(a1, "a");
        Comment c2 = new Comment(a2, "b");
        Comment c3 = new Comment(a3, "c");
        Comment c4 = new Comment(a4, "d");
        Comment c5 = new Comment(a5, "e");

        Comment d1 = new Comment(a1, "a1");
        Comment d2 = new Comment(a2, "b1");
        Comment d3 = new Comment(a3, "c1");
        Comment d4 = new Comment(a4, "d1");
        Comment d5 = new Comment(a5, "e1");

        // 댓글 달고 읽기
        p1.addComment(c1);
        p1.addComment(c2);
        p1.addComment(c3);
        p1.addComment(c4);
        p1.addComment(c5);

        // 리액션 달기
        p1.addReaction(a1, GREAT);
        p1.addReaction(a2, SAD);
        p1.addReaction(a3, ANGRY);
        p1.addReaction(a4, FUN);
        p1.addReaction(a5, LOVE);

        p2.addReaction(a1, GREAT);
        p2.addReaction(a2, SAD);
        p2.addReaction(a3, SAD);
        p2.addReaction(a4, FUN);
        p2.addReaction(a5, FUN);

        p3.addReaction(a1, GREAT);
        p3.addReaction(a2, GREAT);
        p3.addReaction(a3, LOVE);
        p3.addReaction(a3, LOVE);

        // 대댓글 달기
        c5.addSubcomment(d1);
        c5.addSubcomment(d2);
        c5.addSubcomment(d3);
        c5.addSubcomment(d4);
        c5.addSubcomment(d5);

        // upvote, downvote 달기
        //-3
        d1.addUpvote(a1);
        d1.addDownvote(a2);
        d1.addDownvote(a3);
        d1.addDownvote(a4);
        d1.addUpvote(a5);
        d1.addDownvote(a5);
        //-1
        d2.addUpvote(a1);
        d2.addUpvote(a2);
        d2.addDownvote(a3);
        d2.addDownvote(a4);
        d2.addUpvote(a5);
        d2.addDownvote(a5);
        //3
        d4.addUpvote(a1);
        d4.addUpvote(a2);
        d4.addUpvote(a3);
        d4.addUpvote(a4);
        d4.addUpvote(a5);
        d4.addDownvote(a5);
        //1
        d5.addUpvote(a1);
        d5.addUpvote(a2);
        d5.addUpvote(a3);
        d5.addDownvote(a4);
        d5.addUpvote(a5);
        d5.addDownvote(a5);

        HashSet<String> tags = new HashSet<>();
        ArrayList<Post> res = blog.getPostList();
        tags.add("t1");
        tags.remove("t1");
        blog.setTagFilter(tags);
        for (Post post : res) {
            System.out.print(post.getUserId() + " ");
            System.out.print(post.getTitle() + " ");
            System.out.print(post.getBody() + " ");
            System.out.print(post.getTags() + " ");
            System.out.print(post.getCreatedDateTime() + " ");
            for (ReactionType reactionType : ReactionType.values()) {
                System.out.print(reactionType + ":" + post.getReactions(reactionType) + "  ");
            }
            System.out.println();

            /*
            ArrayList<Comment> comments = post.getCommentListWithSort();
            for (Comment comment : comments) {
                System.out.print("   ㄴ ");
                //System.out.print(comment.getUserId() + " ");
                //System.out.println(comment.getText() + " ");
                ArrayList<Comment> subcomments = comment.getSubcommentListWithSort();
                for (Comment subcomment : subcomments) {
                    System.out.print("       ㄴ ");
                    //System.out.print(subcomment.getUserId() + " ");
                    //System.out.print(subcomment.getText() + " ");
                    //System.out.print(subcomment.getUpvoters() + " ");
                    //System.out.print(subcomment.getDownvoters() + " ");
                    //System.out.println(subcomment.countVotePoints() + " ");
                }
            }
             */
        }
        System.out.println();
    }
}

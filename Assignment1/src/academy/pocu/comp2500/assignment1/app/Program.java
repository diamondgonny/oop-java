package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.*;

import java.util.ArrayList;
import java.util.HashSet;

public class Program {
    public static void main(String[] args) {

        /*
        String a1 = "a1";
        String a2 = "a2";
        Blog blog = new Blog(a1);

        Post p1 = new Post(a1, "p1", "body");
        Post p2 = new Post(a1, "p2", "body");
        Post p3 = new Post(a2, "p3", "body");
        blog.addPost(p1);
        blog.addPost(p2);
        blog.addPost(p3);

        p1.addTag("t1");
        p2.addTag("t2");
        p3.addTag("t1");
        p3.addTag("t2");

        HashSet<String> tags = new HashSet<>();
        ArrayList<Post> res;
        tags.add("t1");
        blog.setTagFilter(tags);
        res = blog.getPostList();
        for (Post post : res) {
            System.out.print(post.getTitle() + " ");
        }
        System.out.println();

        tags.remove("t1");
        tags.add("t2");
        blog.setTagFilter(tags);
        res = blog.getPostList();
        for (Post post : res) {
            System.out.print(post.getTitle() + " ");
        }
        System.out.println();

        tags.remove("t2");
        tags.add("t1");
        tags.add("t2");
        blog.setTagFilter(tags);
        res = blog.getPostList();
        for (Post post : res) {
            System.out.print(post.getTitle() + " ");
        }
        System.out.println();
         */

        String a1 = "a1";
        String a2 = "a2";
        Blog blog = new Blog(a1);

        Post p1 = new Post(a1, "p1", "body");
        Post p2 = new Post(a1, "p2", "body");
        Post p3 = new Post(a2, "p3", "body");
        Post p4 = new Post(a2, "p4", "body");
        blog.addPost(p1);
        blog.addPost(p2);
        blog.addPost(p3);
        blog.addPost(p4);

        p1.addTag("t1");
        p2.addTag("t2");
        p3.addTag("t1");
        p3.addTag("t2");

        HashSet<String> tags = new HashSet<>();
        ArrayList<Post> res;
        tags.add("t1");
        blog.setTagFilter(tags);
        res = blog.getPostList();
        for (Post post : res) {
            System.out.print(post.getTitle() + " ");
        }
        System.out.println();

        tags.remove("t1");
        blog.setTagFilter(tags);
        blog.setAuthorFilter(a1);
        res = blog.getPostList();
        for (Post post : res) {
            System.out.print(post.getTitle() + " ");
        }
        System.out.println();

        blog.setAuthorFilter(null);
        tags.add("t1");
        blog.setAuthorFilter(a2);
        res = blog.getPostList();
        for (Post post : res) {
            System.out.print(post.getTitle() + " ");
        }
        System.out.println();

        tags.remove("t1");
        blog.setAuthorFilter(null);
        tags.add("t2");
        blog.setAuthorFilter(a1);
        res = blog.getPostList();
        for (Post post : res) {
            System.out.print(post.getTitle() + " ");
        }
        System.out.println();

    }
}

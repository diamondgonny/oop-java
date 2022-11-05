package academy.pocu.comp2500.lab7;

import java.util.Objects;

public class Book {
    private final String title;
    private final Author author;
    private final int publishedYear;
    private final Genre genre;

    public Book(String title, Author author, int publishedYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", title, author);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Book) || this.hashCode() != ((Book) obj).hashCode()) {
            return false;
        }
        Book book = (Book) obj;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) &&
                publishedYear == book.publishedYear && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publishedYear, genre);
    }
}

package academy.pocu.comp2500.lab7;

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
        return String.format("%s [%s]", this.title, this.author.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book) || this.hashCode() != obj.hashCode()) {
            return false;
        }
        Book that = (Book) obj;
        return this.title.equals(that.title) && this.author.equals(that.author) &&
                this.publishedYear == that.publishedYear && this.genre == that.genre;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + publishedYear;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}

package academy.pocu.comp2500.lab7;

import java.util.LinkedList;
import java.util.Objects;

public class Bookshelf {
    private int maxBookAmount;
    private LinkedList<Book> bookShelf = new LinkedList<>();

    public Bookshelf(int maxBookAmount) {
        this.maxBookAmount = maxBookAmount;
    }

    public boolean add(Book book) {
        if (bookShelf.size() >= maxBookAmount) {
            return false;
        }
        return bookShelf.add(book);
    }

    public boolean remove(Book book) {
        return bookShelf.remove(book);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Bookshelf)) {
            return false;
        }
        Bookshelf bookshelf = (Bookshelf) obj;
        return Objects.equals(this.bookShelf, bookshelf.bookShelf);
    }
}

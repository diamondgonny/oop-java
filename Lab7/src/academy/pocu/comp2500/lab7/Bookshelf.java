package academy.pocu.comp2500.lab7;

import java.util.LinkedList;

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
        if (obj == null || !(obj instanceof Bookshelf) || this.hashCode() != ((Bookshelf) obj).hashCode()) {
            return false;
        }
        Bookshelf that = (Bookshelf) obj;
        return this.bookShelf.equals(that.bookShelf);
    }

    @Override
    public int hashCode() {
        return bookShelf != null ? bookShelf.hashCode() : 0;
    }
}

package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public final class Cart {
    private ArrayList<Book> books = new ArrayList<>();

    public Book getBookOrNull(final int index) {
        if (this.books.size() <= index) {
            return null;
        }
        return this.books.get(index);
    }

    public int getBookCount() {
        return this.books.size();
    }

    public void addBooks(final ArrayList<Book> books) {
        for (Book book : books) {
            this.books.add(book);
        }
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public boolean remove(final int index) {
        if (this.books.size() <= index) {
            return false;
        }
        this.books.remove(index);
        return true;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Book book : this.books) {
            sum += book.getPrice();
        }
        return sum;
    }

    public int getTotalPrice(final ITotalPriceable iTotalPriceable) {
        return iTotalPriceable.getTotalPrice(this.books);
    }
}

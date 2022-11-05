package academy.pocu.comp2500.lab7;

import java.util.HashSet;

public class Bundle {
    private final String name;
    private final int MAX_BOOK_AMOUNT;
    private final HashSet<Book> bundle = new HashSet<>();

    public Bundle(String name) {
        this.name = name;
        this.MAX_BOOK_AMOUNT = 4;
    }

    public boolean add(Book book) {
        if (bundle.size() >= MAX_BOOK_AMOUNT) {
            return false;
        }
        return bundle.add(book);
    }

    public boolean remove(Book book) {
        return bundle.remove(book);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bundle) || this.hashCode() != obj.hashCode()) {
            return false;
        }
        Bundle that = (Bundle) obj;
        for (Book book : this.bundle) {
            if (!that.bundle.contains(book)) {
                return false;
            }
        }
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        for (Book book : this.bundle) {
            result = 31 * result + book.hashCode();
        }
        return result;
    }
}

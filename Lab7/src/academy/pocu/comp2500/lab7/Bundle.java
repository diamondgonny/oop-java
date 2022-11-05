package academy.pocu.comp2500.lab7;

import java.util.HashSet;
import java.util.Objects;

public class Bundle {
    private String name;
    private final int MAX_BOOK_AMOUNT;
    private HashSet<Book> bundle = new HashSet<>();

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
        if (obj == null || !(obj instanceof Bundle) || this.hashCode() != ((Bundle) obj).hashCode()) {
            return false;
        }
        Bundle bundle = (Bundle) obj;
        return Objects.equals(this.name, bundle.name) && Objects.equals(this.bundle, bundle.bundle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bundle);
    }
}

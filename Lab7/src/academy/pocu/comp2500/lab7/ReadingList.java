package academy.pocu.comp2500.lab7;

import java.util.LinkedList;
import java.util.Objects;

public class ReadingList {
    private String name;
    private LinkedList<Book> readingList = new LinkedList<>();

    public ReadingList(String name) {
        this.name = name;
    }

    public void add(Book book) {
        readingList.add(book);
    }

    public boolean remove(Book book) {
        return readingList.remove(book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (Book book : readingList) {
            ++num;
            sb.append(String.format("%d. %s\n", num, book.toString()));
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ReadingList) || this.hashCode() != (((ReadingList) obj).hashCode())) {
            return false;
        }
        ReadingList that = (ReadingList) obj;
        return Objects.equals(this.name, that.name) && Objects.equals(this.toString(), that.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, toString());
    }
}

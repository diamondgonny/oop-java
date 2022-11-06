package academy.pocu.comp2500.lab7;

import java.util.LinkedList;

public class ReadingList {
    private final String name;
    private final LinkedList<Book> readingList = new LinkedList<>();

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
            if (num != 0) {
                sb.append(String.format("\n"));
            }
            ++num;
            sb.append(String.format("%d. %s", num, book.toString()));
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReadingList) ||
                this.hashCode() != (obj.hashCode())) {
            return false;
        }
        ReadingList that = (ReadingList) obj;
        return this.name.equals(that.name) && this.toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (toString() != null ? toString().hashCode() : 0);
        return result;
    }
}

package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public class SkyIsTheLimit implements ITotalPriceable {
    private final int price;

    public SkyIsTheLimit(final int price) {
        this.price = price;
    }

    public int getTotalPrice(final ArrayList<Book> books) {
        double sum = 0;
        double dcBook1 = 0;
        double dcBook2 = 0;

        for (Book book : books) {
            sum += book.getPrice();
            if (book.getPrice() >= dcBook1) {
                dcBook2 = dcBook1;
                dcBook1 = book.getPrice();
            } else if (book.getPrice() >= dcBook2) {
                dcBook2 = book.getPrice();
            }
        }
        if (sum >= price && books.size() >= 5) {
            sum = sum - (dcBook1 + dcBook2) + 0.5 * (dcBook1 + dcBook2);
        }

        return (int) sum;
    }
}

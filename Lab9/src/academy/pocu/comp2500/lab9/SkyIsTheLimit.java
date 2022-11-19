package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public class SkyIsTheLimit {
    private final int limit;

    public SkyIsTheLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPrice(ArrayList<Book> books) {
        int sum = 0;
        for (Book book : books) {
            sum += book.getPrice();
        }
        if (sum < limit) {
            return sum;
        }
        return sum - calculateDiscount(books);
    }

    private int calculateDiscount(ArrayList<Book> books) {
        int discountableBook1 = 0;
        int discountableBook2 = 0;
        for (Book book : books) {
            if (book.getPrice() >= discountableBook1) {
                discountableBook2 = discountableBook1;
                discountableBook1 = book.getPrice();
            }
        }
        return (int) 0.5 * (discountableBook1 + discountableBook2);
    }
}

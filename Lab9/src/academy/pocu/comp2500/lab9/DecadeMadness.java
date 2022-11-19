package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashSet;

public class DecadeMadness {

    public int getTotalPrice(ArrayList<Book> books) {
        int sum = 0;
        for (Book book : books) {
            sum += book.getPrice();
        }
        return sum - calculateDiscount(books);
    }

    private int calculateDiscount(ArrayList<Book> books) {
        int discount = 0;
        HashSet<Integer> decadeTotalSet = new HashSet<>();
        HashSet<Integer> decadeDiscountSet = new HashSet<>();
        for (Book book : books) {
            int bookPublishedDecade = (book.getPublishedYear() / 10) * 10;
            if (!decadeTotalSet.contains(bookPublishedDecade)) {
                decadeTotalSet.add(bookPublishedDecade);
            } else {
                decadeDiscountSet.add(bookPublishedDecade);
            }
        }
        for (Book book : books) {
            int bookPublishedDecade = (book.getPublishedYear() / 10) * 10;
            for (int decade : decadeDiscountSet) {
                if (decade == bookPublishedDecade) {
                    discount += 0.2 * book.getPrice();
                    break;
                }
            }
        }
        return discount;
    }
}

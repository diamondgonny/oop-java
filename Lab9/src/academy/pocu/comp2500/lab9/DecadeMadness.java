package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashSet;

public class DecadeMadness implements ITotalPriceable {

    public int getTotalPrice(final ArrayList<Book> books) {
        int nonDiscountSum = 0;
        int discountSum = 0;
        HashSet<Integer> decadeTotalSet = new HashSet<>();
        HashSet<Integer> decadeDiscountSet = new HashSet<>();

        for (Book book : books) {
            nonDiscountSum += book.getPrice();
            if (!decadeTotalSet.contains((book.getPublishedYear() / 10) * 10)) {
                decadeTotalSet.add((book.getPublishedYear() / 10) * 10);
            } else {
                decadeDiscountSet.add((book.getPublishedYear() / 10) * 10);
            }
        }

        for (int decade : decadeDiscountSet) {
            double discountTargets = 0;
            for (Book book : books) {
                // 이 책은 할인 대상인가?
                if (decade == ((book.getPublishedYear() / 10) * 10)) {
                    nonDiscountSum -= book.getPrice();
                    discountTargets += book.getPrice();
                }
            }
            discountSum += (int) (0.8 * discountTargets);
        }

        return nonDiscountSum + discountSum;
    }
}

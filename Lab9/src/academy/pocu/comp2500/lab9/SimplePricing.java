package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public class SimplePricing implements ITotalPriceable {

    @Override
    public int getTotalPrice(final ArrayList<Book> books) {
        int sum = 0;
        for (Book book : books) {
            sum += book.getPrice();
        }
        return sum;
    }
}

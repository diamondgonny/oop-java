package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class BuyOneGetOneFree implements ITotalPriceable {
    private final HashSet<UUID> skus;

    public BuyOneGetOneFree(final HashSet<UUID> skus) {
        this.skus = skus;
    }

    public int getTotalPrice(final ArrayList<Book> books) {
        int sum = 0;
        int discount = 0;

        for (Book book : books) {
            sum += book.getPrice();
        }
        for (UUID sku : skus) {
            int skuBookAmount = 0;
            for (Book book : books) {
                if (book.getSku().equals(sku)) {
                    ++skuBookAmount;
                }
                if (skuBookAmount % 2 == 0) {
                    discount += book.getPrice();
                }
            }
        }

        return sum - discount;
    }
}

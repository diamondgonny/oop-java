package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public void checkShippingMethod(Product product, ShippingMethod shippingMethod) {
        for (Product item : items) {
            if (item.equals(product)) {
                item.setShippingMethod(shippingMethod);
            }
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }
}

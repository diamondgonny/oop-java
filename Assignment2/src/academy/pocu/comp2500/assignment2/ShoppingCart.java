package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Product> itemList;

    public ShoppingCart() {
        this.itemList = new ArrayList<>();
    }

    public ArrayList<Product> getItemList() {
        return itemList;
    }

    public void addItem(Product product) {
        itemList.add(product);
    }

    public void removeItem(Product product) {
        itemList.remove(product);
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product item : itemList) {
            total += item.getPrice();
        }
        return total;
    }

    public void selectShippingMethod(Product product, ShippingMethod shippingMethod) {
        for (Product item : itemList) {
            if (product.equals(item)) {
                product.setShippingMethod(shippingMethod);
            }
        }
    }
}

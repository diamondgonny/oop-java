package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> itemList;

    public ShoppingCart() {
        this.itemList = new ArrayList<>();
    }

    public ArrayList<Product> getItemList() {
        return itemList;
    }

    public void addItem(Product productId) {
        itemList.add(productId);
    }

    public void removeItem(Product productId) {
        itemList.remove(productId);
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product item : itemList) {
            total += item.getPrice();
        }
        return total;
    }

    public void selectShippingMethod(Product productId, ShippingMethod shippingMethod) {
        for (Product item : itemList) {
            if (productId.equals(item)) {
                productId.setShippingMethod(shippingMethod);
            }
        }
    }
}

package academy.pocu.comp2500.assignment2;

import java.util.LinkedHashMap;

public class ShoppingCart {
    private final LinkedHashMap<Integer, Product> itemList;

    public ShoppingCart() {
        this.itemList = new LinkedHashMap<>();
    }

    public LinkedHashMap<Integer, Product> getItemList() {
        return itemList;
    }

    public void addItem(Product product) {
        itemList.put(product.getProductId(), product);
    }

    public void removeItem(int productId) {
        itemList.remove(productId);
    }

    public int getTotalPrice() {
        int total = 0;
        for (int itemId : itemList.keySet()) {
            total += itemList.get(itemId).getPrice();
        }
        return total;
    }

    public void selectShippingMethod(int productId, ShippingMethod shippingMethod) {
        for (int itemId : itemList.keySet()) {
            if (productId == itemId) {
                itemList.get(productId).setShippingMethod(shippingMethod);
            }
        }
    }
}

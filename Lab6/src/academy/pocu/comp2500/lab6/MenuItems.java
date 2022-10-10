package academy.pocu.comp2500.lab6;

public class MenuItems {
    private final int price;
    private boolean isValid;

    protected MenuItems(final int price) {
        this.price = price;
        this.isValid = false;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }
}

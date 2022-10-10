package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends MenuItems {
    private ArrayList<Topping> toppings;

    protected Pizza(final int price) {
        super(price);
        this.toppings = new ArrayList<>();
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }
}

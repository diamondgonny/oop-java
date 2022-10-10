package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends MenuItems {
    protected ArrayList<Topping> toppings;

    public Pizza(int price) {
        super(price);
        this.toppings = new ArrayList<>();
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }
}

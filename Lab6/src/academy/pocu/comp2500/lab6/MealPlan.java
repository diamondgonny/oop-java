package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class MealPlan extends MenuItems {
    protected ArrayList<Appetizer> appetizers;
    protected MainCourse mainCourse;
    protected ArrayList<Dessert> desserts;

    protected MealPlan(int price) {
        super(price);
        this.appetizers = new ArrayList<>();
        this.desserts = new ArrayList<>();
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public MainCourse getMainCourse() {
        return this.mainCourse;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
}

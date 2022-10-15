package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class MealPlan extends MenuItems {
    protected ArrayList<Appetizer> appetizers;
    protected ArrayList<MainCourse> mainCourses;
    protected ArrayList<Dessert> desserts;

    protected MealPlan(int price) {
        super(price);
        this.appetizers = new ArrayList<>();
        this.mainCourses = new ArrayList<>();
        this.desserts = new ArrayList<>();
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return this.mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
}

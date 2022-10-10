package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class MealPlan extends MenuItems {
    private ArrayList<Appetizer> appetizers;
    private ArrayList<MainCourse> mainCourses;
    private ArrayList<Dessert> desserts;

    protected MealPlan(int price) {
        super(price);
        this.appetizers = new ArrayList<>();
        this.mainCourses = new ArrayList<>();
        this.desserts = new ArrayList<>();
    }

    public ArrayList<Appetizer> getAppetizers() {
        assert (this.appetizers != null) : "call isValid() first!";
        return this.appetizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        assert (this.mainCourses != null) : "call isValid() first!";
        return this.mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        assert (this.desserts != null) : "call isValid() first!";
        return this.desserts;
    }
}

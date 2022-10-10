package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends MealPlan {
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizers.clear();
        this.appetizers.add(appetizer);
        this.isValidMenu();
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourses.clear();
        this.mainCourses.add(mainCourse);
        this.isValidMenu();
    }

    public void setDessert(Dessert dessert) {
        this.desserts.clear();
        this.desserts.add(dessert);
        this.isValidMenu();
    }

    private boolean isValidMenu() {
        boolean isValid = this.appetizers.size() == 1
                && this.mainCourses.size() == 1
                && this.desserts.size() == 1;
        return isValid;
    }
}

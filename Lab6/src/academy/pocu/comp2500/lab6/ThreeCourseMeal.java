package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends MealPlan {
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    public void setAppetizer(Appetizer appetizer) {
        this.getAppetizers().clear();
        this.getAppetizers().add(appetizer);
        this.isValidMenu();
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
        this.isValidMenu();
    }

    public void setDessert(Dessert dessert) {
        this.getDesserts().clear();
        this.getDesserts().add(dessert);
        this.isValidMenu();
    }

    private void isValidMenu() {
        boolean isValid = this.getAppetizers().size() == 1
                && this.getMainCourse() != null
                && this.getDesserts().size() == 1;
        setValid(isValid);
    }
}

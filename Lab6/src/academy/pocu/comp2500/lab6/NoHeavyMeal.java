package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends MealPlan {
    private static final int PRICE = 15;

    public NoHeavyMeal() {
        super(PRICE);
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.getAppetizers().clear();
        this.getAppetizers().add(appetizer1);
        this.getAppetizers().add(appetizer2);
        this.isValidMenu();
    }

    public void setDessert(Dessert dessert) {
        this.getDesserts().clear();
        this.getDesserts().add(dessert);
        this.isValidMenu();
    }

    private void isValidMenu() {
        boolean isValid = this.getAppetizers().size() == 2 && this.getDesserts().size() == 1;
        setValid(isValid);
    }
}

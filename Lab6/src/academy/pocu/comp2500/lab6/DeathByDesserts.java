package academy.pocu.comp2500.lab6;

public class DeathByDesserts extends MealPlan {
    private static final int PRICE = 20;

    public DeathByDesserts() {
        super(PRICE);
    }

    public void setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3, Dessert dessert4) {
        this.getDesserts().clear();
        this.getDesserts().add(dessert1);
        this.getDesserts().add(dessert2);
        this.getDesserts().add(dessert3);
        this.getDesserts().add(dessert4);
        this.isValidMenu();
    }

    private void isValidMenu() {
        boolean isValid = this.getDesserts().size() == 4;
        setValid(isValid);
    }
}

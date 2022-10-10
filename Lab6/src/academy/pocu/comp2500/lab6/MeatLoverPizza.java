package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    private static final int PRICE = 21;
    private boolean isVeggieAdded;

    public MeatLoverPizza() {
        super(PRICE);
        this.toppings.add(Topping.BACON);
        this.toppings.add(Topping.PEPERONI);
        this.toppings.add(Topping.HAM);
        this.toppings.add(Topping.SAUSAGES);
        this.toppings.add(Topping.CHEDDAR_CHEESE);
    }

    public boolean addBlackOlives() {
        if (isValid()) {
            return false;
        }
        this.toppings.add(Topping.BLACK_OLIVES);
        this.isVeggieAdded = true;
        this.isValidMenu();
        return true;
    }

    public boolean removeBlackOlives() {
        boolean isRemoved = this.toppings.remove(Topping.BLACK_OLIVES);
        if (isRemoved) {
            this.isVeggieAdded = false;
        }
        this.isValidMenu();
        return isRemoved;
    }

    public boolean addRedOnions() {
        if (isValid()) {
            return false;
        }
        this.toppings.add(Topping.RED_ONIONS);
        this.isVeggieAdded = true;
        this.isValidMenu();
        return true;
    }

    public boolean removeRedOnions() {
        boolean isRemoved = this.toppings.remove(Topping.RED_ONIONS);
        if (isRemoved) {
            this.isVeggieAdded = false;
        }
        this.isValidMenu();
        return isRemoved;
    }

    public boolean addGreenPeppers() {
        if (isValid()) {
            return false;
        }
        this.toppings.add(Topping.GREEN_PEPPERS);
        this.isVeggieAdded = true;
        this.isValidMenu();
        return true;
    }

    public boolean removeGreenPeppers() {
        boolean isRemoved = this.toppings.remove(Topping.GREEN_PEPPERS);
        if (isRemoved) {
            this.isVeggieAdded = false;
        }
        this.isValidMenu();
        return isRemoved;
    }

    private void isValidMenu() {
        boolean isValid = this.isVeggieAdded;
        setValid(isValid);
    }
}

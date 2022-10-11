package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {
    private static final int PRICE = 17;
    private static final int MAX_CHEESE_COUNT = 2;

    private int cheeseCount;

    public VeggiePizza() {
        super(PRICE);
        this.getToppings().add(Topping.BLACK_OLIVES);
        this.getToppings().add(Topping.RED_ONIONS);
        this.getToppings().add(Topping.GREEN_PEPPERS);
    }

    public boolean addMozzarellaCheese() {
        if (isValid()) {
            return false;
        }
        this.getToppings().add(Topping.MOZZARELLA_CHEESE);
        ++this.cheeseCount;
        this.isValidMenu();
        return true;
    }

    public boolean removeMozzarellaCheese() {
        boolean isRemoved = this.getToppings().remove(Topping.MOZZARELLA_CHEESE);
        if (isRemoved) {
            --this.cheeseCount;
        }
        this.isValidMenu();
        return isRemoved;
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }
        this.getToppings().add(Topping.CHEDDAR_CHEESE);
        ++this.cheeseCount;
        this.isValidMenu();
        return true;
    }

    public boolean removeCheddarCheese() {
        boolean isRemoved = this.getToppings().remove(Topping.CHEDDAR_CHEESE);
        if (isRemoved) {
            --this.cheeseCount;
        }
        this.isValidMenu();
        return isRemoved;
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }
        this.getToppings().add(Topping.FETA_CHEESE);
        ++this.cheeseCount;
        this.isValidMenu();
        return true;
    }

    public boolean removeFetaCheese() {
        boolean isRemoved = this.getToppings().remove(Topping.FETA_CHEESE);
        if (isRemoved) {
            --this.cheeseCount;
        }
        this.isValidMenu();
        return isRemoved;
    }

    private void isValidMenu() {
        boolean isValid = this.cheeseCount == MAX_CHEESE_COUNT;
        setValid(isValid);
    }
}

package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    private static final int PRICE = 20;
    private static final int MAX_MEAT_COUNT = 2;
    private int meatCount;

    public HousePizza() {
        super(PRICE);
        this.getToppings().add(Topping.BLACK_OLIVES);
        this.getToppings().add(Topping.RED_ONIONS);
        this.getToppings().add(Topping.GREEN_PEPPERS);
        this.getToppings().add(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }
        this.getToppings().add(Topping.BACON);
        ++this.meatCount;
        this.isValidMenu();
        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = this.getToppings().remove(Topping.BACON);
        if (isRemoved) {
            --this.meatCount;
        }
        this.isValidMenu();
        return isRemoved;
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }
        this.getToppings().add(Topping.PEPERONI);
        ++this.meatCount;
        this.isValidMenu();
        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = this.getToppings().remove(Topping.PEPERONI);
        if (isRemoved) {
            --this.meatCount;
        }
        this.isValidMenu();
        return isRemoved;
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }
        this.getToppings().add(Topping.SAUSAGES);
        ++this.meatCount;
        this.isValidMenu();
        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = this.getToppings().remove(Topping.SAUSAGES);

        if (isRemoved) {
            --this.meatCount;
        }
        this.isValidMenu();
        return isRemoved;
    }

    private void isValidMenu() {
        boolean isValid = this.meatCount == MAX_MEAT_COUNT;
        setValid(isValid);
    }
}

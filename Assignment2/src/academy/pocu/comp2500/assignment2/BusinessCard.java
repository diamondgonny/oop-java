package academy.pocu.comp2500.assignment2;

public class BusinessCard extends CustomizableProduct {
    private BusinessCardType type;
    private BusinessCardSides sides;

    public BusinessCard(BusinessCardType type, BusinessCardColor color, BusinessCardSides sides,
                        Orientation orientation, ShippingMethod shippingMethod) {
        super(new Size(90, 50), color.getColor(), orientation, shippingMethod);
        String name = String.format("%s Business Card", type.getType());
        super.setName(name);

        int price = 0;
        switch (type) {
            case LINEN:
                price = 140;
                break;
            case LAID:
                price = 150;
                break;
            case SMOOTH:
                price = 130;
                break;
            default:
                assert (false) : "unknown type";
                break;
        }
        if (sides == BusinessCardSides.SINGLE) {
            price -= 30;
        }
        super.setPrice(price);

        this.type = type;
        this.sides = sides;
    }

    public BusinessCardType getType() {
        return type;
    }

    public BusinessCardSides getSides() {
        return sides;
    }
}

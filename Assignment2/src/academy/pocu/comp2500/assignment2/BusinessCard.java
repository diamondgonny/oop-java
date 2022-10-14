package academy.pocu.comp2500.assignment2;

public class BusinessCard extends CustomizableProduct {
    private final BusinessCardType type;
    private final BusinessCardSides sides;

    public BusinessCard(BusinessCardType type, BusinessCardColor color, BusinessCardSides sides,
                        Orientation orientation, ShippingMethod shippingMethod) {
        super(orientation, shippingMethod);

        String businessCardType = null;
        Color businessCardColor = null;
        int businessCardPrice = 0;

        if (type == BusinessCardType.LINEN) {
            businessCardType = "Linen";
            businessCardPrice = 140;
        } else if (type == BusinessCardType.LAID) {
            businessCardType = "Laid";
            businessCardPrice = 150;
        } else if (type == BusinessCardType.SMOOTH) {
            businessCardType = "Smooth";
            businessCardPrice = 130;
        } else {
            assert (false) : "unknown type";
        }

        if (sides == BusinessCardSides.SINGLE) {
            businessCardPrice -= 30;
        }

        if (color == BusinessCardColor.GRAY) {
            businessCardColor = new Color(0xe6, 0xe6, 0xe6);
        } else if (color == BusinessCardColor.IVORY) {
            businessCardColor = new Color(0xff, 0xff, 0xf0);
        } else if (color == BusinessCardColor.WHITE) {
            businessCardColor = new Color(0xff, 0xff, 0xff);
        } else {
            assert (false) : "unknown color";
        }

        super.name = String.format("%s Business Card", businessCardType);
        super.size = new Size(90, 50);
        super.color = businessCardColor;
        super.price = businessCardPrice;
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

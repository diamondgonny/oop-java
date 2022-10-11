package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductAperture {
    private BusinessCardType type;
    private BusinessCardSides sides;

    // Aperture?
    public BusinessCard(BusinessCardType type, Size size, BusinessCardColor color,
                  BusinessCardSides sides, Orientation orientation, Shipment shipment) {
        super("BusinessCard", new Size(90, 50), color.getColor(), orientation, shipment);

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
}

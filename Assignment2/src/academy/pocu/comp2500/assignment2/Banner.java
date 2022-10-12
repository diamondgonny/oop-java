package academy.pocu.comp2500.assignment2;

public class Banner extends ProductAperture {
    private BannerType type;

    // Aperture?
    public Banner(BannerType type, BannerSize size, Color color,
                  Orientation orientation, ShippingMethod shippingMethod) {
        super(size.getSize(), color, orientation, shippingMethod);
        String name = String.format("%s Banner (%d mm x %d mm)", type.getType(),
                size.getSize().getWidth(), size.getSize().getHeight());
        super.setName(name);

        int price = 0;
        switch (size) {
            case W1000H500:
                price = 5100;
                break;
            case W1000H1000:
                price = 5300;
                break;
            case W2000H500:
                price = 5400;
                break;
            case W3000H1000:
                price = 6100;
                break;
            default:
                assert (false) : "unknown type";
                break;
        }
        if (type == BannerType.GLOSS) {
            price -= 100;
        }
        super.setPrice(price);

        this.type = type;
    }

}

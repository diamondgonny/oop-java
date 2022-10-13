package academy.pocu.comp2500.assignment2;

public class Banner extends CustomizableProduct {
    private BannerType type;

    public Banner(BannerType type, BannerSize size, Color color,
                  Orientation orientation, ShippingMethod shippingMethod) {
        super(orientation, shippingMethod);

        String bannerType = null;
        Size bannerSize = null;
        int bannerPrice = 0;

        if (type == BannerType.GLOSS) {
            bannerType = "Gloss";
            bannerPrice -= 100;
        } else if (type == BannerType.SCRIM) {
            bannerType = "Scrim";
        } else if (type == BannerType.MESH) {
            bannerType = "Mesh";
        } else {
            assert (false) : "unknown type";
        }

        if (size == BannerSize.W1000H500) {
            bannerSize = new Size(1000, 500);
            bannerPrice = 5100;
        } else if (size == BannerSize.W1000H1000) {
            bannerSize = new Size(1000, 1000);
            bannerPrice = 5300;
        } else if (size == BannerSize.W2000H500) {
            bannerSize = new Size(2000, 500);
            bannerPrice = 5400;
        } else if (size == BannerSize.W3000H1000) {
            bannerSize = new Size(3000, 1000);
            bannerPrice = 6100;
        } else {
            assert (false) : "unknown size";
        }

        super.setName(String.format("%s Banner (%d mm x %d mm)", bannerType,
                bannerSize.getWidth(), bannerSize.getHeight()));
        super.setSize(bannerSize);
        super.setColor(color);
        super.setPrice(bannerPrice);
        super.setShippingMethod(shippingMethod);
        this.type = type;
    }

    public BannerType getType() {
        return type;
    }
}

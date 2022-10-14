package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class CustomizableProduct extends Product {
    private static final int APERTURE_PRICE = 5;
    private Orientation orientation;
    private final ArrayList<Aperture> apertures;

    protected CustomizableProduct(Orientation orientation, ShippingMethod shippingMethod) {
        super(shippingMethod);
        this.orientation = orientation;
        this.apertures = new ArrayList<>();
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }

    public boolean addAperture(Aperture aperture) {
        if (!isValidAperture(aperture) || apertures.contains(aperture)) {
            return false;
        }
        apertures.add(aperture);
        super.addPrice(APERTURE_PRICE);
        return true;
    }

    protected void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    private boolean isValidAperture(Aperture aperture) {
        int r1w = this.getSize().getWidth();
        int r1h = this.getSize().getHeight();
        int r2x = aperture.getX();
        int r2y = aperture.getY();
        int r2w = aperture.getWidth();
        int r2h = aperture.getHeight();
        return (0 < r2x + r2w && r2x < r1w && 0 < r2y + r2h && r2y < r1h);
    }
}

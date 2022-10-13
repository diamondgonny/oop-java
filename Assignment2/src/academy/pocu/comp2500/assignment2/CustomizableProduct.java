package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class CustomizableProduct extends Product {
    private Orientation orientation;
    private ArrayList<Aperture> apertures;

    protected CustomizableProduct(Size size, Color color, Orientation orientation,
                                  ShippingMethod shippingMethod) {
        super(size, color, shippingMethod);
        this.orientation = orientation;
        this.apertures = new ArrayList<Aperture>();
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }

    public boolean addAperture(Aperture aperture) {
        if (!validateAperture(aperture) || apertures.contains(aperture)) {
            return false;
        }
        apertures.add(aperture);
        super.addPrice(5);
        return true;
    }

    private boolean validateAperture(Aperture aperture) {
        int r1w = this.getSize().getWidth();
        int r1h = this.getSize().getHeight();
        int r2x = aperture.getX();
        int r2y = aperture.getY();
        int r2w = aperture.getWidth();
        int r2h = aperture.getHeight();
        return (0 < r2x + r2w && r2x < r1w && 0 < r2y + r2h && r2y < r1h);
    }
}
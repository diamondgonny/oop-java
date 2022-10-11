package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ProductAperture extends Product {
    private Orientation orientation;
    private ArrayList<Aperture> apertures;

    public ProductAperture(String name, Size size, Color color, Orientation orientation, Shipment shipment) {
        super(name, size, color, shipment);
        this.orientation = orientation;
        this.apertures = new ArrayList<Aperture>();
    }

    // *****************************************
    public void addAperture(Aperture aperture) {
        if (!validateAperture(aperture)) {
            return;
        }
        apertures.add(aperture);
        super.addPrice(5);
        // Aperture (문자, 사진)
    }

    public int countAperture() {
        return apertures.size();
    }

    private boolean validateAperture(Aperture aperture) {
        int r1w = this.getSize().getWidth();
        int r1h = this.getSize().getHeight();
        int r2x = aperture.getX();
        int r2y = aperture.getY();
        int r2w = aperture.getWidth();
        int r2h = aperture.getHeight();
        return (0 > r2x + r2w || r1w < r2x || 0 > r2y + r2h || r1h < r2y);
    }
}
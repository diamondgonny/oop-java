package academy.pocu.comp2500.assignment2;

public enum BannerType {
    GLOSS("Gloss"),
    SCRIM("Scrim"),
    MESH("Mesh");

    private final String type;

    BannerType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

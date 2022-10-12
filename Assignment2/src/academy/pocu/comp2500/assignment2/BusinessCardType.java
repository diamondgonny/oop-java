package academy.pocu.comp2500.assignment2;

public enum BusinessCardType {
    LINEN("Linen"),
    LAID("Laid"),
    SMOOTH("Smooth");

    private final String type;

    BusinessCardType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

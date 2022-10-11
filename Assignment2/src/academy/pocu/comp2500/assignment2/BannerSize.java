package academy.pocu.comp2500.assignment2;

public enum BannerSize {
    W1000H500(new Size(1000, 500)),
    W1000H1000(new Size(1000, 1000)),
    W2000H500(new Size(2000, 500)),
    W3000H1000(new Size(3000, 1000));

    private final Size size;

    private BannerSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }
}

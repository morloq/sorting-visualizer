public enum Constants {
    WIN_WIDTH(1200),
    WIN_HEIGHT(800),
    ELEMENTS(1200),
    RANGE(WIN_HEIGHT.getValue()-100);

    public final int value;

    private Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
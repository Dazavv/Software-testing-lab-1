package task3;

public enum ShipState {
    STABLE("спокойно"),
    SHAKING("трясет");
    private final String state;

    ShipState(String state) {
        this.state = state;
    }
}

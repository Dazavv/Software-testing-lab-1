package task3;

public enum Direction {
    FORWARD("вперед"),
    ALL_DIRECTIONS("во всех направлениях"),
    TOWARD_ROCKETS("навстречу ракетам");

    private final String description;

    Direction(String description) {
        this.description = description;
    }
}

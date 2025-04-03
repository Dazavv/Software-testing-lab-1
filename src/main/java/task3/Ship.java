package task3;

public class Ship {
    private final String name;
    private String status;
    private Engine engine;
    private Direction direction;

    public Ship() {
        name = null;
    }
    void changeDirection(Direction newDirection) {
        this.direction = newDirection;
    }
    void shake() {
        status = "затрясло";
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

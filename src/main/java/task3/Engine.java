package task3;

public class Engine {
    private final String name;
    private final String type;
    private Boolean status;

    public Engine(String name) {
        this.name = name;
        this.type = "двигатель корабля";
        this.status = false;
    }
    void activate() {
        status = true;
    }
    void deactivate() {
        status = false;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Boolean getStatus() {
        return status;
    }
}

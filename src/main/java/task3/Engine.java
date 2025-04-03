package task3;

public class Engine {
    private final String name;
    private final String type;
    private String status;

    public Engine(String name, String type, String status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }
    void activate() {
        status = "работает";
    }
    void deactivate() {
        status = "не работает";
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

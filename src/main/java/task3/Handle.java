package task3;

public class Handle {
    private final String name;
    private final String function;
    private boolean isActive;

    public Handle(String name, String function) {
        this.name = name;
        this.function = function;
        this.isActive = false;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

}

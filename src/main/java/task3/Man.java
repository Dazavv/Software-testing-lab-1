package task3;

import java.util.List;

public class Man {
    private final String name;
    private String position;
    private Ship ship;

    public Man(String name, Ship ship) {
        this.name = name;
        this.position = "на корабле";
        this.ship = ship;
    }

    void grabHandle(Handle handle) {
        if (ship.addHandleToActiveHandles(handle)) {
            System.out.println("рукоятка " + handle.getName() + " поднята");
        } else {
            System.err.println("рукоятка " + handle.getName() + "не может быть поднята/уже поднята");
        }
    }
    void releaseHandle(Handle handle) {
        if (ship.removeHandleFromActiveHandles(handle)) {
            System.out.println("рукоятка " + handle.getName() + " опущена");
        } else {
            System.err.println("рукоятка " + handle.getName() + "не может быть опущена/уже опущена");
        }
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }

}

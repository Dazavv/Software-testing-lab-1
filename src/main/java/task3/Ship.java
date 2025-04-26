package task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ship {

    private final String name;
    private ShipState status;
    private Direction direction;
    private static final int MAX_ENGINES = 4;
    private static final int MAX_PEOPLE = 1;
    private int handlesCount;
    private List<Engine> engines;
    private List<Man> engineers;
    private List<Handle> releasedHandles;
    private List<Handle> activeHandles;

    public Ship() {
        this.direction = Direction.FORWARD;
        this.status = ShipState.STABLE;
        this.name = null;
        this.handlesCount = 0;
        this.engines = new ArrayList<>();
        this.engineers = new ArrayList<>();
        this.activeHandles = new ArrayList<>();
        this.releasedHandles = new ArrayList<>();
    }

    public List<Man> getEngineers() {
        return engineers;
    }

    public ShipState getStatus() {
        return status;
    }

    public void shake() {
        int count = 0;
        for (Engine engine : engines) {
            if (engine.getStatus()) {
                count += 1;
            }
        }
        if (count == engines.size()) {
            this.status = ShipState.SHAKING;
        } else {
            System.err.println("не все двигатели активированы");
        }
    }
    public void attachEngine(Engine engine) {
        if (engines.size() < MAX_ENGINES) {
            engines.add(engine);
        } else {
            System.err.println("невозможно добавить еще двигатель");
        }
    }


    public void removeEngine(Engine engine) {
        if (engines.isEmpty()) {
            System.err.println("двигатели не добавлены на корабль");
        } else {
            boolean removed = false;
            Iterator<Engine> iterator = engines.iterator();
            while (iterator.hasNext()) {
                Engine e = iterator.next();
                if (e.equals(engine)) {
                    iterator.remove(); // безопасное удаление
                    System.out.println("двигатель " + engine.getName() + " удален");
                    removed = true;
                    break;
                }
            }
            if (!removed) {
                System.err.println("невозможно удалить двигатель, которого нет на корабле");
            }
        }
    }

    public void addPeopleOnShip(Man man) {
        if (engineers.size() < MAX_PEOPLE) {
            engineers.add(man);
            System.out.println("новый пассажир " + man.getName() + " добавлен");
        } else {
            System.err.println("невозможно добавить еще пассажира");
        }
    }

    public String getName() {
        return name;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean addHandleToActiveHandles(Handle handle) {
        if (!activeHandles.contains(handle) && !releasedHandles.contains(handle)) {
            activeHandles.add(handle);
            handlesCount += 1;
            return true;
        } else if (releasedHandles.contains(handle)) {
            activeHandles.add(handle);
            releasedHandles.remove(handle);
            return true;
        }
        System.err.println("рукоятка " + handle.getName() + " уже поднята");
        return false;
    }
    public boolean removeHandleFromActiveHandles(Handle handle) {
        if (!activeHandles.isEmpty() && activeHandles.contains(handle)) {
            activeHandles.remove(handle);
            releasedHandles.add(handle);
            return true;
        } else {
            System.err.println("невозможно опустить рукоятку " + handle.getName() + " или она уже опущена");
            return false;
        }
    }

    public List<Handle> getReleasedHandles() {
        return releasedHandles;
    }


    public List<Handle> getActiveHandles() {
        return activeHandles;
    }

    public void toRocket(Man man) {
        if (engineers.isEmpty() || engines.isEmpty()) {
            System.err.println("корабль не может направиться навстречу ракетам");
        } else {
            for (Man m : engineers) {
                if (m.equals(man) &&  releasedHandles.size() == handlesCount / 2) { //форд опустил половину рукояток
                    direction = Direction.TOWARD_ROCKETS;
                }
                System.err.println("корабль не может направиться навстречу ракетам");
            }
        }
    }
}

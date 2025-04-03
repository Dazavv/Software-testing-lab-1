package task3;

import java.util.List;

public class Man {
    private String name;
    private String gender;
    private String position;
    private String action;
    List<Handle> activeHandles;

    public Man(String name, String gender, String position, String action, List<Handle> activeHandles) {
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.action = action;
        this.activeHandles = activeHandles;
    }

    void grabHandle(Handle handle) {
        if (!activeHandles.contains(handle)) {
            activeHandles.add(handle);
            action = "Захватил " + handle.getName();
        }
    }
    void releaseHandle(Handle handle) {
        if (activeHandles.contains(handle)) {
            activeHandles.remove(handle);
            action = "Отпустил " + handle.getName();
        }
    }
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Handle> getActiveHandles() {
        return activeHandles;
    }

    public void setActiveHandles(List<Handle> activeHandles) {
        this.activeHandles = activeHandles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

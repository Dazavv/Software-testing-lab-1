package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DomainModelTest {
    private Man ford;
    private Handle handle1;
    private Handle handle2;

    @BeforeEach
    public void setUp() {
        List<Handle> activeHandles = new ArrayList<>();
        ford = new Man("Форд", "мужской", "на корабле", null,  activeHandles);
        handle1 = new Handle("Рукоятка 1", "управление кораблем");
        handle2 = new Handle("Рукоятка 2", "управление кораблем");
    }
    @Test
    public void testEngineStart() {
        Engine engine = new Engine(null, "двигатель корабля", "не работает");
        engine.activate();
        assertEquals("работает", engine.getStatus());
    }

    @Test
    public void testChangeDirection() {
        Ship ship = new Ship();
        Direction newDirection = new Direction("навстречу ракетам");
        ship.changeDirection(newDirection);
        assertEquals(newDirection, ship.getDirection());
    }

    @Test
    public void testShipShake() {
        Ship ship = new Ship();
        ship.shake();
        assertEquals("затрясло", ship.getStatus());
    }

    @Test
    public void testMissiles() {
        Rocket rocket = new Rocket(5);
        assertEquals(5, rocket.quantity);
    }
    @Test
    public void testInitialState() {
        assertTrue(ford.getActiveHandles().isEmpty());
        assertNull(ford.getAction());
    }

    @Test
    public void testGrabHandle() {
        ford.grabHandle(handle1);
        assertTrue(ford.getActiveHandles().contains(handle1));
        assertEquals("Захватил Рукоятка 1", ford.getAction());
    }

    @Test
    public void testReleaseHandle() {
        // проверка, что рукоятка отпущена
        ford.grabHandle(handle1);
        ford.releaseHandle(handle1);
        assertFalse(ford.getActiveHandles().contains(handle1));
        assertEquals("Отпустил Рукоятка 1", ford.getAction());
    }

    @Test
    public void testMultipleHandles() {
        ford.grabHandle(handle1);
        ford.grabHandle(handle2);
        assertTrue(ford.getActiveHandles().contains(handle1));
        assertTrue(ford.getActiveHandles().contains(handle2));
        assertEquals("Захватил Рукоятка 2", ford.getAction());
    }

    @Test
    public void testReleaseNonActiveHandle() {
        ford.releaseHandle(handle1);
        assertFalse(ford.getActiveHandles().contains(handle1));
        assertNull(ford.getAction());
    }

    @Test
    public void testActionChange() {
        ford.grabHandle(handle1);
        assertEquals("Захватил Рукоятка 1", ford.getAction());

        ford.releaseHandle(handle1);
        assertEquals("Отпустил Рукоятка 1", ford.getAction());
    }
}

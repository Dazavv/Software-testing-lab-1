package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class DomainModelTest {
    private Man ford;
    private Man passenger;
    private Handle handle1;
    private Handle handle2;
    private Engine engine1;
    private Engine engine2;
    private Ship ship;
    private final ByteArrayOutputStream content = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void before() {
        System.setErr(new PrintStream(content));
        System.setOut(new PrintStream(content));
        engine1 = new Engine("engine-1");
        engine2 = new Engine("engine-2");
        ship = new Ship();
        ford = new Man("Форд", ship);
        passenger = new Man("Пассажир", ship);
        handle1 = new Handle("Рукоятка 1", "управление кораблем");
        handle2 = new Handle("Рукоятка 2", "управление кораблем");
    }

    //White-box Testing
    //Engine tests
    @Test
    public void testEngineStart() {
        engine1.activate();
        assertTrue(engine1.getStatus());
    }
    @Test
    public void testEngineEnd() {
        engine1.activate();
        engine1.deactivate();
        assertFalse(engine1.getStatus());
    }
    @Test
    public void testEngineGetType() {
        assertEquals("двигатель корабля", engine1.getType());
    }
    @Test
    public void testEngineGetName() {
        assertEquals("engine-1", engine1.getName());
    }
    @Test
    public void testEngineRemoveFromEmptyList() {
        ship.removeEngine(engine1);
        assertTrue(content.toString().contains("двигатели не добавлены на корабль"));
    }
    @Test
    public void testEngineAttach() {
        Engine engine3 = new Engine("engine-3");
        Engine engine4 = new Engine("engine-4");
        Engine engine5 = new Engine("engine-5");
        ship.attachEngine(engine1);
        ship.attachEngine(engine2);
        ship.attachEngine(engine3);
        ship.attachEngine(engine4);
        ship.attachEngine(engine5);
        assertTrue(content.toString().contains("невозможно добавить еще двигатель"));
    }
    @Test
    public void testEngineRemoveSuccessful() {
        ship.attachEngine(engine1);
        ship.removeEngine(engine1);
        assertTrue(content.toString().contains("двигатель " + engine1.getName() + " удален"));
    }
    @Test
    public void testEngineFailRemoveUnsuccessful() {
        ship.attachEngine(engine1);
        ship.removeEngine(engine2);
        assertTrue(content.toString().contains("невозможно удалить двигатель, которого нет на корабле"));
    }

    //Handle Test
    @Test
    public void testMultipleHandles() {
        ford.grabHandle(handle1);
        ford.grabHandle(handle2);
        List<Handle> handles = ship.getActiveHandles();
        assertTrue(handles.contains(handle1));
        assertTrue(handles.contains(handle2));
    }
    @Test
    public void testReleaseHandle() {
        // проверка, что рукоятка отпущена
        ford.grabHandle(handle1);
        ford.releaseHandle(handle1);
        assertFalse(ship.getActiveHandles().contains(handle1));
        assertTrue(ship.getReleasedHandles().contains(handle1));
    }
    @Test
    public void testReleaseNonActiveHandle() {
        ford.releaseHandle(handle1);
        assertFalse(ship.getReleasedHandles().contains(handle1));
    }

    //Black-box Testing
    //Ship Test
    @Test
    public void testShipAddPeople() {
        ship.addPeopleOnShip(ford);
        List<Man> engineers = ship.getEngineers();
        assertTrue(engineers.contains(ford));
    }
    @Test
    public void testShipAddMorePeople() {
        ship.addPeopleOnShip(ford);
        ship.addPeopleOnShip(passenger);
        assertTrue(content.toString().contains("невозможно добавить еще пассажира"));
    }
    @Test
    public void testCantMoveToRocket() {
        ship.toRocket(ford);
        assertEquals(Direction.FORWARD, ship.getDirection());
    }
    @Test
    public void testMoveToRocket() {
        ship.addPeopleOnShip(ford);
        ship.attachEngine(engine1);
        ship.attachEngine(engine2);
        ford.grabHandle(handle1);
        ford.grabHandle(handle2);
        ford.releaseHandle(handle1);
        ship.toRocket(ford);
        assertEquals(Direction.TOWARD_ROCKETS, ship.getDirection());
    }
    @Test
    public void testMoveToRocket1() {
        ship.addPeopleOnShip(ford);
        ship.attachEngine(engine1);
        ship.attachEngine(engine2);
        ford.grabHandle(handle1);
        ford.grabHandle(handle2);
        ford.releaseHandle(handle1);
        ship.toRocket(ford);
        assertEquals(Direction.TOWARD_ROCKETS, ship.getDirection());
    }
    @Test
    public void testShipShake() {
        ship.attachEngine(engine1);
        ship.attachEngine(engine2);
        engine1.activate();
        engine2.activate();
        ship.shake();
        assertEquals(ShipState.SHAKING, ship.getStatus());
    }

    @Test
    public void testShipNoShake1() {
        ship.attachEngine(engine1);
        ship.attachEngine(engine2);
        assertEquals(ShipState.STABLE, ship.getStatus());
    }
    @Test
    public void testShipNoShake2() {
        ship.attachEngine(engine1);
        ship.attachEngine(engine2);
        engine1.activate();
        ship.shake();
        assertTrue(content.toString().contains("не все двигатели активированы"));
    }
    @Test
    public void testShipHasNoName() {
        assertNull(ship.getName());
    }

    //Handle Test
    @Test
    public void testHandleGetFunction(){
        assertEquals("управление кораблем", handle1.getFunction());
    }
    @Test
    public void testCantGrabHandle() {
        // проверка, что рукоятка отпущена
        ford.grabHandle(handle1);
        ford.grabHandle(handle1);
        assertTrue(content.toString().contains("не может быть поднята/уже поднята"));
    }
    @Test
    public void testCantGrabReleasedHandle() { //gray-box testing
        // проверка, что опущенную рукоятку можно поднять
        ford.grabHandle(handle1);
        ford.releaseHandle(handle1);
        ford.grabHandle(handle1);
        assertTrue(content.toString().contains("рукоятка " + handle1.getName() + " поднята"));
    }

    //Man Test
    @Test
    public void testManGetPos() {
        assertEquals("на корабле", ford.getPosition());
    }
    @Test
    public void testManGetName() {
        assertEquals("Форд", ford.getName());
    }

    @Test
    public void testInitialState() {
        assertTrue(ship.getReleasedHandles().isEmpty());
    }

    @Test
    public void testGrabHandle() {
        ford.grabHandle(handle1);
        assertTrue(ship.getActiveHandles().contains(handle1));
    }


//    @Test
//    public void testActionChange() {
//        ford.grabHandle(handle1);
//
//        ford.releaseHandle(handle1);
//        assertEquals("Отпустил Рукоятка 1", ford.getAction());
//    }
}

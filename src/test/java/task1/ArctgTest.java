package task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.ParameterizedTest;


import static org.junit.jupiter.api.Assertions.*;

public class ArctgTest {
    @Test
    public void testArctg_Zero(){
        assertEquals(0, FunctionArctg.calc(0, 100), 1e-6);
    }
    @Test
    public void testArctg_Positive(){
        assertEquals(Math.atan(0.5), FunctionArctg.calc(0.5, 100), 1e-6);
    }
    @Test
    public void testArctg_Negative(){
        assertEquals(Math.atan(-0.5), FunctionArctg.calc(-0.5, 100), 1e-6);
    }
    @Test
    public void testArctg_Boundary(){
        assertEquals(Math.atan(-1), FunctionArctg.calc(-1, 100), 1e-6);
        assertEquals(Math.atan(1), FunctionArctg.calc(1, 100), 1e-6);
    }
    @Test
    public void testArctg_Around1(){
        assertEquals(Math.atan(-0.99), FunctionArctg.calc(-0.99, 500), 1e-6);
        assertEquals(Math.atan(0.999), FunctionArctg.calc(0.999, 5000), 1e-6);
    }

    @Test
    void testArctg_OutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> FunctionArctg.calc(2, 100));
        assertThrows(IllegalArgumentException.class, () -> FunctionArctg.calc(-2, 100));
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/arctg_test_data.csv", numLinesToSkip = 1)
    void testArctg_FromCsv(double x, int n, double expected) {
        assertEquals(expected, FunctionArctg.calc(x, n), 1e-3);
    }
}

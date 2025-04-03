package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashTableTest {
    @Test
    public void testSort_WordsWSameLength(){
        String[] input = {"dog", "cat", "app"};
        String[] exp = {"app", "cat", "dog"};
        HashTable.sort(input);
        assertArrayEquals(exp, input);
    }
    @Test
    public void testSort_WordsWDiffLength(){
        String[] input = {"a", "u", "cat", "u", "summer", "computer"};
        String[] exp = {"a", "cat","computer", "summer", "u", "u"};
        HashTable.sort(input);
        assertArrayEquals(exp, input);
    }
    @Test
    public void testSort_EmptyArray(){
        String[] input = {};
        String[] exp = {};
        HashTable.sort(input);
        assertArrayEquals(exp, input);
    }
    @Test
    public void testSort_ArrayWOneString(){
        String[] input = {"cat"};
        String[] exp = {"cat"};
        HashTable.sort(input);
        assertArrayEquals(exp, input);
    }
    @Test
    public void testSort_ArrayWSpecialSymbols(){
        String[] input = {"(hhh", "apple", "?"};
        String[] exp = {"(hhh", "?", "apple"};
        HashTable.sort(input);
        assertArrayEquals(exp, input);
    }

    @Test
    public void testSort_NullArray() {
        String[] input = null;
        HashTable.sort(input);
        assertNull(input);
    }
    @Test
    public void testSort_NumbersAsStrings() {
        String[] input = {"10", "2", "1"};
        String[] exp = {"1", "10", "2"};
        HashTable.sort(input);
        assertArrayEquals(exp, input);
    }
}

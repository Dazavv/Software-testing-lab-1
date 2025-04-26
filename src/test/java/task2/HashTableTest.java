package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        String[] input = {"appppp", "a", "u", "cat", "u", "summer", "computer", "app"};
        String[] exp = {"a", "app", "appppp", "cat","computer", "summer", "u", "u"};
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
    public void testSort_SameStrings(){
        String[] input = {"cat","aa", "cat"};
        String[] exp = {"aa", "cat", "cat"};
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

    @Test
    public void testSort_CaseSensitivity() {
        String[] input = {"apple", "Apple", "banana", "Banana"};
        String[] exp = {"Apple", "Banana", "apple", "banana"};
        HashTable.sort(input);
        assertArrayEquals(exp, input);
    }

    @Test
    public void testHashFunction() {
        assertEquals(97, HashTable.hashCode("apple"));
        assertEquals(98, HashTable.hashCode("b"));
        assertEquals(40, HashTable.hashCode("("));
    }

    @Test
    public void testBucketsSorting() {
        String[] input = {"banana", "apple", "appleapple"};
        int hashApple = HashTable.hashCode("apple");
        int hashApricot = HashTable.hashCode("appleapple");
        assertEquals(hashApple, hashApricot);

        HashTable.sort(input);
        assertArrayEquals(new String[]{"apple", "appleapple", "banana"}, input);
    }

}

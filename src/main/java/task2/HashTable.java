package task2;

import java.util.*;

public class HashTable {
    static int collectionSize = 128;
    public static int hashCode(String string) {
        char firstChar = string.charAt(0);
        return Math.abs(firstChar % collectionSize);
    }

    public static void sort(String[] array) {
        if (array == null) return;
        List<String>[] buckets = new LinkedList[collectionSize];

        for (int i = 0; i < collectionSize; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (String str : array) {
            int hash = hashCode(str);
            buckets[hash].add(str);
        }

        for (List<String> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<String> bucket : buckets) {
            for (String str : bucket) {
                array[index++] = str;
            }
        }
    }
}

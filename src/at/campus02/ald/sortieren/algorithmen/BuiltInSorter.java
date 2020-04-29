package at.campus02.ald.sortieren.algorithmen;

import java.util.Arrays;

public class BuiltInSorter implements IntegerSorter {

    /**
     * Sortier-Funktion
     */
    public void sort(int[] data) {
        Arrays.sort(data);
    }
}

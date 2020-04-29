package at.campus02.ald.sortieren.experiment;

import at.campus02.ald.sortieren.algorithmen.BubbleSorter;
import at.campus02.ald.sortieren.algorithmen.IntegerSorter;
import at.campus02.ald.sortieren.algorithmen.MergeSorter;

public class SorterDemo {

    public static void main(String[] args) {
        sortDemo();
//		mergeDemo();
    }

    /**
     * Demo zum Sortieren
     */
    public static void sortDemo() {
        IntegerSorter sorter = new BubbleSorter();
//		IntegerSorter sorter = new MergeSorter();
//		IntegerSorter sorter = new QuickSorter();

        int[] data = {20, 1, 26, 8, 24, 12, 42};
        sorter.sort(data);
        print(data);
    }

    /**
     * Demo von Merge zweier Listen
     */
    public static void mergeDemo() {
        int[] array1 = {1, 8, 20, 26, 42};
        int[] array2 = {7, 18, 24, 41, 50, 66};
        int[] result = new int[array1.length + array2.length];

        MergeSorter sorter = new MergeSorter();
        sorter.merge(array1, array2, result, 0);

        print(result);
    }

    /**
     * Integer-Array ausgeben
     */
    public static void print(int[] data) {
        for (int item : data) {
            System.out.println(item);
        }
    }
}

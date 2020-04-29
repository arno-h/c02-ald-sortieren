package at.campus02.ald.sortieren.experiment;

import java.util.Arrays;
import java.util.Random;

import at.campus02.ald.sortieren.algorithmen.*;

public class Experiment {

    // für die Stoppuhr
    private long startTime;

    // Anzahl der zu sortierenden Zahlen und Testdurchläufe
    static final int ARRAY_SIZE = 15000;
    static final int TEST_RUNS_WARMUP = 750;
    static final int TEST_RUNS = 250;

    public static void main(String[] args) {
        Experiment e = new Experiment();
        e.run();
    }

    public void run() {
        int[] rnd = setUpRandomArray(ARRAY_SIZE);
        testAlgorithms("Sortieren eines zufälligen Arrays", rnd);

        int[] sorted = setUpAlmostSortedArray(ARRAY_SIZE);
        testAlgorithms("Sortieren eines fast sortierten Arrays", sorted);

        int[] inv = setUpAlmostInvertedArray(ARRAY_SIZE);
        testAlgorithms("Sortieren eines fast vollständig invertierten Arrays", inv);
    }

    public void testAlgorithms(String name, int[] base) {
        System.out.println(name);
        testSorter("Base-Time (no sort)", new NoSorter(), base);
        testSorter("Base-Time (built-in)", new BuiltInSorter(), base);
// den lassen wir aus: O(n²)! --> sonst Anzahl in run()-Funktion ändern
//		testSorter("BubbleSort", new BubbleSorter(), base);
        testSorter("HeapSort", new HeapSorter(), base);
        testSorter("MergeSort", new MergeSorter(), base);
        testSorter("QuickSort", new QuickSorter(), base);
        testSorter("QuickSort2", new QuickSorter2(), base);
        System.out.println();
    }

    public void testSorter(String name, IntegerSorter is, int[] data) {
        for (int i = 0; i < TEST_RUNS_WARMUP; i++) {
            int[] testArray = Arrays.copyOf(data, data.length);
            is.sort(testArray);
        }
        startStopWatch();
        for (int i = 0; i < TEST_RUNS; i++) {
            int[] testArray = Arrays.copyOf(data, data.length);
            is.sort(testArray);
        }
        System.out.format("%s: %.3f\n", name, elapsedTime());
    }

    public int[] setUpRandomArray(int size) {
        int[] array = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

    public int[] setUpAlmostSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        Random r = new Random();
        for (int i = 0; i < size / 20; i++) {
            int pos = r.nextInt(size);
            array[pos] = r.nextInt();
        }
        return array;
    }

    public int[] setUpAlmostInvertedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        Random r = new Random();
        for (int i = 0; i < size / 20; i++) {
            int pos = r.nextInt(size);
            array[pos] = r.nextInt();
        }
        return array;
    }

    public void startStopWatch() {
        startTime = System.currentTimeMillis();
    }

    public float elapsedTime() {
        return (System.currentTimeMillis() - startTime) / (float) TEST_RUNS;
    }
}

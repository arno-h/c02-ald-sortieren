package at.campus02.ald.sortieren.experiment;

import java.util.Arrays;

public class Experiment2 extends Experiment {

    // Maximale Größe des zu sortierenden Arrays
    static final int MAX_ARRAY_SIZE = 25600;

    public static void main(String[] args) {
        Experiment2 e = new Experiment2();
        e.run();
    }

    public void run() {
        int[] rnd = setUpRandomArray(MAX_ARRAY_SIZE);
        for (int size = 100; size <= MAX_ARRAY_SIZE; size *= 2) {
            int[] testArray = Arrays.copyOf(rnd, size);
            testAlgorithms(String.format("Sortieren von Array mit %d Einträgen", size), testArray);
        }
    }
}

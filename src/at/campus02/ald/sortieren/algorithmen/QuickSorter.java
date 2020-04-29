package at.campus02.ald.sortieren.algorithmen;

import java.util.Random;

/**
 * QuickSort, Variante 1
 * <p>
 * In dieser Implementierung wird das Array vorher zufällig durchgemischt.
 * Es wird nur eine while()-Schleife beim Sortieren für alle drei Fälle verwendet.
 */
public class QuickSorter implements IntegerSorter {

    public void sort(int[] data) {
        shuffle(data);
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = data[start];    // Pivot-Element ist das erste Element
        int i = start + 1;          // Start deshalb beim zweiten Element
        int j = end;
        while (j >= i) {            // Solange sich i & j nicht überkreuzt haben
            if (data[i] <= pivot) {          // Nächstes Element größer Pivot von vorne her suchen
                i++;
            } else if (data[j] >= pivot) {   // Nächstes Element kleiner Pivot von hinten her suchen
                j--;
            } else {                         // Beide Elemente tauschen
                swap(data, i, j);
                i++;
                j--;
            }
        }
        swap(data, start, j);                // Pivot-Element mit Element an Position j tauschen

        // Beide Hälften rekursiv sortieren
        sort(data, start, j - 1);
        sort(data, j + 1, end);
    }

    /**
     * Zwei Elemente im Array vertauschen
     */
    private void swap(int[] data, int pos1, int pos2) {
        int help = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = help;
    }

    /**
     * Array durchmischen
     *
     * @param data Integer-Array
     */
    private void shuffle(int[] data) {
        Random r = new Random();
        for (int i = data.length - 1; i > 0; i--) {
            swap(data, i, r.nextInt(i + 1));
        }
    }
}

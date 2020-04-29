package algorithmen;

import java.util.Random;

/**
 * QuickSort, Variante 2
 * <p>
 * In dieser Implementierung wird das Pivot-Element zufällig ausgewählt.
 * Es werden verschachtelte while()-Schleifen beim Sortieren verwendet.
 */
public class QuickSorter2 implements IntegerSorter {

    // Zufallsgenerator
    private final Random random;

    // Konstruktor: Zufallsgenerator anlegen
    // Geschieht hier, da Instantiierung von Random recht teuer ist
    // und daher nicht mehrfach in Rekursion gemacht werden sollte.
    public QuickSorter2() {
        random = new Random();
    }


    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }

        // Position des Pivot-Elements zufällig wählen ...
        int pvPos = start + random.nextInt(end - start + 1);
        // ... und erstes Element mit Pivot-Element tauschen
        swap(data, start, pvPos);

        int pivot = data[start];    // Pivot-Element ist nun wieder das erste Element
        int i = start + 1;            // Start deshalb beim zweiten Element
        int j = end;
        while (true) {
            while (i <= end && data[i] <= pivot) {     // Nächstes Element größer Pivot von vorne her suchen
                i++;
            }
            while (j >= i && data[j] >= pivot) { // Nächstes Element kleiner Pivot von hinten her suchen
                j--;
            }
            // Haben sich i & j überkreuzt?
            if (i >= j) {
                break;
            }
            // Tauschen
            swap(data, i, j);
            i++;
            j--;
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
}

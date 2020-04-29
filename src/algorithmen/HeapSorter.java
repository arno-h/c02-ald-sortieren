package algorithmen;


public class HeapSorter implements IntegerSorter {

    /**
     * Sortier-Funktion
     */
    public void sort(int[] data) {
        // Einen ordentlichen Max-Heap aus dem Array machen
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            sink(data, i, data.length);
        }

        // Personen der Reihe nach entnehmen
        // und entnomme Elemente ans Ende stellen
        for (int i = data.length - 1; i > 0; i--) {
            swap(data, 0, i);
            sink(data, 0, i);    // Größe == i, da Heap mit jedem Durchlauf kleiner wird
        }
    }

    /**
     * sink-Funktion des Heaps
     */
    private void sink(int[] data, int pos, int size) {
        int cur = pos;
        while (cur * 2 + 1 < size) {        // Solange Kinder existieren
            int min = maxChild(data, cur, size);
            if (data[min] <= data[cur]) {    // Person ist bereits an richtiger Stelle
                break;
            }
            swap(data, min, cur);    // sonst tauschen
            cur = min;
        }
    }

    /**
     * Gibt Position des (alphabetisch) gr��ten Kindelements retour
     */
    private int maxChild(int[] personen, int pos, int size) {
        int left = pos * 2 + 1;
        int right = pos * 2 + 2;
        if (right >= size) {    // kein rechtes Kind vorhanden
            return left;
        }
        if (personen[left] >= personen[right]) {
            return left;
        } else {
            return right;
        }
    }

    /**
     * Hilfsfunktion zum Austauschen im Array
     */
    private void swap(int[] data, int a, int b) {
        int help = data[a];
        data[a] = data[b];
        data[b] = help;
    }

}

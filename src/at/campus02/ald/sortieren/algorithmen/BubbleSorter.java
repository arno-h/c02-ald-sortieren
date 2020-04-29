package at.campus02.ald.sortieren.algorithmen;

public class BubbleSorter implements IntegerSorter {

    /**
     * Sortierfunktion
     *
     * @param data Zu sortierendes Array
     */
    public void sort(int[] data) {
        boolean exchanged = true;
        int count = 0;

        // Sortieren, bis keine Vertauschungen mehr stattfinden
        while (exchanged) {
            exchanged = false;
            // Mit jedem Durchlauf wird das Array mehr sortiert (letzte Elemente passen)
            int size = data.length - 1 - count;
            for (int i = 0; i < size; i++) {
                int a = data[i];
                int b = data[i + 1];
                if (a > b) {        // Tauschen
                    data[i] = b;
                    data[i + 1] = a;
                    exchanged = true;
                }
            }
            count++;
        }
    }
}

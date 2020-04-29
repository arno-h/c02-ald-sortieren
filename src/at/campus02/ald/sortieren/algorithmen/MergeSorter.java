package at.campus02.ald.sortieren.algorithmen;

import java.util.Arrays;


public class MergeSorter implements IntegerSorter {

    public void sort(int[] data) {
        // Start des rekursiven Aufrufs
        sort(data, 0, data.length - 1);
    }

    /**
     * Rekursive Funktion zum Sortieren eines Teils des Arrays
     *
     * @param data  Zu sortierendes Array
     * @param start Startpunkt im Array
     * @param end   Endpunkt im Array
     */
    public void sort(int[] data, int start, int end) {
        if (start == end) {        // Arrays der Länge 1 sind sortiert
            return;
        }

        int mitte = start + ((end - start) / 2);

        // Rekursiver Aufruf: Linke & rechte Hälfte sortieren
        sort(data, start, mitte);
        sort(data, mitte + 1, end);
        // Nach Rekursion: Linke und rechte Hälfte sind nun sortiert

        // Für Merge: Hälften in eigene Arrays kopieren
        // Hinweis: bei copyOfRange ist Obergrenze exklusiv, deshalb "+ 1"
        int[] teil1 = Arrays.copyOfRange(data, start, mitte + 1);
        int[] teil2 = Arrays.copyOfRange(data, mitte + 1, end + 1);
        // Beide Hälften zusammenfügen und in data-Array schreiben
        merge(teil1, teil2, data, start);
    }

    /**
     * Merge zweier Arrays in ein Ergebnis-Array
     *
     * @param array1 Erstes Array
     * @param array2 Zweites Array
     * @param result Ergebnisarray
     * @param start  Position für Speicherung in Ergebnisarray
     */
    public void merge(int[] array1, int[] array2, int[] result, int start) {
        int i = 0;
        int j = 0;
        int next = start;

        // Schleife: Vorderste Elemente vergleichen und in Ergebnisarray einfügen
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                result[next] = array1[i];
                i++;
            } else {
                result[next] = array2[j];
                j++;
            }
            next++;
        }

        // Nur einer der beiden nachfolgenden Fälle trifft zu.

        // Falls Array 1 noch Überbleibsel hat, jetzt anfügen.
        // (Alle Elemente sind größer als das größte Element in Array 2)
        for (int k = i; k < array1.length; k++, next++) {
            result[next] = array1[k];
        }

        // Falls Array 2 noch Überbleibsel hat, jetzt anfügen.
        // (Alle Elemente sind größer als das größte Element in Array 1)
        for (int k = j; k < array2.length; k++, next++) {
            result[next] = array2[k];
        }
    }

}

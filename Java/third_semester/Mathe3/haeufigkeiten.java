package third_semester.Mathe3;

import java.util.Arrays;

public class haeufigkeiten {

    public static void main(String[] args) {

        int[] werte = { 1, 1, 2, 0, 6, 4, 3, 1, 0, 0, 3, 4, 3, 2, 2, 1, 1, 2, 3, 3, 0, 0, 0, 4, 3, 2, 1, 2, 6, 3, 3, 3,
                0, 4, 1, 2, 2, 6, 2, 2 };
        int n = werte.length;

        System.out.println("Unsortierte Werte: \n" + Arrays.toString(werte) + "\n");
        Arrays.sort(werte);

        System.out.println("Sortierte Werte: \n" + Arrays.toString(werte) + "\n");

        System.out.println("Wert\t| Häufigkeit\t| relative H.\t| kumulierte H.");
        System.out.println("------------------------------------------------------");

        int modalwert = berechneHaeufigkeiten(werte, n);
        berechneKennwerte(n, werte, modalwert);
    }

    public static int berechneHaeufigkeiten(int[] werte, int n) {
        int current = werte[0];
        int count = 1;
        double kumuliert = 0.0;
        int modalwert = current;
        int maxHaeufigkeit = 0;

        for (int i = 1; i < werte.length; i++) {
            if (werte[i] == current) {
                count++;
            } else {
                double relativ = berechneRelativeHaeufigkeit(count, n);
                kumuliert = berechneKumulierteHaeufigkeit(kumuliert, relativ);
                ausgabe(current, count, relativ, kumuliert);

                // Aktualisiere Modalwert, falls nötig
                if (count > maxHaeufigkeit) {
                    maxHaeufigkeit = count;
                    modalwert = current;
                }

                current = werte[i];
                count = 1;
            }
        }

        // Letzten Wert verarbeiten
        double relativ = berechneRelativeHaeufigkeit(count, n);
        kumuliert = berechneKumulierteHaeufigkeit(kumuliert, relativ);
        ausgabe(current, count, relativ, kumuliert);

        if (count > maxHaeufigkeit) {
            modalwert = current;
        }

        return modalwert;
    }

    public static double berechneRelativeHaeufigkeit(int count, int n) {
        return (double) count / n;
    }

    public static double berechneKumulierteHaeufigkeit(double kumuliert, double relativ) {
        return kumuliert + relativ;
    }

    public static void ausgabe(int current, int count, double relativ, double kumuliert) {
        System.out.printf("%d\t| %d\t\t| %.3f\t\t| %.3f%n", current, count, relativ, kumuliert);
    }

    public static void berechneKennwerte(int n, int[] werte, int modalwert) {
        double eam = berechneEAM(n, werte);
        double median = berechneEMedian(n, werte);
        double varianz2 = berechneVarianz(n, werte, eam);
        double standartabweichung = berechneStandartabweichung(varianz2);
        double variationsK = berechneVariationsK(varianz2, eam);

        System.out.printf("\nempirisches arithmetisches Mittel: %.2f%n", eam);
        System.out.printf("empirischer Median: %.2f%n", median);
        System.out.println("empirischer Modalwert: " + modalwert);
        System.out.printf("empirische Varianz S²: %.2f%n", varianz2);
        System.out.printf("empirische Standartabweischung s: %.2f%n", standartabweichung);
        System.out.printf("empirischer Variationskoeffizient: %.2f%n", variationsK);

    }

    public static double berechneEAM(int n, int[] werte) {
        double summe = 0.0;
        for (int wert : werte) {
            summe += wert;
        }
        return summe / n;
    }

    public static double berechneEMedian(int n, int[] werte) {
        if (n % 2 == 0) {
            // Durchschnitt der beiden mittleren Werte bei gerader Anzahl
            return (werte[n / 2 - 1] + werte[n / 2]) / 2.0;
        } else {
            // Mittlerer Wert bei ungerader Anzahl
            return werte[n / 2];
        }
    }

    public static double berechneVarianz(int n, int[] werte, double eam) {
        double varianz = 0.0;
        for (int wert : werte) {
            varianz += Math.pow(wert - eam, 2);
        }
        return varianz / (n - 1);
    }

    public static double berechneVariationsK(double varianz2, double eam) {

        double varianz = Math.sqrt(varianz2);
        return varianz / eam;

    }

    public static double berechneStandartabweichung(double varianz2) {
        double standartabweichung = Math.sqrt(varianz2);
        return standartabweichung;
    }

}

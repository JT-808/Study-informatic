package Zufall;

import java.util.Random;

public class WuerfelTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int anzwuerfe = 30;
		int[] wuerfe = new int[anzwuerfe];
		int summe = 0;
		int[] haeufigkeit = new int[6];
		double[] wahrscheinlichkeit = new double[6];

		for (int i = 0; i < wuerfe.length; i++) {
			int wurf = new Random().nextInt(6) + 1;
			wuerfe[i] = wurf;
			summe += wurf;
			haeufigkeit[wurf - 1]++;
			System.out.print(wuerfe[i] + ", ");
		}
		double avg = (double) summe / (double) anzwuerfe;

		System.out.println("\nSumme: " + summe);
		System.out.println("Durchschnittswert: " + Math.round(avg * 100.0) / 100.0);
		System.out.println("*** Häufigkeitsverteilung ***");

		for (int i = 0; i < wahrscheinlichkeit.length; i++) {
			wahrscheinlichkeit[i] = ((double) haeufigkeit[i] / (double) anzwuerfe) * 100;
			System.out.println((i + 1) + ": " + haeufigkeit[i] + "x" + "(" + wahrscheinlichkeit[i] + "%)");
		}

	}

}

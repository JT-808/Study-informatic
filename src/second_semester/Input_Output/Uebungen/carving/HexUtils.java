package second_semester.Input_Output.Uebungen.carving;

/**
 * Die vorliegende Klasse stellt Hilfsmethoden zur
 * Darstellung bzw. Umwandlung von Byte-Werten in
 * Hex-Strings zur Verfuegung.
 * 
 */
public class HexUtils {

	// Alle Ziffern des Hexadezimal-Systems
	static char[] hexArray = "0123456789ABCDEF".toCharArray();

	/**
	 * Erzeugt eine String-Repraesentation der
	 * uebergebenen Byte-Werte. Ein Byte wird
	 * jeweils durch einen zweistelligen Hex-Wert
	 * repraesentiert.
	 * 
	 * @param bytes
	 * @return die erzeugte Zeichenkette
	 */
	public static String bytesToHex(byte[] bytes) {

		char[] hexChars = new char[bytes.length * 2];

		for (int j = 0; j < bytes.length; j++) {
			// vorzeichenbehaftetes Byte in vorzeichenlosen Int-Wert
			int v = bytes[j] & 0xFF;
			// half-byte bestimmen
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	/**
	 * Wandelt den uebergebenen String in ein byte[]-Array um.
	 * Dabei werden jeweils 2 Characters zu einem Byte-Wert
	 * zusammengefasst.
	 * 
	 * @param s Zeichenkette mit Hex-Werten.
	 * @return byte-Array
	 */
	public static byte[] asBytes(String s) {
		String s2;
		// zwei Zeichen in dem String definieren immer den
		// Wert eines Bytes - das entstehende Byte-Array ist
		// somit exakt halb so gross
		byte[] b = new byte[s.length() / 2];
		int i;
		for (i = 0; i < s.length() / 2; i++) {
			// Lies genau 2 Zeichen
			s2 = s.substring(i * 2, i * 2 + 2);
			// wandle diese in eine Zahl um
			b[i] = (byte) (Integer.parseInt(s2, 16) & 0xff);
		}
		return b;
	}

}

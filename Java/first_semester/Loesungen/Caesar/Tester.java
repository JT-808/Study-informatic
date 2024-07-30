
public class Tester {

	public static void main(String[] args) {
        String klartext = "Ich studiere in Mittweida";
        int verschiebung = 3;

        CaesarChiffre cc = new CaesarChiffre();
        
        String verschluesselterText = cc.verschluesseln(klartext, verschiebung);
        System.out.println("Klartext: " + klartext + " -> " + verschluesselterText);

        String entschluesselterText =cc.entschluesseln(verschluesselterText, verschiebung);
        System.out.println("Geheimtext: " + verschluesselterText + " -> " + entschluesselterText);
    }
}

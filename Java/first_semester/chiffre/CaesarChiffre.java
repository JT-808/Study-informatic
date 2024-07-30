package chiffre;

public class CaesarChiffre {

    private String zeichen = "ABCEFGHIJKLMNOPQRSTUVWXYZ";

    public String verschluesseln(String klartext, int verschiebung) {
        String verschlüsselterText = "";
        for (int i = 0; i < klartext.length(); i++) {
            char next = klartext.charAt(i);
            verschlüsselterText = verschlüsselterText + verschieben(next, verschiebung);
        }
        return verschlüsselterText;
    };

    private char verschieben(char buchstabe, int verschiebung) {
        int posBuchstabe = zeichen.indexOf(buchstabe);
        posBuchstabe += verschiebung;
        while (posBuchstabe > zeichen.length() - 1) {
            posBuchstabe -= zeichen.length();
        }
        return zeichen.charAt(posBuchstabe);
    };

}

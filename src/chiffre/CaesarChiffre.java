package chiffre;

public class CaesarChiffre {

    private String zeichen;

    public String verschlüsseln(String klartext, int verschieben) {
        String verschlüsselterText = "";
        for (int i = 0; i < klartext.length(); i++) {
            char next = klartext.charAt(i);
            verschlüsselterText = verschlüsselterText.verschieben(next, verschiebung);
        }
        return verschlüsselterText;
    };

    private char verschieben(char buchstabe, int verschiebung) {

    };

}

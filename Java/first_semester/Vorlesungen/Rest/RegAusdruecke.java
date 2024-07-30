package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegAusdruecke {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(".s");
		Matcher m = p.matcher("as");
		System.out.println(m.matches());
		
		boolean erg = Pattern.matches("M..er", "Meier");
		System.out.println(erg);

	}

}

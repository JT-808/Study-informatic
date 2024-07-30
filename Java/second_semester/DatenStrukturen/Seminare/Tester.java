
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnwendungSetMap asm = new AnwendungSetMap();
		
		System.out.println(asm);
		
		asm.einfuegen("Knut Altroggen", "knut.altroggen@hs-mittweida.de");
		
		System.out.println(asm);
		
		asm.einfuegen("Klaus Dohmen", "dohmen@hs-mittweida.de");
		
		System.out.println(asm);
		
		asm.einfuegen("Knut Altroggen", "altrogge@hs-mittweida.de");
		asm.einfuegen("Knut Altroggen", "kaltrogg@hs-mittweida.de");
		
		System.out.println(asm);

	}

}

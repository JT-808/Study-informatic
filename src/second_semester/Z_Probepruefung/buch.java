package second_semester.Z_Probepruefung;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class buch {

    static TreeMap<Integer, String> buchliste;

    public buch(){
       buchliste = new TreeMap<Integer, String>(); 
    }

    public void addbuch(Integer ISBN, String name){
      buchliste.put(ISBN, name);
    }

    public static void gibAlleAus(){

       for (Entry<Integer, String> entry : buchliste.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            //getKey = ISBN (der Index)
            //GetValue= Name (Wert)
    }
   }


private static String returnName (Integer ISBN) {

   String str = "";
   
   if (buchliste.containsKey(ISBN)) {
   str += buchliste.get(ISBN);
   } else {
   str += "Nicht vorhanden";
   }
   
   return str;
   
   }

    
    public static void main(String[] args) {

       buch bl = new buch();
       bl.addbuch(122, "irgendein Buch");
       bl.addbuch(124, "noch ein Buch");
       bl.addbuch(102, "anderes Buch");

       System.out.println(returnName(124));

       System.out.println("\n");


       

      gibAlleAus();

       

       



        
    }
}

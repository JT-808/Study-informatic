
public class SuchenLuecke {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {0,1,2,3,4,5,6,8,9};
		sucheNachLuecke(arr);
	}
	
	private static void sucheNachLuecke(int[] arr) {
		//falls max.Wert - min. Wert <= Laenge -1 -> keine Luecke
		//bei sortierter Menge
		
		if(arr[arr.length - 1] - arr[0] <= arr.length -1) {
			System.out.println("keine Luecke");
		}else {
			int luecke = sucheRek(arr,0, arr.length - 1);
			System.out.println(luecke);
		}
	}
	
	private static int sucheRek(int[] arr, int von , int bis) {
		int nichtEnthalten;
		if(bis == von + 1) {
			nichtEnthalten = arr[von]+1;
		}else {
			int pivot = (von + bis)/2;
			if(arr[pivot] - arr[von] > pivot - von) {
				//Luecke liegt zwischen von ... pivot
				nichtEnthalten = sucheRek(arr,von,pivot);
			}else {
				//Luecke liegt zwischen pivot ... bis
				nichtEnthalten = sucheRek(arr,pivot,bis);
			}
		}
		return nichtEnthalten;
	}

}

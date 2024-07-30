package second_semester.BauemeUndGraphen.Seminare.Bauemchen;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyTree<Integer> baum = new MyTree<Integer>();
		
		baum.insert(5);
		baum.insert(3);
		baum.insert(7);
		baum.insert(2);
		baum.insert(4);
		baum.insert(6);
		baum.insert(8);
		baum.insert(1);

		
		System.out.println(baum.preOrder());
	}

}

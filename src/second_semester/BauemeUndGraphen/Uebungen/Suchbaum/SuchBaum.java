package second_semester.BauemeUndGraphen.Uebungen.Suchbaum;

import second_semester.BauemeUndGraphen.Seminare.Bauemchen.MyTree;

public class SuchBaum {
	private Node root;

	public SuchBaum() {
		root = null;//leerer Baum
	}

	public SuchBaum(Node k) {
		root = k;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public boolean member(int key) {
		boolean erg = false;
		if(root == null) {
			return erg;
		}else {
			if(root.getKey()== key) {
				//Daten sind gleich den DAten in der Wurzel? ->true
				erg = true;
				return erg;
			}else {
				//DAten sind nicht das Wurzelelement
				//Daten sind entweder groesser oder kleiner als das
				//Wurzelelement
				
				if(key < root.getKey()){
					//DAten sind kleiner als das Wurzelelement
					//-> im linken Teilbaum weitersuchen
					SuchBaum left = new SuchBaum(root.getLchild());
					return left.member(key);

				}else {
					//Daten sind groesser als das Wurzelelement
					//-> im rechten TEilbaum weitersuchen
					// wenn etwas gefunden wird -> true
					SuchBaum right= new SuchBaum(root.getRchild());
					return right.member(key);
					}
				
				}
			}
		}
	
	public Node find(int key) {
			if(root == null) {
				return null;
			}else {
				if(root.getKey()== key) {
					//Daten sind gleich den DAten in der Wurzel
					// -> Wurzel zurueck
					return root;
				}else {
					//DAten sind nicht das Wurzelelement
					//Daten sind entweder groesser oder kleiner als das
					//Wurzelelement
					
					if(key < root.getKey()){
						//DAten sind kleiner als das Wurzelelement
						//-> im linken Teilbaum weitersuchen
						SuchBaum left = new SuchBaum(root.getLchild());
						return left.find(key);
					}else {
						//Daten sind groesser als das Wurzelelement
						//-> im rechten TEilbaum weitersuchen
						SuchBaum right= new SuchBaum(root.getRchild());
						return right.find(key);
					}
				}
			}
		}

	public void insert(int key) {
	if(root == null) {
			//noch kein Baum vorhanden, nur der leere Baum
			//Daten werden die Wurzel
			root = new Node(key);
		}else {
			//in der Wurzel steht etwas
			if(key == root.getKey()) {
				//DAten und Daten aus Wurzel sind gleich
				System.out.println("keine doppelten Werte");
			}else {
				//kleiner oder groesser als Wurzel?
				
				if(key< root.getKey()){
					//sind Daten(Key) kleiner als die Daten in der Wurzel
					//links der Wurzel einfuegen
					
					SuchBaum left = new SuchBaum(root.getLchild());
					left.insert(key);
					root.setLchild(left.root);
				}
				
				if(key>root.getKey()) {
					//Daten sind groesser als die DAten in der Wurzel
					//rechts der Wurzel einfuegen
					SuchBaum right = new SuchBaum(root.getRchild());
					right.insert(key);
					root.setRchild(right.root);
				}
			}
		}
	}





/*
 * 
 * 
 *  NOCH BEENDEND!
 * 
 */
	public void delete(int key) {
		//wenn gesuchte Zahl im Baum gefunden (=true)
		if (member(key)) {
			if(root.getLchild()== null && root.getRchild()==null){
				root=null;
				
			}else if (root.getLchild()==null){
				root=root.getRchild();
				
			}else if (root.getRchild()==null){
				root=root.getLchild();
			}else{

				if(key < root.getKey()) {
					SuchBaum left = new SuchBaum(root.getLchild());
					left.delete(key);
					root.setLchild(left.root);
				}
				// Fall 2: rechter Teilbaum ist leer
				else if (key > root.getKey()) {
					SuchBaum right = new SuchBaum(root.getRchild());
					right.delete(key);
					root.setRchild(right.root);
				}
			}

			// if (root.getLchild() == null) {
            //     root.setLchild(root.getRchild());

			// Fall 1: linker Teilbaum ist leer
			
	

			// }else if (key > root.getKey()) {
			// 	root.setRchild(root.getLchild());
				
			// }		
		
		} else {
			System.out.println("nicht vorhanden");
		}
	}
}
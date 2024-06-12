package second_semester.BauemeUndGraphen.Uebungen.Suchbaum;

public class SuchBaum_Paul {
	private Node root;

	public SuchBaum() {
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
		if(root == null) {
			return false;
		}else {
			
			if(root.getKey() == key) {
				return true;
			}else {
				
				if((key - root.getKey()) < 0) {
					SuchBaum links = new SuchBaum(root.getLchild());
					return links.member(key);
				}else {
					SuchBaum rechts = new SuchBaum(root.getRchild());
					return rechts.member(key);
				}
				
			} 		
			
		}
	
	}
	
	

	public Node find(int key) {

		if(root == null) {
			return null;
		}else {
			
			if(root.getKey() == key) {
				return root;
			}else {
				
				if((key - root.getKey()) < 0) {
					SuchBaum links = new SuchBaum(root.getLchild());
					return links.find(key);
				}else {
					SuchBaum rechts = new SuchBaum(root.getRchild());
					return rechts.find(key);
				}
				
			} 		
			
		}
	
	}

	public void insert(int key) {

		if(root == null) {
			root= new Node(key);
		}else {
			
			if(key == root.getKey()) {
				System.out.println("Keine doppelten Werte");
			}else {
				
				if((key - root.getKey()) < 0) {
					SuchBaum links = new SuchBaum(root.getLchild());
					links.insert(key);
					root.setLchild(links.root);
					
				}
				
				if((key - root.getKey()) >0){
					SuchBaum rechts = new SuchBaum(root.getRchild());
					rechts.insert(key);
					root.setRchild(rechts.root);
					
				}
				
			}
			
		}
		
	}

	public void delete(int key) {

		root = deleteRec(root, key);
		
	}

	private Node deleteRec(Node root2, int value) {
		// TODO Auto-generated method stub

		if (root == null) {
            return root;
        }

        // Wert im linken Teilbaum suchen
        if (value < root.getKey()) {
            root.setLchild(
            		deleteRec(root.getLchild(), value)
            		); 
        }
        // Wert im rechten Teilbaum suchen
        else if (value > root.getKey()) {
            root.setRchild(
            		deleteRec(root.getRchild(), value)
            		); 
        }
        // Wert gefunden
        else {
            // Fall 1: linker Teilbaum ist leer
            if (root.getLchild() == null) {
                return root.getRchild();
            }
            // Fall 2: rechter Teilbaum ist leer
            else if (root.getRchild() == null) {
                return root.getLchild();
            }


        }

        return root;
		

	}
}

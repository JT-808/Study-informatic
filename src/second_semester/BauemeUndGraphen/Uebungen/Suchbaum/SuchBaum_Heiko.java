package application;

public class SuchBaum {
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
		if(find(key,false) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Node find(int key, boolean verbose) {
		int ebene = 0;
		Node ret = null;
		Node parent = null;
		
		if(root != null) {
			if(key == root.getKey()) {
				ret = root;
			} else {
				ebene++;
				parent = root;
				while(parent != null) {
					if(parent.getLchild() != null && parent.getLchild().getKey() == key) {
						ret = parent.getLchild();
						break;
					}else if(parent.getRchild() != null && parent.getRchild().getKey() == key) {
						ret = parent.getRchild();
						break;
					} else {
						if(key <= parent.getKey()) {
							parent = parent.getLchild();
							ebene++;
						}else {
							parent = parent.getRchild();
							ebene++;
						}
					}
				}
			}
		} else {
			System.out.println("Es existiert keine Wurzel.");
		}
		
		if(verbose) {
			if(ret != null) {
				System.out.println("Knoten " + ret.getKey() + " gefunden in Ebene " + ebene);
			} else {
				System.out.println("Knoten " + key + " nicht gefunden");
			}
		}
		
		ebene = 0;
		return ret;		
	}

	public void insert(int key) {
		Node parent = null;
		if(root == null) {
			root = new Node(key);
		} else {
			parent = root;
			while(parent != null) {
				if(key <= parent.getKey()) {
					if(parent.getLchild() == null) {
						parent.setLchild(new Node(key));
						parent.getLchild().setParent(parent);	// für delete
						break;
					} else {
						parent = parent.getLchild();
					}
				}else {
					if(parent.getRchild() == null) {
						parent.setRchild(new Node(key));
						parent.getRchild().setParent(parent);	// für delete
						break;
					} else {
						parent = parent.getRchild();
					}
				}
			}
		}
	}
	
	public void delete(int key) {
		
		Node target = find(key,false);		
		if(target != null) {
			Node parent = target.getParent();
			if(parent != null) {
				switch(target.countChilds()) {
				case 0:		// kein Kind (Blatt): verbinde Elternknoten mit Kindknoten
					if(parent.getLchild() == target) {
						parent.setLchild(null);
					}else if(parent.getRchild() == target) {
						parent.setRchild(null);
					}
					break;
				
				case 1:		// ein Kind: verbinde child mit parent "über Kreuz"
					if(target.getLchild() != null) {
						target.getLchild().setParent(target.getParent());
						target.getParent().setLchild(target.getLchild());
					} else if(target.getRchild() != null){
						target.getRchild().setParent(target.getParent());
						target.getParent().setRchild(target.getRchild());
					}
					break;
					
				case 2:
					target.getLchild().setParent(target.getParent());
					target.getParent().setLchild(target.getLchild());
					
					target.getRchild().setParent(target.getParent());
					target.getParent().setRchild(target.getRchild());
					break;
				}
			} else {
				root = null;
			}
		}		
	}
}
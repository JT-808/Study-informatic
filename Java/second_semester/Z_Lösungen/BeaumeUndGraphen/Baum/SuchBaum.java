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
		boolean erg = false;
		if (root.getKey() == key) {
			erg = true;
		} else {
			if (root.getLchild() != null) {
				SuchBaum sbl = new SuchBaum(root.getLchild());
				erg = erg || sbl.member(key);
			}
			if (root.getRchild() != null) {
				SuchBaum sbr = new SuchBaum(root.getRchild());
				erg = erg || sbr.member(key);
			}
		}
		return erg;
	}

	public Node find(int key) {
		if (root == null) {
			return null;
		} else {
			if (root.getKey() < key) {
				SuchBaum r = new SuchBaum(root.getRchild());
				return r.find(key);
			} else {
				if (root.getKey() > key) {
					SuchBaum l = new SuchBaum(root.getLchild());
					return l.find(key);
				} else {
					return root;
				}
			}
		}
	}

	public void insert(int key) {
		if (root == null) {
			root = new Node(key);
			System.out.println("Eingefuegt");
		} else {
			if (key == root.getKey()) {
				System.out.println("Schluessel schon vorhanden");
			} else {
				if (key < root.getKey()) {
					SuchBaum lch = new SuchBaum(root.getLchild());
					lch.insert(key);
					root.setLchild(lch.getRoot());
				}
				if (key > root.getKey()) {
					SuchBaum rch = new SuchBaum(root.getRchild());
					rch.insert(key);
					root.setRchild(rch.getRoot());
				}
			}
		}
	}

	public void delete(int key) {
		if (root.getKey() > key) // im linken TB
		{
			System.out.println("links weiter");
			SuchBaum ltb = new SuchBaum(root.getLchild());
			ltb.delete(key);
			root.setLchild(ltb.getRoot());
		} else {
			if (root.getKey() < key) // im rechten TB
			{
				System.out.println("rechts weiter");
				SuchBaum rtb = new SuchBaum(root.getRchild());
				rtb.delete(key);
				root.setRchild(rtb.getRoot());
			} else // root zu loeschen
			{
				System.out.println("root loeschen");
				if (root.getLchild() != null) {
					System.out.println("links max hoch");
					Node vknot = root;
					Node knot = vknot.getLchild();
					if (knot.getRchild() == null) {
						root.setKey(knot.getKey());
						root.setLchild(knot.getLchild());
					} else {
						while (knot.getRchild() != null) {
							vknot = knot;
							knot = knot.getRchild();
						}
						root.setKey(knot.getKey());
						root.setRchild(knot.getLchild());
					}
				} else {
					if (root.getRchild() != null) {
						System.out.println("rechts hoch");
						root = root.getRchild();
					} else {
						root = null;
					}
				}

			}
		}

	}
}
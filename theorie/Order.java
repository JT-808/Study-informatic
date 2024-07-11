

	/*
	 *								K
	 *						 /			   \
	 *						L				V 
	 *					 /	   \		 /	   \
	 *					M		J		A		Z
	 *						   /	   / \
	 *						  X	      W   B
	 *
		Pre-Order Traversierung (Vorderordnung)
		Zuerst der Knoten selbst, dann der linke Unterbaum und 
		danach der rechte Unterbaum.
		Reihenfolge: K, L, M, J, X, V, A, W, B, Z

		In-Order Traversierung (Symmetrische Ordnung)
		Zuerst der linke Unterbaum, dann der Knoten selbst und 
		danach der rechte Unterbaum.
		Reihenfolge: M, L, X, J, K, W, A, B, V, Z
		
		Post-Order Traversierung (Nachordnung)
		Zuerst der linke Unterbaum, dann der rechte Unterbaum 
		und danach der Knoten selbst.
		Reihenfolge: M, X, J, L, W, B, A, Z, V, K
	 */							



// Klasse Node als Beispiel
class Node {
    char value;
    Node left;
    Node right;

    Node(char value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class Order {
    public static void main(String[] args) {
        // Baumknoten erstellen
        Node K = new Node('N');
        Node L = new Node('H');
        Node V = new Node('F');
        Node M = new Node('D');
        Node J = new Node('A');
        Node A = new Node('E');
        Node Z = new Node('G');
        Node X = new Node('I');
        Node W = new Node('S');
        Node B = new Node('R');

        // Baumstruktur aufbauen
        K.left = L;
        K.right = V;
        L.left = M;
        L.right = J;
        J.left = X;
        V.left = A;
        V.right = Z;
        A.left = W;
        A.right = B;

        // Traversierungen ausgeben
        System.out.print("Pre-Order: ");
        preOrder(K);
        System.out.println();
        
        System.out.print("In-Order: ");
        inOrder(K);
        System.out.println();
        
        System.out.print("Post-Order: ");
        postOrder(K);
        System.out.println();
    }

    // Pre-Order Traversierung
    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // In-Order Traversierung
    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // Post-Order Traversierung
    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
}


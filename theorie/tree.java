import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class tree {
    public static void main(String[] args) {
        // Baumknoten erstellen
        Node K1 = createPreOrderTree();
        Node K2 = createPostOrderTree();

        // Pre-Order Baum Traversierungen ausgeben
        System.out.println("Pre-Order Baum:");
        System.out.print("Pre-Order: ");
        preOrder(K1);
        System.out.println();

        System.out.print("In-Order: ");
        inOrder(K1);
        System.out.println();

        System.out.print("Post-Order: ");
        postOrder(K1);
        System.out.println();

        // Höhe des Pre-Order Baumes berechnen und ausgeben
        int height1 = getHeight(K1);
        System.out.println("Höhe des Pre-Order Baumes: " + height1);

        // Anzahl der Knoten im Pre-Order Baum berechnen und ausgeben
        int nodeCount1 = countNodes(K1);
        System.out.println("Anzahl der Knoten im Pre-Order Baum: " + nodeCount1);

        // Anzahl der Blätter im Pre-Order Baum berechnen und ausgeben
        int leafCount1 = countLeaves(K1);
        System.out.println("Anzahl der Blätter im Pre-Order Baum: " + leafCount1);

        // Pre-Order Baum visuell darstellen
        System.out.println("Pre-Order Baum visuelle Darstellung:");
        printTree(K1);

        // Post-Order Baum Traversierungen ausgeben
        System.out.println("Post-Order Baum:");
        System.out.print("Pre-Order: ");
        preOrder(K2);
        System.out.println();

        System.out.print("In-Order: ");
        inOrder(K2);
        System.out.println();

        System.out.print("Post-Order: ");
        postOrder(K2);
        System.out.println();

        // Höhe des Post-Order Baumes berechnen und ausgeben
        int height2 = getHeight(K2);
        System.out.println("Höhe des Post-Order Baumes: " + height2);

        // Anzahl der Knoten im Post-Order Baum berechnen und ausgeben
        int nodeCount2 = countNodes(K2);
        System.out.println("Anzahl der Knoten im Post-Order Baum: " + nodeCount2);

        // Anzahl der Blätter im Post-Order Baum berechnen und ausgeben
        int leafCount2 = countLeaves(K2);
        System.out.println("Anzahl der Blätter im Post-Order Baum: " + leafCount2);

        // Post-Order Baum visuell darstellen
        System.out.println("Post-Order Baum visuelle Darstellung:");
        printTree(K2);
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

    // Höhe des Baumes berechnen
    public static int getHeight(Node node) {
        if (node == null) return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Anzahl der Knoten berechnen
    public static int countNodes(Node node) {
        if (node == null) return 0;
        int leftCount = countNodes(node.left);
        int rightCount = countNodes(node.right);
        return leftCount + rightCount + 1;
    }

    // Anzahl der Blätter berechnen
    public static int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        int leftLeaves = countLeaves(node.left);
        int rightLeaves = countLeaves(node.right);
        return leftLeaves + rightLeaves;
    }

    // Baum visuell darstellen
    public static void printTree(Node root) {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<Node> level = new ArrayList<Node>();
        List<Node> next = new ArrayList<Node>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (Node n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(n.value);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                float a = f.length();
                float b = (float) (perpiece - a) / 2f;
                int c = (int) Math.ceil(b);
                int d = (int) Math.floor(b);

                for (int k = 0; k < c; k++) {
                    System.out.print(" ");
                }

                System.out.print(f);
                for (int k = 0; k < d; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }

    // Pre-Order Baum erstellen
    public static Node createPreOrderTree() {
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

        K.left = L;
        K.right = V;
        L.left = M;
        L.right = J;
        J.left = X;
        V.left = A;
        V.right = Z;
        A.left = W;
        A.right = B;

        return K;
    }

    // Post-Order Baum erstellen
    public static Node createPostOrderTree() {
        Node K = new Node('K');
        Node L = new Node('L');
        Node V = new Node('V');
        Node M = new Node('M');
        Node J = new Node('J');
        Node A = new Node('A');
        Node Z = new Node('Z');
        Node X = new Node('X');
        Node W = new Node('W');
        Node B = new Node('B');

        K.left = L;
        K.right = V;
        L.left = M;
        L.right = J;
        J.left = X;
        V.left = A;
        V.right = Z;
        A.left = W;
        A.right = B;

        return K;
    }
}

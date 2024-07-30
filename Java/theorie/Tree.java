

import java.util.*;

class TreeNode {

    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Tree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie die Zeichen für Preorder ein (z.B. a b d e c f):");
        String preorderInput = scanner.nextLine();
        System.out.println("Bitte geben Sie die Zeichen für Postorder ein (z.B. d e b f c a):");
        String postorderInput = scanner.nextLine();

        char[] preorderValues = preorderInput.replaceAll("\\s+", "").toCharArray();
        char[] postorderValues = postorderInput.replaceAll("\\s+", "").toCharArray();

        if (preorderValues.length != postorderValues.length) {
            System.out.println("Ungültige Eingabe: Die Anzahl der Elemente in Preorder und Postorder stimmt nicht überein.");
            return;
        }

        TreeNode root = constructTree(preorderValues, postorderValues);

        System.out.println("Inorder Traversierung des konstruierten Baumes:");
        inorderTraversal(root);

        System.out.println("\n\nVisuelle Darstellung des Baumes:");
        printTree(root);
    }

    public static TreeNode constructTree(char[] preorder, char[] postorder) {
        if (preorder.length == 0 || postorder.length == 0) {
            return null;
        }

        char rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        if (preorder.length == 1) {
            return root;
        }

        // Find the root of the left subtree in postorder
        char leftSubtreeRootValue = preorder[1];
        int leftSubtreeRootIndex = findIndex(postorder, leftSubtreeRootValue);

        // Elements for left and right subtrees
        char[] leftSubtreePreorder = Arrays.copyOfRange(preorder, 1, leftSubtreeRootIndex + 2);
        char[] rightSubtreePreorder = Arrays.copyOfRange(preorder, leftSubtreeRootIndex + 2, preorder.length);

        char[] leftSubtreePostorder = Arrays.copyOfRange(postorder, 0, leftSubtreeRootIndex + 1);
        char[] rightSubtreePostorder = Arrays.copyOfRange(postorder, leftSubtreeRootIndex + 1, postorder.length - 1);

        root.left = constructTree(leftSubtreePreorder, leftSubtreePostorder);
        root.right = constructTree(rightSubtreePreorder, rightSubtreePostorder);

        return root;
    }

    public static int findIndex(char[] arr, char value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void printTree(TreeNode root) {
        List<List<String>> lines = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();

        level.add(root);
        int nn = 1;
        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();
            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(n.val);
                    line.add(aa);
                    if (aa.length() > widest) {
                        widest = aa.length();
                    }

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) {
                        nn++;
                    }
                    if (n.right != null) {
                        nn++;
                    }
                }
            }

            if (widest % 2 == 1) {
                widest++;
            }

            lines.add(line);

            List<TreeNode> tmp = level;
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
                            if (j < line.size() && line.get(j) != null) {
                                c = '└';
                            }
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
                if (f == null) {
                    f = "";
                }
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
}

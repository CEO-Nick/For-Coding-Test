import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        void insert(int value) {
            if (this.value > value) {
                if (this.left == null) this.left = new Node(value);
                else this.left.insert(value);
            } else {
                if (this.right == null) this.right = new Node(value);
                else this.right.insert(value);
            }
        }
    }

    public static Node tree;

    public static void main(String[] args) throws IOException {
        makeTree();
        postTraversal(tree);
    }

    private static void makeTree() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) break;
            tree.insert(Integer.parseInt(input));
        }
    }

    private static void postTraversal(Node tree) {
        if (tree == null) return;
        postTraversal(tree.left);
        postTraversal(tree.right);
        System.out.println(tree.value);
    }

}

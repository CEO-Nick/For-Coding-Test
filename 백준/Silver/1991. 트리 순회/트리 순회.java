
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Integer>[] tree;
    public static boolean[] check;
    public static char[] answer;
    public static int idx;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        tree = new ArrayList[26];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            char node1 = sc.next().charAt(0);
            char node2 = sc.next().charAt(0);
            char node3 = sc.next().charAt(0);
            if (node2 != '.') {
                tree[node1-'A'].add(node2-'A');
            } else {
                tree[node1-'A'].add(0);
            }
            if (node3 != '.') {
                tree[node1-'A'].add(node3-'A');
            } else {
                tree[node1-'A'].add(0);
            }
        }

        check = new boolean[26];
        answer = new char[n];
        idx = 0;
        preorder(0);
        for (int i = 0; i < n; i++) System.out.print(answer[i]);
        System.out.println();

        check = new boolean[26];
        answer = new char[n];
        idx = 0;
        inorder(0);
        for (int i = 0; i < n; i++) System.out.print(answer[i]);
        System.out.println();

        check = new boolean[26];
        answer = new char[n];
        idx = 0;
        postorder(0);
        for (int i = 0; i < n; i++) System.out.print(answer[i]);
        System.out.println();
    }

    private static void preorder(int node) {
        check[node] = true;
        answer[idx++] = (char) (node + 'A');
        Integer left = tree[node].get(0);
        Integer right = tree[node].get(1);

        if (!check[left] && left != 0) preorder(left);
        if (!check[right] && right != 0) preorder(right);
    }

    private static void inorder(int node) {
        check[node] = true;
        Integer left = tree[node].get(0);
        Integer right = tree[node].get(1);

        if (!check[left] && left != 0) inorder(left);
        answer[idx++] = (char) (node + 'A');
        if (!check[right] && right != 0) inorder(right);
    }

    private static void postorder(int node) {
        check[node] = true;
        Integer left = tree[node].get(0);
        Integer right = tree[node].get(1);

        if (!check[left] && left != 0) postorder(left);
        if (!check[right] && right != 0) postorder(right);
        answer[idx++] = (char) (node + 'A');
    }

}

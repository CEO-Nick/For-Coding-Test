
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Integer>[] tree;
    public static boolean[] check;
    public static int count;
    public static int delNode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        int parentNode = 0;
        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();

            if (parent != -1) tree[parent].add(i);
            else parentNode = i;
        }

        delNode = sc.nextInt();
        check = new boolean[n];
        count = 0;
        deleteNode(parentNode);
        check = new boolean[n];
        if (parentNode != delNode) countLeafNodeWithoutDelNode(parentNode);
        System.out.println(count);
    }

    public static void deleteNode(int node) {
        check[node] = true;
        for (int i = 0; i < tree[node].size(); i++) {
            int child = tree[node].get(i);
            if (child == delNode) tree[node].remove(i);
            else if (!check[child]) deleteNode(child);

        }
    }

    public static void countLeafNodeWithoutDelNode(int node) {
        check[node] = true;
        if (tree[node].isEmpty()) {
            count++;
        } else {
            for (int i = 0; i < tree[node].size(); i++) {
                Integer child = tree[node].get(i);
                if (!check[child]) {
                    countLeafNodeWithoutDelNode(child);
                }
            }
        }
    }
}

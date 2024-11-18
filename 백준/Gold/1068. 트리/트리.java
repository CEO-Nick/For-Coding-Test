import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static int n;
  static List<Integer>[] tree;
  static int del;
  static int count = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    tree = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      tree[i] = new ArrayList<>();
    }

    int root = 0;
    for (int i = 0; i < n; i++) {
      int parent = sc.nextInt();
      if (parent == -1) {
        root = i;
        continue;
      }
      tree[parent].add(i);
    }

    del = sc.nextInt();

    traversal(root);
    System.out.println(count);
  }

  static void traversal(int node) {
    if (node == del) return;
    if (tree[node].isEmpty()) {
      count++;
      return;
    }

    // 자식 노드들이 모두 제거 노드인 경우 검증
    boolean hasNoChild = true;
    for (int i = 0; i < tree[node].size(); i++) {
      if (tree[node].get(i) != del) {
        hasNoChild = false;
        break;
      }
    }
    if (hasNoChild) {
      count++;
      return;
    }

    for (int i = 0; i < tree[node].size(); i++) {
      int nextNode = tree[node].get(i);
      if (nextNode == del) continue;
      traversal(nextNode);
    }
  }

}
